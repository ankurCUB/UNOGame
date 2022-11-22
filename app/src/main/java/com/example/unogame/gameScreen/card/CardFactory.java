package com.example.unogame.gameScreen.card;

import com.example.unogame.gameScreen.player.playStrategy.CardType;

public interface CardFactory {
    // for getting a number card color and number must be provided
    public Card getCard(CardType cardType, int Color, String number);

    // for a draw 2 card, skip, or reverse card, color is only additional argument to type
    public Card getCard(CardType cardType, int Color);

    // for a draw 4, only type is required
    public Card getCard(CardType cardType);
}
