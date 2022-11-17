package com.example.unogame.gameScreen.unoGame;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unogame.databinding.CardVerticalFlippedBinding;
import com.example.unogame.gameScreen.card.Card;

import java.util.ArrayList;

public class ComputerPlayerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Card> cards;

    public ComputerPlayerAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewDataBinding dataBinding = CardVerticalFlippedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new RecyclerView.ViewHolder(dataBinding.getRoot()) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemViewType(int position) {
        return cards.get(position).getLayout();
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    ;
}