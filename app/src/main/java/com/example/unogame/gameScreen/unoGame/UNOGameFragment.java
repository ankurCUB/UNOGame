package com.example.unogame.gameScreen.unoGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unogame.ScreenNavigator;
import com.example.unogame.databinding.FragmentUNOGameBinding;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;

import javax.inject.Inject;

public class UNOGameFragment extends Fragment {

    FragmentUNOGameBinding binding;

    @Inject
    ScreenNavigator screenNavigator;

    private UNOGameController controller;

    public static UNOGameFragment newInstance(UNOGameController controller){
        UNOGameFragment fragment = new UNOGameFragment();
        fragment.controller = controller;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.appSubComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUNOGameBinding.inflate(inflater, container, false);
        screenNavigator.setBackButton(getActivity(), false);

        binding.playCard.setOnClickListener(view -> {
            controller.playCard(this.getContext());
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        controller.startGame();

        RecyclerView player1Deck = binding.player1Deck;
        player1Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        player1Deck.setAdapter(controller.getComputerPlayerAdapter(1));


        RecyclerView player2Deck = binding.player2Deck;
        player2Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        player2Deck.setAdapter(controller.getComputerPlayerAdapter(2));


        RecyclerView player3Deck = binding.player3Deck;
        player3Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        player3Deck.setAdapter(controller.getComputerPlayerAdapter(3));


        RecyclerView humanPlayerDeck = binding.humanPlayerDeck;
        humanPlayerDeck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        humanPlayerDeck.setAdapter(controller.getHumanPlayerAdapter());

        controller.playGame();

    }

    @Override
    public void onPause() {
        super.onPause();
        controller.pauseGame();
    }
}