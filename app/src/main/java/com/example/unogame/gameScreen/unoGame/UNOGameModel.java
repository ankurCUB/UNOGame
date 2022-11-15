package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.gameScreen.card.Card;

public class UNOGameModel {
    public int turn;
    public UNOBoard unoBoard;
    public Card selectedCard = null;

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
