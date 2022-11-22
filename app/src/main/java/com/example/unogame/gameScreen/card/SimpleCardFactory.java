package com.example.unogame.gameScreen.card;

import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class SimpleCardFactory implements CardFactory {
    public Card getCard(CardType cardType, int color, String number) {
        Card c;
        if (cardType == CardType.NumberCard) {
            c = new NumberCard(number, color);
            return c;
        }
        return null;
    }

    public Card getCard(CardType cardType, int color) {
        Card c;
        if (cardType == CardType.DrawTwoCard) {
            c = new DrawTwoCard(color);
            return c;
        } else if (cardType == CardType.SkipCard) {
            c = new SkipCard(color);
            return c;
        } else if (cardType == CardType.ReverseCard) {
            c = new ReverseCard(color);
            return c;
        }
        return null;
    }

    public Card getCard(CardType cardType) {
        Card c;
        if (cardType == CardType.DrawFourCard) {
            c = new DrawFourCard();
            return c;
        } else if (cardType == CardType.WildCard) {
            c = new WildCard();
            return c;
        }
        return null;
    }
}
