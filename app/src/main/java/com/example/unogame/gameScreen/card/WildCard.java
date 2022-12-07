package com.example.unogame.gameScreen.card;

import com.example.unogame.R;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class WildCard extends Card {

    public WildCard() {
        this.cardType = CardType.WildCard;
        this.resourceLayout = R.layout.card_vertical_wildcard;
        this.color = 5;
        this.number = "-5";
    }

    @Override
    public int getLayout() {
        return resourceLayout;
    }
}
