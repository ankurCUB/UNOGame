package com.example.unogame;

import android.app.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import javax.inject.Inject;

public class ScreenNavigator {

    private FragmentManager fragmentManager = null;

    @Inject
    public ScreenNavigator(){

    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setBackButton(Activity activity, boolean backButtonVisible){
        AppCompatActivity appCompatActivity =  ((AppCompatActivity)activity);
        if(appCompatActivity!=null){
            ActionBar actionBar = appCompatActivity.getSupportActionBar();
            if(actionBar!=null) {
                actionBar.setDisplayHomeAsUpEnabled(backButtonVisible);
            }
        }
    }

    public void navigateToFragment(Fragment fragment, Activity activity){
        fragmentManager = ((AppCompatActivity)activity).getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container_view_tag, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }



}
