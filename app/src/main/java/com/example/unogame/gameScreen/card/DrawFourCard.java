package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class DrawFourCard extends Card {
    DrawFourCard() {
        this.resourceLayout = R.layout.card_vertical_draw_four;
        this.color = 5;
        this.cardType = CardType.DrawFourCard;
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
