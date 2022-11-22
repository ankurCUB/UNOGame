package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class SkipCard extends Card {
    public SkipCard(int color) {
        this.color = color;
        this.cardType = CardType.SkipCard;
        this.resourceLayout = R.layout.card_vertical_skip;
        this.number = "-4";
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
