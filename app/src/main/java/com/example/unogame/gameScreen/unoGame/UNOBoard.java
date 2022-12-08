package com.example.unogame.gameScreen.unoGame;


import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.example.unogame.R;
import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.card.CardFactory;
import com.example.unogame.gameScreen.card.SimpleCardFactory;
import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.ComputerPlayer;
import com.example.unogame.gameScreen.player.HumanPlayer;
import com.example.unogame.gameScreen.player.Player;
import com.example.unogame.gameScreen.player.playStrategy.CardType;
import com.example.unogame.gameScreen.player.playStrategy.EasyPlayStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UNOBoard {
    private final UserDataModel userDataModel;
    public ObservableArrayList<Card> cards = new ObservableArrayList<>();
    private final List<Player> players = new ArrayList<>();
    public final int[] colors = new int[]{R.color.red, R.color.blue, R.color.yellow, R.color.green};
    public ObservableField<Card> topDeck = new ObservableField<>(new SimpleCardFactory().getCard(CardType.NumberCard, colors[0], "0"));

    public UNOBoard(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }

    public void generateBoard() {
        generatePlayers();
        generateDeck();
        dealCards();
        // set top deck and playing color (must be a number card to start for simplicity
        for(Card c: cards){
            if (c.cardType == CardType.NumberCard) {
                topDeck.set(c);
                cards.remove(c);
                break;
            }
        }
    }

    private void generatePlayers() {
        UserDataModel humanPlayerDataModel = new UserDataModel((int) System.currentTimeMillis(), "Human");
        players.add(new HumanPlayer(humanPlayerDataModel));
        for (int i = 0; i < 3; i++) {
            UserDataModel computerUserDataModel = new UserDataModel((int) System.currentTimeMillis(), "Bot");
            players.add(new ComputerPlayer(computerUserDataModel, new EasyPlayStrategy()));
        }
    }


    private void generateDeck(){
        CardFactory cardFactory = new SimpleCardFactory();
        // generate number cards (one of each 0 and 9 card and 2 of every number between 1 and 8 for each color)
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 4; j++){
                if(i == 0 || i == 9) {
                    cards.add(cardFactory.getCard(CardType.NumberCard, colors[j], String.valueOf(i)));
                } else {
                    cards.add(cardFactory.getCard(CardType.NumberCard, colors[j], String.valueOf(i)));
                    cards.add(cardFactory.getCard(CardType.NumberCard, colors[j], String.valueOf(i)));
                }
            }
        }
        // generate special cards. 2 of each (+2, Reverse, and Skip) per color
        for (int i = 0; i < 4; i++) {
            cards.add(cardFactory.getCard(CardType.DrawTwoCard, colors[i]));
            cards.add(cardFactory.getCard(CardType.DrawTwoCard, colors[i]));
            cards.add(cardFactory.getCard(CardType.SkipCard, colors[i]));
            cards.add(cardFactory.getCard(CardType.SkipCard, colors[i]));
            cards.add(cardFactory.getCard(CardType.ReverseCard, colors[i]));
            cards.add(cardFactory.getCard(CardType.ReverseCard, colors[i]));
        }
        // generate 4 of each for +4 and WildCards
        cards.add(cardFactory.getCard(CardType.DrawFourCard));
        cards.add(cardFactory.getCard(CardType.DrawFourCard));
        cards.add(cardFactory.getCard(CardType.DrawFourCard));
        cards.add(cardFactory.getCard(CardType.DrawFourCard));
        cards.add(cardFactory.getCard(CardType.WildCard));
        cards.add(cardFactory.getCard(CardType.WildCard));
        cards.add(cardFactory.getCard(CardType.WildCard));
        cards.add(cardFactory.getCard(CardType.WildCard));
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

    public ObservableArrayList<Card> getCardsForPlayer(int playerNumber) {
        return players.get(playerNumber - 1).playerData.deck;
    }

    public Card dealSingleCard(Player player) {
        // if the deck for dealing is exhausted, create a new one
        if (cards.size() == 0) {
            generateDeck();
        }
        Random rand = new Random();
        int index = rand.nextInt(cards.size());
        Card dealtCard = cards.get(index);
        player.playerData.deck.add(dealtCard);
        cards.remove(index);
        return dealtCard;
    }

    public boolean victoryCheck() {
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
