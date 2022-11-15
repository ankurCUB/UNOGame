package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.gameScreen.data.UserDataModel;

import javax.inject.Inject;

public class UNOGameController {
    private final UNOGameModel gameModel;

    @Inject
    public UNOGameController(){
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        gameModel = new UNOGameModel(0, unoBoard);
    }
}
