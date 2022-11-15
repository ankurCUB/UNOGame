package com.example.unogame.gameScreen.card;

import com.example.unogame.R;

public class SkipCard implements Card {
    public int resourceLayout = R.layout.card_vertical_skip;
    public int color;
    SkipCard(int color){
        this.color = color;
    }
}
