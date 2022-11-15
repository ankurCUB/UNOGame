package com.example.unogame.gameScreen.card;

import com.example.unogame.R;

public class WildCard implements Card {
    public int resourceLayout = R.layout.card_vertical_wildcard;

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
