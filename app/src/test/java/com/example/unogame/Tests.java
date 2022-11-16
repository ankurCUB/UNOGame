package com.example.unogame;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.unogame.gameScreen.data.UserDataModel;
import com.example.unogame.gameScreen.unoGame.UNOBoard;
import com.example.unogame.gameScreen.unoGame.UNOGameModel;

public class Tests {
    @Test
    public void InitializeUNOGameBoard() {
        // create new UNO board passing a user data model matching the current user
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        // pass generated board to UNO game Model
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        unoBoard.generateBoard();
        // 75 cards (104 - (7 cards * 4 players) - 1 for top deck)
        assertTrue(unoBoard.cards.size() == 75);
        // 4 players to start. This will change.
        assertTrue(unoBoard.getNumPlayers() == 4);
        // all players have 7 cards to begin
        assertTrue(unoBoard.getPlayer(0).playerData.deck.size() == 7);
        assertTrue(unoBoard.getPlayer(1).playerData.deck.size() == 7);
        assertTrue(unoBoard.getPlayer(2).playerData.deck.size() == 7);
        assertTrue(unoBoard.getPlayer(3).playerData.deck.size() == 7);
        // top deck is a number card
        assertTrue(unoBoard.topDeck.getClass().getSimpleName().equals("NumberCard"));
    }

    @Test
    public void InitializeUNOGameModel() {
        // create new UNO board passing a user data model matching the current user
        UserDataModel userDataModel = new UserDataModel(0, "Lincoln");
        // pass generated board to UNO game Model
        UNOBoard unoBoard = new UNOBoard(userDataModel);
        unoBoard.generateBoard();

    }
}