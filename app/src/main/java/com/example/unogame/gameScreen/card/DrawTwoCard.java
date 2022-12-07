package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class DrawTwoCard extends Card {
    DrawTwoCard(int color) {
        this.resourceLayout = R.layout.card_vertical_draw_two;
        this.number = "-2";
        this.color = color;
        this.cardType = CardType.DrawTwoCard;
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
