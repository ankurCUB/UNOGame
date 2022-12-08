package com.example.unogame.gameScreen.player.playStrategy;

import android.content.Context;

import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public interface GamePlayStrategy {
    void move(UNOGameModel model, Context context);
}
