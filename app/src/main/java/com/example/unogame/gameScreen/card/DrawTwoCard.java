package com.example.unogame.gameScreen.card;

import com.example.unogame.R;

public class DrawTwoCard implements Card{
    public int resourceLayout = R.layout.card_vertical_draw_two;
    public int color;
    DrawTwoCard(int color){
        this.color = color;
    }
}
