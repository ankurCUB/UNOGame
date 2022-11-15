package com.example.unogame.gameScreen.card;

import com.example.unogame.R;

public class NumberCard implements Card{
    public int resourceLayout = R.layout.card_vertical_numbers;
    public int number;
    public int color;
    public boolean isReversed = true;
    public NumberCard(int number, int color){
        this.number = number;
        this.color = color;
    }
}
