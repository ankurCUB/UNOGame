package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class ReverseCard extends Card {
    public ReverseCard(int color) {
        this.color = color;
        this.cardType = CardType.ReverseCard;
        this.resourceLayout = R.layout.card_vertical_reverse;
        this.number = "-3";
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
