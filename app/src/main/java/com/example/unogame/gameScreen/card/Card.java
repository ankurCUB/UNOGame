package com.example.unogame.gameScreen.card;

import com.example.unogame.gameScreen.card.cardStrategy.CardStrategy;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public abstract class Card {
    public int resourceLayout = 0;
    public int color = -1;
    public String number = "-1";

    public CardType cardType = null;

    public CardStrategy strategy = null;

    public abstract int getLayout();
}
