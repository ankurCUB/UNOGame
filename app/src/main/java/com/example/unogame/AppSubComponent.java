package com.example.unogame;

import dagger.Subcomponent;

@Subcomponent
public interface AppSubComponent {
    void inject(SelectPlayFragment selectPlayFragment);

    void inject(UNOGameFragment unoGameFragment);
}
