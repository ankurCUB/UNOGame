package com.example.unogame.gameScreen.unoGame;


import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.card.CardFactory;
import com.example.unogame.gameScreen.card.SimpleCardFactory;
import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.ComputerPlayer;
import com.example.unogame.gameScreen.player.HumanPlayer;
import com.example.unogame.gameScreen.player.Player;
import com.example.unogame.gameScreen.player.playStrategy.EasyPlayStrategy;

import java.util.ArrayList;
import java.util.Random;

public class UNOBoard {
    private final UserDataModel userDataModel;
    public ArrayList<Card> cards = new ArrayList<>();
    public Card topDeck;
    private final ArrayList<Player> players = new ArrayList<>();

    public UNOBoard(UserDataModel userDataModel){
        this.userDataModel = userDataModel;
    }

    public void generateBoard(){
        generatePlayers();
        generateDeck();
        dealCards();
        // set top deck and playing color (must be a number card to start for simplicity
        for(Card c: cards){
            if (c.getClass().getSimpleName().equals("NumberCard")){
                topDeck = c;
                cards.remove(c);
                break;
            }
        }
    }

    private void generatePlayers() {
        // will comment this back in when human player is complete.
        //players.add(new HumanPlayer(userDataModel));
        for (int i = 0; i < 4; i++) {
            UserDataModel computerUserDataModel = new UserDataModel((int) System.currentTimeMillis(), "Bot");
            players.add(new ComputerPlayer(computerUserDataModel, new EasyPlayStrategy()));
        }
    }

    private void generateDeck(){
        CardFactory cardFactory = new SimpleCardFactory();
        // generate number cards (one of each 0 and 9 card and 2 of every number between 1 and 8 for each color)
        for(int i = 0; i < 10; i++){
            for(int j = 1; j < 5; j++){
                if(i == 0 || i == 9) {
                    cards.add(cardFactory.getCard("Number", j, String.valueOf(i)));
                } else{
                    cards.add(cardFactory.getCard("Number", j, String.valueOf(i)));
                    cards.add(cardFactory.getCard("Number", j, String.valueOf(i)));
                }
            }
        }
        // generate special cards. 2 of each (+2, Reverse, and Skip) per color
        for(int i = 1; i < 5; i++){
            cards.add(cardFactory.getCard("Draw Two", i));
            cards.add(cardFactory.getCard("Draw Two", i));
            cards.add(cardFactory.getCard("Skip", i));
            cards.add(cardFactory.getCard("Skip", i));
            cards.add(cardFactory.getCard("Reverse", i));
            cards.add(cardFactory.getCard("Reverse", i));
        }
        // generate 4 of each for +4 and WildCards
        cards.add(cardFactory.getCard("Draw Four"));
        cards.add(cardFactory.getCard("Draw Four"));
        cards.add(cardFactory.getCard("Draw Four"));
        cards.add(cardFactory.getCard("Draw Four"));
        cards.add(cardFactory.getCard("Wild Card"));
        cards.add(cardFactory.getCard("Wild Card"));
        cards.add(cardFactory.getCard("Wild Card"));
        cards.add(cardFactory.getCard("Wild Card"));
    }

    private void dealCards(){
        Random rand = new Random();
        // deal 7 cards for each player, subtracting them from the cards deck each time one is dealt
        for(int i = 0; i < 7; i++){
            for (Player player : players) {
                int index = rand.nextInt(cards.size() - 1);
                player.playerData.deck.add(cards.get(index));
                cards.remove(index);
            }
        }
    }

    public void dealSingleCard(Player player){
        Random rand = new Random();
        int index = rand.nextInt(cards.size() - 1);
        player.playerData.deck.add(cards.get(index));
        cards.remove(index);
        // if the deck for dealing is exhausted, create a new one
        if(cards.size() == 0){
            generateDeck();
        }
    }

    public boolean victoryCheck(){
        // if any of the players have 0 cards in deck, victory has been achieved
        for (Player p: players) {
            if (p.playerData.deck.size() == 0){
                return true;
            }
        }
        return false;
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    public int getNumPlayers(){return players.size();}
}
