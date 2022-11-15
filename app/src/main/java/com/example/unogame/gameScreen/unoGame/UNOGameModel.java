package com.example.unogame.gameScreen.unoGame;

import android.content.Context;

import com.example.unogame.Observer;
import com.example.unogame.gameScreen.player.Player;

import java.util.ArrayList;
import java.util.List;

public class UNOGameModel {
    private int turn;
    private UNOBoard unoBoard;

    public UNOGameModel(int turn, UNOBoard unoBoard){
        this.turn = turn;
        this.unoBoard = unoBoard;
    }

    public boolean victoryCheck(){
        return unoBoard.victoryCheck();
    }

    public int getTurn(){
        return turn;
    }

    public Player getCurrentPlayer(){
        return unoBoard.getPlayer(turn);
    }

    public UNOBoard getBoard(){ return unoBoard;}

    public void drawOneCurrentPlayer(){
        unoBoard.dealSingleCard(getCurrentPlayer());
    }

    public void incrementTurn(){
        if(turn == unoBoard.getNumPlayers() - 1){
            turn = 0;
        } else{
            turn ++;
        }
    }
}
