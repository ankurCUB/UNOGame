package com.example.unogame.gameScreen.player.playStrategy;

import android.content.Context;
import android.util.Log;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class EasyPlayStrategy implements GamePlayStrategy {
    @Override
    public void move(UNOGameModel model, Context context) {
        // the easy play strategy implements a greedy approach and will just play the first card it finds that is valid

        Card playedCard = null;
        // loop through cards of the player and find the first match
        for (Card selectedCard : model.getCurrentPlayer().playerData.deck) {
            if (selectedCard.strategy.isCardPlayable(model, selectedCard)) {
                playedCard = selectedCard;
                Log.i(tag, "Card played from deck:" + model.getTurn() + ":" + playedCard.cardType.name() + ":" + playedCard.number);
                // set top deck card as the freshly played card
                model.getBoard().topDeck.set(playedCard);
                // remove the played card
                model.getCurrentPlayer().playerData.deck.remove(playedCard);
                playedCard.strategy.playCard(model, playedCard, -1);
                break;
            }
        }
        // if the played card was not set, draw a card
        if (playedCard == null) {
            Card dealtCard = model.getBoard().dealSingleCard(model.getCurrentPlayer());
            Log.i(tag, "New card dealt:" + model.getTurn() + ":" + dealtCard.cardType.name() + ":" + dealtCard.number);
            if (dealtCard.strategy.isCardPlayable(model, dealtCard)) {
                playedCard = dealtCard;
                // set top deck card as the freshly played card
                model.getBoard().topDeck.set(playedCard);
                // remove the played card
                model.getCurrentPlayer().playerData.deck.remove(playedCard);
                Log.i(tag, "Dealt card played:" + model.getTurn() + ":" + playedCard.cardType.name() + ":" + playedCard.number);
                playedCard.strategy.playCard(model, playedCard, -1);
            } else {
                model.incrementTurn();
                Log.i(tag, "Card dealt but couldn't be played");
            }
        }
    }

    private static final String tag = EasyPlayStrategy.class.getSimpleName();
}
