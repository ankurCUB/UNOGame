package com.example.unogame.gameScreen.player.playStrategy;

import android.util.Log;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

import java.util.Random;

public class EasyPlayStrategy implements GamePlayStrategy {
    @Override
    public void move(UNOGameModel model) {
        // the easy play strategy implements a greedy approach and will just play the first card it finds that is valid
        Card playedCard = getPlayedCard(model);

        if (playedCard != null) {
            Log.i(tag, "Card successfully played");
            // set top deck card as the freshly played card
            model.getBoard().topDeck.set(playedCard);
            // remove the played card
            model.getCurrentPlayer().playerData.deck.remove(playedCard);
        } else {
            Log.i(tag, "Card draw but couldn't be played");
        }
        model.incrementTurn();
    }

    private Card getPlayedCard(UNOGameModel model) {

        // loop through cards of the player and find the first match
        Card playedCard = null;
        for (Card selectedCard : model.getCurrentPlayer().playerData.deck) {
            playedCard = playSelectedCard(model, selectedCard);
            if (playedCard != null) {
                break;
            }
        }
        // if the played card was not set, draw a card
        if (playedCard == null) {
            Card dealtCard = model.getBoard().dealSingleCard(model.getCurrentPlayer());
            playedCard = playSelectedCard(model, dealtCard);
            Log.i(tag, "Card dealt");
        }
        return playedCard;
    }

    private Card playSelectedCard(UNOGameModel model, Card selectedCard) {
        Card playedCard = null;
        Random rand = new Random();
        if (selectedCard.color == model.color) {
            playedCard = selectedCard;
        } else if (selectedCard.number.equals(model.getBoard().topDeck.get().number)) {
            playedCard = selectedCard;
            model.color = selectedCard.color;
        } else if (selectedCard.cardType == CardType.WildCard || selectedCard.cardType == CardType.DrawFourCard) {
            playedCard = selectedCard;
            model.color = model.unoBoard.colors[rand.nextInt(4)];
        }
        return playedCard;
    }

    private static final String tag = EasyPlayStrategy.class.getName();
}
