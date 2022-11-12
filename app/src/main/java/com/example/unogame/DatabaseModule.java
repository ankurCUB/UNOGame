package com.example.unogame;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    public DatabaseManager databaseManager(){
        return new DatabaseManager();
    }
}
