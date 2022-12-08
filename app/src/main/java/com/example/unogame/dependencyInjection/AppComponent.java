package com.example.unogame.dependencyInjection;

import com.example.unogame.gameScreen.GameScreenActivity;
import com.example.unogame.gameScreen.LoginActivity;

import dagger.Component;

@Component(modules = DatabaseModule.class)
public interface AppComponent {
     void inject(GameScreenActivity gameScreenActivity);

     AppSubComponent appSubComponent();

     void inject(LoginActivity loginActivity);
}
