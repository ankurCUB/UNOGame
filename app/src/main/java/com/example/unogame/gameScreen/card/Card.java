package com.example.unogame.gameScreen.card;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public abstract class Card {
    public int resourceLayout = 0;
    public int color = -1;
    public String number = "-1";

    public CardType cardType = null;

    public abstract int getLayout();

    @BindingAdapter("android:cardBackground")
    public static void setCardBackground(ConstraintLayout layout, int color) {
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
    public static void setColor(TextView textView, int color) {
        int actualColor = ContextCompat.getColor(textView.getContext(), color);
        textView.setTextColor(actualColor);
    }

    @BindingAdapter("android:cardBackground")
    public static void setCardBackground(ImageView imageView, int color) {
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
    public static void setSkipIcon(ImageView imageView, int color) {
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
    public static void setReverseIcon(ImageView imageView, int color) {
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

}
