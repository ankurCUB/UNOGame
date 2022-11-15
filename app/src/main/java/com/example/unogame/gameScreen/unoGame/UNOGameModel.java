package com.example.unogame.gameScreen.unoGame;

import android.content.Context;

import com.example.unogame.Observer;

import java.util.ArrayList;
import java.util.List;

public class UNOGameModel {
    public int turn;
    public UNOBoard unoBoard;

    public UNOGameModel(int turn, UNOBoard unoBoard){
        this.turn = turn;
        this.unoBoard = unoBoard;
    }

    public void initialize(){
        // create the uno deck
        unoBoard.generateBoard();
        turn = 0;
    }
}
