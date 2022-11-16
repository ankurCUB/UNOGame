package com.example.unogame.gameScreen.unoGame;

import android.content.Context;

import com.example.unogame.Observer;
import com.example.unogame.gameScreen.player.Player;

import java.util.ArrayList;
import java.util.List;

public class UNOGameModel {
    private int turn;
    private UNOBoard unoBoard;
    private int direction = 1;
    public int color;

    public UNOGameModel(int turn, UNOBoard unoBoard){
        this.turn = turn;
        this.unoBoard = unoBoard;
        this.color = unoBoard.topDeck.color;
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
        if(turn == unoBoard.getNumPlayers() - 1 && direction == 1){
            turn = 0;
        }else if(turn == 0 && direction == -1){
            turn = unoBoard.getNumPlayers() - 1;
        } else{
            turn += direction;
        }
    }

    public void reverseDirection(){
        direction = direction * -1;
    }
}
