package com.example.unogame.gameScreen.unoGame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unogame.R;
import com.example.unogame.ScreenNavigator;
import com.example.unogame.databinding.CardVerticalNumbersBinding;
import com.example.unogame.databinding.FragmentUNOGameBinding;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;
import com.example.unogame.gameScreen.card.NumberCard;

import javax.inject.Inject;

public class UNOGameFragment extends Fragment {

    FragmentUNOGameBinding binding;

    @Inject
    ScreenNavigator screenNavigator;

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
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        RecyclerView player1Deck = binding.player1Deck;
        player1Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        player1Deck.setAdapter(getAdapter(R.layout.card_vertical_numbers));


        RecyclerView player2Deck = binding.player2Deck;
        player2Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        player2Deck.setAdapter(getAdapter(R.layout.card_horizontal));


        RecyclerView player3Deck = binding.player3Deck;
        player3Deck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        player3Deck.setAdapter(getAdapter(R.layout.card_horizontal));


        RecyclerView humanPlayerDeck = binding.humanPlayerDeck;
        humanPlayerDeck.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false));
        humanPlayerDeck.setAdapter(getAdapter(R.layout.card_vertical_skip));

    }

    RecyclerView.ViewHolder getViewHolder(View view){
        return new RecyclerView.ViewHolder(view) {
        };
    }

    RecyclerView.Adapter getAdapter(int id){
        return new RecyclerView.Adapter<RecyclerView.ViewHolder>() {


            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                CardVerticalNumbersBinding binding = CardVerticalNumbersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                binding.setCard(new NumberCard(0, R.color.yellow));
                return getViewHolder(binding.getRoot());
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 10;
            }
        };
    }
}