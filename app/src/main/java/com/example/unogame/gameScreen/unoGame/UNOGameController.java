package com.example.unogame.gameScreen.unoGame;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class UNOGameController {
    private final UNOGameModel gameModel;
    private HumanPlayerAdapter humanPlayerAdapter;
    private Observable.OnPropertyChangedCallback selectedCardChangedCallback;

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

    HumanPlayerAdapter getHumanPlayerAdapter(){
        ArrayList<Card> cards = gameModel.unoBoard.getCardsForPlayer(4);
        humanPlayerAdapter = new HumanPlayerAdapter(cards);
        selectedCardChangedCallback = new ObservableField.OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                HumanPlayerAdapter.CardViewHolder cardViewHolder = humanPlayerAdapter.selectedCard.get();
                if (cardViewHolder != null) {
                    gameModel.selectedCard = cardViewHolder.card;
                }
            }
        };
        humanPlayerAdapter.selectedCard.addOnPropertyChangedCallback(selectedCardChangedCallback);
        return humanPlayerAdapter;
    }

    public void pauseGame(){
        humanPlayerAdapter.selectedCard.removeOnPropertyChangedCallback(selectedCardChangedCallback);
    }

    public void playCard(Context context) {
        if(gameModel.selectedCard != null){
            Toast.makeText(context, ""+gameModel.selectedCard.getClass(), Toast.LENGTH_SHORT).show();
        }
    }
}
