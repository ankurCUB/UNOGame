package com.example.unogame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.example.unogame.databinding.CardVerticalDrawFourBinding;
import com.example.unogame.databinding.CardVerticalDrawTwoBinding;
import com.example.unogame.databinding.CardVerticalNumbersBinding;
import com.example.unogame.databinding.CardVerticalReverseBinding;
import com.example.unogame.databinding.CardVerticalSkipBinding;
import com.example.unogame.databinding.CardVerticalWildcardBinding;
import com.example.unogame.gameScreen.card.Card;
import com.example.unogame.gameScreen.card.DrawTwoCard;
import com.example.unogame.gameScreen.card.NumberCard;
import com.example.unogame.gameScreen.card.ReverseCard;
import com.example.unogame.gameScreen.card.SkipCard;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public interface BindingAdapters {
    @BindingAdapter("android:cardBackground")
    static void setCardBackground(ConstraintLayout layout, int color) {
        int background = 0;
        switch (color) {
            case R.color.red:
                background = R.drawable.card_bg_red;
                break;
            case R.color.yellow:
                background = R.drawable.card_bg_yellow;
                break;
            case R.color.blue:
                background = R.drawable.card_bg_blue;
                break;
            default:
                background = R.drawable.card_bg_green;
        }
        layout.setBackgroundResource(background);
    }

    @BindingAdapter("android:numberColor")
    static void setColor(TextView textView, int color) {
        int actualColor = ContextCompat.getColor(textView.getContext(), color);
        textView.setTextColor(actualColor);
    }

    @BindingAdapter("android:cardBackground")
    static void setCardBackground(ImageView imageView, int color) {
        int background = 0;
        switch (color) {
            case R.color.red:
                background = R.drawable.card_bg_red;
                break;
            case R.color.yellow:
                background = R.drawable.card_bg_yellow;
                break;
            case R.color.blue:
                background = R.drawable.card_bg_blue;
                break;
            default:
                background = R.drawable.card_bg_green;
        }
        imageView.setBackgroundResource(background);
    }

    @BindingAdapter("android:skipIcon")
    static void setSkipIcon(ImageView imageView, int color) {
        int skipIcon = 0;
        switch (color) {
            case R.color.red:
                skipIcon = R.drawable.ic_skip_red;
                break;
            case R.color.yellow:
                skipIcon = R.drawable.ic_skip_yellow;
                break;
            case R.color.blue:
                skipIcon = R.drawable.ic_skip_blue;
                break;
            default:
                skipIcon = R.drawable.ic_skip_green;
        }
        imageView.setImageResource(skipIcon);
    }

    @BindingAdapter("android:reverseIcon")
    static void setReverseIcon(ImageView imageView, int color) {
        int skipIcon = 0;
        switch (color) {
            case R.color.red:
                skipIcon = R.drawable.ic_uno_reverse_red;
                break;
            case R.color.yellow:
                skipIcon = R.drawable.ic_uno_reverse_yellow;
                break;
            case R.color.blue:
                skipIcon = R.drawable.ic_uno_reverse_blue;
                break;
            default:
                skipIcon = R.drawable.ic_uno_reverse_green;
        }
        imageView.setImageResource(skipIcon);
    }

    @BindingAdapter("android:setCard")
    static void setCard(FrameLayout layout, UNOGameModel model) {
        int resourceLayout = model.unoBoard.topDeck.get().resourceLayout;

        Card card = model.unoBoard.topDeck.get();

        LayoutInflater inflater = (LayoutInflater)
                layout.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        switch (resourceLayout) {
            case R.layout.card_vertical_draw_two:
                CardVerticalDrawTwoBinding a_binding = CardVerticalDrawTwoBinding.inflate(inflater);
                a_binding.setCard((DrawTwoCard) card);
                view = a_binding.getRoot();
                break;
            case R.layout.card_vertical_draw_four:
                CardVerticalDrawFourBinding b_binding = CardVerticalDrawFourBinding.inflate(inflater);
                view = b_binding.getRoot();
                break;
            case R.layout.card_vertical_numbers:
                CardVerticalNumbersBinding c_binding = CardVerticalNumbersBinding.inflate(inflater);
                c_binding.setCard((NumberCard) card);
                view = c_binding.getRoot();
                break;
            case R.layout.card_vertical_reverse:
                CardVerticalReverseBinding d_binding = CardVerticalReverseBinding.inflate(inflater);
                d_binding.setCard((ReverseCard) card);
                view = d_binding.getRoot();
                break;
            case R.layout.card_vertical_skip:
                CardVerticalSkipBinding e_binding = CardVerticalSkipBinding.inflate(inflater);
                e_binding.setCard((SkipCard) card);
                view = e_binding.getRoot();
                break;
            case R.layout.card_vertical_wildcard:
                CardVerticalWildcardBinding f_binding = CardVerticalWildcardBinding.inflate(inflater);
                view = f_binding.getRoot();
                break;
        }
        if (view != null) {
            layout.addView(view);
        }
    }
}
