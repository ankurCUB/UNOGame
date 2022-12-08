package com.example.unogame.gameScreen.unoGame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;

import com.example.unogame.ScreenNavigator;
import com.example.unogame.databinding.FragmentUNOGameBinding;
import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.card.DrawFourCard;
import com.example.unogame.gameScreen.card.WildCard;
import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.player.HumanPlayer;
import com.example.unogame.gameScreen.player.Player;

import java.util.Random;

import javax.inject.Inject;

public class UNOGameController {
    public UNOGameModel getGameModel() {
        return gameModel;
    }

    private final UNOGameModel gameModel;
    private HumanPlayerAdapter humanPlayerAdapter;
    private Observable.OnPropertyChangedCallback selectedCardChangedCallback;

    private ScreenNavigator screenNavigator;

    @Inject
    public UNOGameController(ScreenNavigator screenNavigator) {
        // create new UNO board passing a user data model matching the current user
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        // pass generated board to UNO game Model
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        unoBoard.generateBoard();
        gameModel = new UNOGameModel(0, unoBoard);
        this.screenNavigator = screenNavigator;
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

    HumanPlayerAdapter getHumanPlayerAdapter(int playerNumber, Fragment fragment) {
        ObservableArrayList<Card> cards = gameModel.unoBoard.getCardsForPlayer(playerNumber);
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

        cards.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                fragment.getActivity().runOnUiThread(() -> humanPlayerAdapter.notifyDataSetChanged());

            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> humanPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> humanPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> humanPlayerAdapter.notifyDataSetChanged());
            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                fragment.getActivity().runOnUiThread(() -> humanPlayerAdapter.notifyDataSetChanged());
            }
        });

        return humanPlayerAdapter;
    }

    public void pauseGame(){
//        humanPlayerAdapter.selectedCard.removeOnPropertyChangedCallback(selectedCardChangedCallback);
    }

    public void playCard(FragmentUNOGameBinding binding) {
        if (gameModel.selectedCard != null) {
            if (gameModel.selectedCard.strategy.isCardPlayable(gameModel, gameModel.selectedCard)) {
                binding.playCard.setOnClickListener(null);
                gameModel.getBoard().topDeck.set(gameModel.selectedCard);
                // remove the played card
                gameModel.getCurrentPlayer().playerData.deck.remove(gameModel.selectedCard);

                if (gameModel.selectedCard.getClass() == WildCard.class || gameModel.selectedCard.getClass() == DrawFourCard.class) {
                    showChooseColorDialog(binding);
                } else {
                    playCardForHumanPlayer(binding, -1);
                }
            } else {
                Toast.makeText(binding.getRoot().getContext(), "Card can't be played. Choose another", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(binding.getRoot().getContext(), "Select a card to play", Toast.LENGTH_SHORT).show();
        }
    }

    private void playCardForHumanPlayer(FragmentUNOGameBinding binding, int color) {
        gameModel.selectedCard.strategy.playCard(gameModel, gameModel.selectedCard, color);
        playGame(binding);
    }

    private void showChooseColorDialog(FragmentUNOGameBinding binding) {
        Random rand = new Random();
        AlertDialog.Builder builder = new AlertDialog.Builder(binding.getRoot().getContext());
        builder.setTitle("Pick a color !");
        DialogInterface.OnClickListener onClickListener = (dialogInterface, i) -> {
            int selectedColor = gameModel.unoBoard.colors[i];
            playCardForHumanPlayer(binding, selectedColor);
        };
        builder.setItems(new String[]{"Red", "Blue", "Yellow", "Green"}, onClickListener);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                playCardForHumanPlayer(binding, gameModel.unoBoard.colors[rand.nextInt(4)]);
            }
        });
        builder.create().show();
    }

    public void playGame(FragmentUNOGameBinding binding) {

        // Just keep playing until someone wins. Right now this is setup for computer players only. Humans will change this logic a bit

        Runnable runnable = () -> {
            Player currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.move(gameModel, binding.getRoot().getContext());
        };

        try {
            CountDownTimer timer = new CountDownTimer(400000, 1000) {
                @Override
                public void onTick(long l) {
                    if (gameModel.victoryCheck() || gameModel.getTurn() == 0) {
                        String victoryString = "Oops! you lost!";
                        Toast.makeText(binding.getRoot().getContext(), victoryString, Toast.LENGTH_SHORT).show();
                        onFinish();
                    } else {
                        AsyncTask.execute(runnable);
                    }
                }

                @Override
                public void onFinish() {
                    binding.playCard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            playCard(binding);
                        }
                    });
                }
            };
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawNewCard() {
        if (gameModel.getCurrentPlayer().getClass() == HumanPlayer.class) {
            gameModel.drawOneCurrentPlayer();
        }
    }
}
