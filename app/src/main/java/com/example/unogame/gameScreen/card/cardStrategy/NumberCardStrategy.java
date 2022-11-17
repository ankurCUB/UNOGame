package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class NumberCardStrategy implements CardStrategy{
    public void cardPlayed(UNOGameModel model){
        model.incrementTurn();
    }
}
