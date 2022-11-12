package com.example.unogame;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class GameScreenActivity extends AppCompatActivity {

    @Inject
    DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, ""+databaseManager.abc, Toast.LENGTH_LONG).show();
    }
}