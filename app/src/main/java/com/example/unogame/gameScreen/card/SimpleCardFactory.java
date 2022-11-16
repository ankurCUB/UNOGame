package com.example.unogame.gameScreen.card;

public class SimpleCardFactory implements CardFactory{
    public Card getCard(String type, int color, String number){
        Card c;
        if(type.equals("Number")) {
            c = new NumberCard(number, color);
            return c;
        }
        return null;
    }

    public Card getCard(String type, int color){
        Card c;
        if(type.equals("Draw Two")){
            c = new DrawTwoCard(color);
            return c;
        } else if(type.equals("Skip")){
            c = new SkipCard(color);
            return c;
        } else if(type.equals("Reverse")){
            c = new ReverseCard(color);
            return c;
        }
        return null;
    }

    public Card getCard(String type){
        Card c;
        if(type.equals("Draw Four")){
            c = new DrawFourCard();
            return c;
        } else if(type.equals("Wild Card")){
            c = new WildCard();
            return c;
        }
        return null;
    }
}
