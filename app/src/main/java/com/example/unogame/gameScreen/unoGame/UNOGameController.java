package com.example.unogame.gameScreen.unoGame;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;

import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.Player;

import java.util.ArrayList;

import javax.inject.Inject;

public class UNOGameController {
    private final UNOGameModel gameModel;
    private HumanPlayerAdapter humanPlayerAdapter;
    private Observable.OnPropertyChangedCallback selectedCardChangedCallback;

    @Inject
    public UNOGameController(){
        // create new UNO board passing a user data model matching the current user
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        // pass generated board to UNO game Model
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        unoBoard.generateBoard();
        gameModel = new UNOGameModel(0, unoBoard);
    }

    public void startGame() {
//        gameModel.initialize();
    }

    ComputerPlayerAdapter getComputerPlayerAdapter(int playerNumber, Fragment fragment) {
        ObservableArrayList<Card> cards = gameModel.unoBoard.getCardsForPlayer(playerNumber);
        ComputerPlayerAdapter computerPlayerAdapter = new ComputerPlayerAdapter(cards);
        cards.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                fragment.getActivity().runOnUiThread(() -> computerPlayerAdapter.notifyDataSetChanged());

            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> computerPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> computerPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> computerPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> computerPlayerAdapter.notifyDataSetChanged());
            }
        });
        return computerPlayerAdapter;
    }

    HumanPlayerAdapter getHumanPlayerAdapter() {
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
//        humanPlayerAdapter.selectedCard.removeOnPropertyChangedCallback(selectedCardChangedCallback);
    }

    public void playCard(Context context) {
        if(gameModel.selectedCard != null){
            Toast.makeText(context, "" + gameModel.selectedCard.cardType.name() + ":" + gameModel.selectedCard.number, Toast.LENGTH_SHORT).show();
        }
    }

    public void playGame() {
        if (gameModel.victoryCheck()) {
            return;
        }

        // Just keep playing until someone wins. Right now this is setup for computer players only. Humans will change this logic a bit

        Runnable runnable = () -> {
            Player currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.move(gameModel);
        };

        try {
            CountDownTimer timer = new CountDownTimer(4000, 1000) {
                @Override
                public void onTick(long l) {
                    AsyncTask.execute(runnable);
                }

                @Override
                public void onFinish() {
                }
            };
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
