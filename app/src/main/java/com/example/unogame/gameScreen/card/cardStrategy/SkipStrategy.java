package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.player.playStrategy.CardType;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class SkipStrategy implements CardStrategy {
    @Override
    public boolean isCardPlayable(UNOGameModel model, Card card) {
        return model.unoBoard.topDeck.get().color == card.color || model.unoBoard.topDeck.get().cardType == CardType.SkipCard;
    }

    public void playCard(UNOGameModel model, Card card, int color) {
        model.incrementTurn();
        model.incrementTurn();
    }
}
