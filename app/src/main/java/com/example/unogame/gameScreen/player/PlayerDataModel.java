package com.example.unogame.gameScreen.player;

import androidx.databinding.ObservableArrayList;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;

public class PlayerDataModel {
    public int id;
    public String username;
    public int turn;
    public ObservableArrayList<Card> deck = new ObservableArrayList<>();

    public PlayerDataModel(UserDataModel userDataModel){
        this.id = userDataModel.id;
        this.username = userDataModel.userName;
    }

//    public PlayerDataModel(int id, String username, int turn, ArrayList<Card> deck){
//        this.id
//    }

}
