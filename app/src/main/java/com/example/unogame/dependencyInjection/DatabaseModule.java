package com.example.unogame.dependencyInjection;

import com.example.unogame.gameScreen.data.DatabaseManager;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    public DatabaseManager databaseManager(){
        return new DatabaseManager();
    }
}
