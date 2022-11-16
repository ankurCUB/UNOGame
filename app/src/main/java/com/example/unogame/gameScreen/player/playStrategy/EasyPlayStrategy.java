package com.example.unogame.gameScreen.player.playStrategy;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.player.Player;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

import java.util.ArrayList;
import java.util.Random;

public class EasyPlayStrategy implements GamePlayStrategy {
    @Override
    public void move(UNOGameModel model) {
        // the easy play strategy implements a greedy approach and will just play the first card it finds that is valid
        Card playedCard = null;
        Random rand = new Random();
        while(playedCard == null){
            for(Card c: model.getCurrentPlayer().playerData.deck){
                if(c.getClass().getSimpleName() == "WildCard" || c.getClass().getSimpleName() == "DrawFourCard"){
                    playedCard = c;
                    model.color = rand.nextInt(4) + 1;
                } else if(c.color == model.color){
                    playedCard = c;
                } else if(c.number.equals(model.getBoard().topDeck.number)){
                    playedCard = c;
                    model.color = c.color;
                }
            }
            // if the played card was not set, draw a card
            if(playedCard == null){
                model.getBoard().dealSingleCard(model.getCurrentPlayer());
                System.out.print("Card dealt");
            }
        }
        System.out.print("Card successfully played");
        // set top deck card as the freshly played card
        model.getBoard().topDeck = playedCard;
        // remove the played card
        model.getCurrentPlayer().playerData.deck.remove(playedCard);
        //
        model.incrementTurn();
    }
}
