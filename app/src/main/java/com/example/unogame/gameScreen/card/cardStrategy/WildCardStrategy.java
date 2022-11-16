package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class WildCardStrategy implements CardStrategy{
    public void cardPlayed(UNOGameModel model){
        model.incrementTurn();
    }
}
