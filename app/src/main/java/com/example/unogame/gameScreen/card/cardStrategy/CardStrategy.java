package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public interface CardStrategy {
    boolean isCardPlayable(UNOGameModel model, Card card);

    void playCard(UNOGameModel model, Card card, int color);
}
