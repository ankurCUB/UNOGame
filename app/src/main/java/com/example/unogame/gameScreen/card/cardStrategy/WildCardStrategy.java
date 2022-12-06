package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

import java.util.Random;

public class WildCardStrategy implements CardStrategy {
    @Override
    public boolean isCardPlayable(UNOGameModel model, Card card) {
        return true;
    }

    public void playCard(UNOGameModel model, Card card) {
        Random rand = new Random();
        card.color = model.unoBoard.colors[rand.nextInt(4)];
        model.incrementTurn();
    }
}
