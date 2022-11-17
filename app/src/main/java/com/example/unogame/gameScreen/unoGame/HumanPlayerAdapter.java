package com.example.unogame.gameScreen.unoGame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unogame.R;
import com.example.unogame.databinding.CardVerticalDrawFourBinding;
import com.example.unogame.databinding.CardVerticalDrawTwoBinding;
import com.example.unogame.databinding.CardVerticalFlippedBinding;
import com.example.unogame.databinding.CardVerticalNumbersBinding;
import com.example.unogame.databinding.CardVerticalReverseBinding;
import com.example.unogame.databinding.CardVerticalSkipBinding;
import com.example.unogame.databinding.CardVerticalWildcardBinding;
import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.card.DrawFourCard;
import com.example.unogame.gameScreen.card.DrawTwoCard;
import com.example.unogame.gameScreen.card.NumberCard;
import com.example.unogame.gameScreen.card.ReverseCard;
import com.example.unogame.gameScreen.card.SkipCard;
import com.example.unogame.gameScreen.card.WildCard;

import java.util.ArrayList;

public class HumanPlayerAdapter extends RecyclerView.Adapter<HumanPlayerAdapter.CardViewHolder> {

    private final ArrayList<Card> cards;

    public ObservableField<CardViewHolder> selectedCard = new ObservableField<>();

    public HumanPlayerAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewDataBinding dataBinding;

        switch (viewType) {
            case R.layout.card_vertical_draw_four:
                dataBinding = CardVerticalDrawFourBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            case R.layout.card_vertical_draw_two:
                dataBinding = CardVerticalDrawTwoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            case R.layout.card_vertical_numbers:
                dataBinding = CardVerticalNumbersBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            case R.layout.card_vertical_reverse:
                dataBinding = CardVerticalReverseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            case R.layout.card_vertical_skip:
                dataBinding = CardVerticalSkipBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            case R.layout.card_vertical_wildcard:
                dataBinding = CardVerticalWildcardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                break;
            default:
                dataBinding = CardVerticalFlippedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        }

        return new CardViewHolder(dataBinding.getRoot(), dataBinding) {
        };
    }

    @Override
    public void onViewAttachedToWindow(@NonNull CardViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull CardViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(selectedCard.get() == holder){
            selectedCard.set(null);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card;
        if(cards.get(position).getClass() == DrawTwoCard.class){
            card = (DrawTwoCard) cards.get(position);
            ((CardVerticalDrawTwoBinding)holder.viewDataBinding).setCard((DrawTwoCard) cards.get(position));
        } else if(cards.get(position).getClass() == NumberCard.class){
            card = (NumberCard) cards.get(position);
            ((CardVerticalNumbersBinding)holder.viewDataBinding).setCard((NumberCard) cards.get(position));
        } else if(cards.get(position).getClass() == ReverseCard.class){
            card = (ReverseCard) cards.get(position);
            ((CardVerticalReverseBinding)holder.viewDataBinding).setCard((ReverseCard) cards.get(position));
        } else if(cards.get(position).getClass() == SkipCard.class){
            card = (SkipCard) cards.get(position);
            ((CardVerticalSkipBinding)holder.viewDataBinding).setCard((SkipCard) cards.get(position));
        } else if(cards.get(position).getClass() == DrawFourCard.class){
            card = (DrawFourCard) cards.get(position);
        } else {
            card = (WildCard) cards.get(position);
        }

        holder.card = card;

        holder.itemView.setOnClickListener(view -> {
            if(selectedCard.get() == holder){
                selectedCard.set(null);
                view.setTranslationY(0);
            } else{
                RecyclerView.ViewHolder previousCard = selectedCard.get();
                if(previousCard!=null) {
                    previousCard.itemView.setTranslationY(0);
                }
                selectedCard.set(holder);
                view.setTranslationY(-16);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return cards.get(position).getLayout();
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    protected static class CardViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding viewDataBinding;

        Card card;

        public CardViewHolder(@NonNull View itemView, ViewDataBinding viewDataBinding) {
            super(itemView);
            this.viewDataBinding = viewDataBinding;
        }
    };
}