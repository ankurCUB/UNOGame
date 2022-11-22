package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class NumberCard extends Card {
    public boolean isReversed = true;

    public NumberCard(String number, int color) {
        this.number = number;
        this.color = color;
        this.cardType = CardType.NumberCard;
        this.resourceLayout = R.layout.card_vertical_numbers;
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
