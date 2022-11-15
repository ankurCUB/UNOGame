package com.example.unogame.gameScreen.card;

import com.example.unogame.R;

public class ReverseCard implements Card {
    public int resourceLayout = R.layout.card_vertical_reverse;
    public int color;
    ReverseCard(int color){
        this.color = color;
    }
}
