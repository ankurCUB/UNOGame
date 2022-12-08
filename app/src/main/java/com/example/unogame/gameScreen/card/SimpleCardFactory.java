package com.example.unogame.gameScreen.card;

import com.example.unogame.gameScreen.card.cardStrategy.NumberCardStrategy;
import com.example.unogame.gameScreen.card.cardStrategy.PlusFourCardStrategy;
import com.example.unogame.gameScreen.card.cardStrategy.PlusTwoStrategy;
import com.example.unogame.gameScreen.card.cardStrategy.ReverseCardStrategy;
import com.example.unogame.gameScreen.card.cardStrategy.SkipStrategy;
import com.example.unogame.gameScreen.card.cardStrategy.WildCardStrategy;
import com.example.unogame.gameScreen.player.playStrategy.CardType;

public class SimpleCardFactory implements CardFactory {
    public Card getCard(CardType cardType, int color, String number) {
        Card c;
        if (cardType == CardType.NumberCard) {
            c = new NumberCard(number, color);
            c.strategy = new NumberCardStrategy();
            return c;
        }
        return null;
    }

    public Card getCard(CardType cardType, int color) {
        Card c;
        if (cardType == CardType.DrawTwoCard) {
            c = new DrawTwoCard(color);
            c.strategy = new PlusTwoStrategy();
            return c;
        } else if (cardType == CardType.SkipCard) {
            c = new SkipCard(color);
            c.strategy = new SkipStrategy();
            return c;
        } else if (cardType == CardType.ReverseCard) {
            c = new ReverseCard(color);
            c.strategy = new ReverseCardStrategy();
            return c;
        }
        return null;
    }

    public Card getCard(CardType cardType) {
        Card c;
        if (cardType == CardType.DrawFourCard) {
            c = new DrawFourCard();
            c.strategy = new PlusFourCardStrategy();
            return c;
        } else if (cardType == CardType.WildCard) {
            c = new WildCard();
            c.strategy = new WildCardStrategy();
            return c;
        }
        return null;
    }
}
