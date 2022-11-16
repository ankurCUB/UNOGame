package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.Player;

import javax.inject.Inject;

public class UNOGameController {
    private final UNOGameModel gameModel;

    @Inject
    public UNOGameController(){
        // create new UNO board passing a user data model matching the current user
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        // pass generated board to UNO game Model
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        unoBoard.generateBoard();
        gameModel = new UNOGameModel(0, unoBoard);
    }

    public void playGame(){
        // Just keep playing until someone wins. Right now this is setup for computer players only. Humans will change this logic a bit
        while(!gameModel.victoryCheck()){
            Player currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.move(gameModel);
        }
    }
}
