package com.example.unogame.gameScreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unogame.R;
import com.example.unogame.ScreenNavigator;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;
import com.example.unogame.gameScreen.data.DatabaseManager;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    DatabaseManager databaseManager;

    @Inject
    ScreenNavigator screenNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
        screenNavigator.navigateToFragment(new LoginFragment(), this);
    }
}