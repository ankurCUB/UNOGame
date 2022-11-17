package com.example.unogame.gameScreen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.unogame.gameScreen.data.DatabaseManager;
import com.example.unogame.R;
import com.example.unogame.ScreenNavigator;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;

import javax.inject.Inject;

public class GameScreenActivity extends AppCompatActivity {

    @Inject
    DatabaseManager databaseManager;

    @Inject
    ScreenNavigator screenNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.inject(this);

        screenNavigator.navigateToFragment(new SelectPlayFragment(), this);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = screenNavigator.getFragmentManager();
        if(fragmentManager!=null){
            if(fragmentManager.getBackStackEntryCount()==1){
                finish();
            }
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}