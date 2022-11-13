package com.example.unogame;


import java.util.ArrayList;
import java.util.Random;

public class UNOBoard {
    public ArrayList<Card> cards = new ArrayList<>();
    public HumanPlayer humanPlayer;
    public ComputerPlayer computerPlayer;

    public UNOBoard(HumanPlayer humanPlayer){
        this.humanPlayer = humanPlayer;
    }

    public void generateBoard(){
        generateDeck();
    }

    private void generateDeck(){
        CardFactory cardFactory = new SimpleCardFactory();
        // generate number cards (one of each 0 and 9 card and 2 of every number between 1 and 8 for each color)
        for(int i = 0; i < 10; i++){
            for(int j = 1; j < 5; j++){
                if(i == 0 || i == 9) {
                    cards.add(cardFactory.getCard("Number", j, i));
                } else{
                    cards.add(cardFactory.getCard("Number", j, i));
                    cards.add(cardFactory.getCard("Number", j, i));
                }
            }
        }
        // generate special cards. 2 of each (+2, Reverse, and Skip) per color
        for(int i = 1; i < 5; i++){
            cards.add(cardFactory.getCard("Draw Two", i));
            cards.add(cardFactory.getCard("Draw Two", i));
        }
    }

    private void dealCards(){
        Random rand = new Random();
        // deal 7 cards for each player, subtracting them from the cards deck each time one is dealt
        for(int i = 0; i < 7; i++){
            int index = rand.nextInt(cards.size() - 1);
            humanPlayer.playerData.deck.add(cards.get(index));
            cards.remove(index);
            index = rand.nextInt(cards.size() - 1);
            computerPlayer.playerData.deck.add(cards.get(index));
            cards.remove(index);
        }
    }
}
