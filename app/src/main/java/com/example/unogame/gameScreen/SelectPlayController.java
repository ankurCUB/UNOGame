package com.example.unogame.gameScreen;

import android.app.Activity;

import com.example.unogame.ScreenNavigator;
import com.example.unogame.gameScreen.unoGame.UNOGameFragment;

import javax.inject.Inject;

public class SelectPlayController {

    private final ScreenNavigator screenNavigator;

    @Inject
    public SelectPlayController(ScreenNavigator screenNavigator) {
        this.screenNavigator = screenNavigator;
    }

    public void startGame(Activity activity){
        screenNavigator.navigateToFragment(new UNOGameFragment(), activity);
    }

    public void setBackButtonVisibility(Activity activity, boolean backButtonVisibility){
        screenNavigator.setBackButton(activity, backButtonVisibility);
    }
}
