package com.example.unogame.gameScreen.player;

import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.playStrategy.GamePlayStrategy;

public class ComputerPlayer extends Player{

    private GamePlayStrategy gamePlayStrategy;

    public ComputerPlayer(UserDataModel userDataModel, GamePlayStrategy gamePlayStrategy) {
        super(userDataModel);
        this.gamePlayStrategy = gamePlayStrategy;
    }
}
