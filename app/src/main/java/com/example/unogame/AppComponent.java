package com.example.unogame;

import dagger.Component;

@Component(modules = DatabaseModule.class)
public interface AppComponent {
     void inject(GameScreenActivity gameScreenActivity);
     AppSubComponent appSubComponent();
}
