package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.Observer;

import java.util.ArrayList;
import java.util.List;

public class UNOGameModel {
    public int turn;
    public UNOBoard unoBoard;

    private List<Observer> observers = new ArrayList<>();

    public void initialize(){
        // create the uno deck
        unoBoard.generateBoard();
        turn = 0;
    }

//    public void registerObserver(Observer O){
//        observers.add(O);
//    }


}
