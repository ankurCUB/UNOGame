package com.example.unogame.gameScreen.card;

public interface CardFactory {
    // for getting a number card color and number must be provided
    public Card getCard(String type, int Color, String number);
    // for a draw 2 card, skip, or reverse card, color is only additional argument to type
    public Card getCard(String type, int Color);
    // for a draw 4, only type is required
    public Card getCard(String type);
}
