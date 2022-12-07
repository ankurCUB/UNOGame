package com.example.unogame.dependencyInjection;

import com.example.unogame.gameScreen.LoginFragment;
import com.example.unogame.gameScreen.SelectPlayFragment;
import com.example.unogame.gameScreen.unoGame.UNOGameFragment;

import dagger.Subcomponent;

@Subcomponent
public interface AppSubComponent {
    void inject(SelectPlayFragment selectPlayFragment);

    void inject(UNOGameFragment unoGameFragment);

    void inject(LoginFragment loginFragment);
}
