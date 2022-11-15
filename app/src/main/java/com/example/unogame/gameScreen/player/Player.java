package com.example.unogame.gameScreen.player;

import com.example.unogame.gameScreen.data.UserDataModel;

public abstract class Player {
    public PlayerDataModel playerData;

    public Player(UserDataModel userDataModel){
        playerData = new PlayerDataModel(userDataModel);
    }
}