package com.example.unogame.gameScreen.player;

import android.content.Context;

import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public abstract class Player {
    public PlayerDataModel playerData;

    public Player(UserDataModel userDataModel) {
        playerData = new PlayerDataModel(userDataModel);
    }

    public void move(UNOGameModel unoGameModel, Context context) {
    }

    ;
}