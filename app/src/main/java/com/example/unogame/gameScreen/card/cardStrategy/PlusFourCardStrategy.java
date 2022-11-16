package com.example.unogame.gameScreen.card.cardStrategy;

import com.example.unogame.gameScreen.player.Player;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class PlusFourCardStrategy {
    public void cardPlayed(UNOGameModel model){
        model.incrementTurn();
        Player p = model.getCurrentPlayer();
        model.getBoard().dealSingleCard(p);
        model.getBoard().dealSingleCard(p);
        model.getBoard().dealSingleCard(p);
        model.getBoard().dealSingleCard(p);
    }
}
