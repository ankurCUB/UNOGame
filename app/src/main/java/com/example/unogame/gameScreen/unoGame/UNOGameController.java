package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.gameScreen.card.Card;

import java.util.ArrayList;

public class UNOGameController {
    UNOGameModel gameModel;

    public UNOGameController(UNOGameModel gameModel){
        this.gameModel = gameModel;
        gameModel.initialize();
    }

    public void playCard(int id){
        // This will be called on click of the play card button in the gamescreen fragment.
        // I am not implementin this since I am rather unsure of how we will be implementing the "view"
        // will we be essentially just adding two attributes to the UNOGameFragment and have it directly interacting with the controller?
    }

    private boolean gameWon(){
        ArrayList<Card> humanCards = gameModel.unoBoard.humanPlayer.playerData.deck;
        ArrayList<Card> computerCards = gameModel.unoBoard.computerPlayer.playerData.deck;
        return (humanCards.size() == 0 || computerCards.size() == 0);
    }
}
