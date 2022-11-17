package com.example.unogame.gameScreen.player;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;

import java.util.ArrayList;

public class PlayerDataModel {
    public int id;
    public String username;
    public int turn;
    public ArrayList<Card> deck = new ArrayList<>();

    public PlayerDataModel(UserDataModel userDataModel){
        this.id = userDataModel.id;
        this.username = userDataModel.userName;
    }

//    public PlayerDataModel(int id, String username, int turn, ArrayList<Card> deck){
//        this.id
//    }

}
