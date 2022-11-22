package com.example.unogame.gameScreen.player;

import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.playStrategy.GamePlayStrategy;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

import java.util.concurrent.TimeUnit;

public class ComputerPlayer extends Player{

    private GamePlayStrategy gamePlayStrategy;

    public ComputerPlayer(UserDataModel userDataModel, GamePlayStrategy gamePlayStrategy) {
        super(userDataModel);
        this.gamePlayStrategy = gamePlayStrategy;
    }

    public void move(UNOGameModel model){
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e){
            System.out.println("got interrupted!");
        }
        gamePlayStrategy.move(model);
    }
}
