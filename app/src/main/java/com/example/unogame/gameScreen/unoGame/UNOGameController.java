package com.example.unogame.gameScreen.unoGame;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class UNOGameController {
    private final UNOGameModel gameModel;

    @Inject
    public UNOGameController(){
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        gameModel = new UNOGameModel(0, unoBoard);
    }

    public void startGame(){
        gameModel.initialize();
    }

    ComputerPlayerAdapter getComputerPlayerAdapter(int playerNumber){
        ArrayList<Card> cards = gameModel.unoBoard.getCardsForPlayer(playerNumber);
        return new ComputerPlayerAdapter(cards);
    }

    HumanPlayerAdapter getHumanPlayerAdapter(int playerNumber){
        ArrayList<Card> cards = gameModel.unoBoard.getCardsForPlayer(playerNumber);
        return new HumanPlayerAdapter(cards);
    }
}
