package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class NumberCardStrategy implements CardStrategy {
    @Override
    public boolean isCardPlayable(UNOGameModel model, Card card) {
        return model.unoBoard.topDeck.get().number.equals(card.number) || model.unoBoard.topDeck.get().color == card.color;
    }

    public void playCard(UNOGameModel model, Card card, int color) {
        model.incrementTurn();
    }
}
