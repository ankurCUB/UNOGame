package com.example.unogame.gameScreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unogame.ScreenNavigator;
import com.example.unogame.databinding.FragmentSelectPlayBinding;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;
import com.example.unogame.gameScreen.unoGame.UNOGameFragment;

import javax.inject.Inject;

public class SelectPlayFragment extends Fragment {

    @Inject
    ScreenNavigator screenNavigator;

    FragmentSelectPlayBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        appComponent.appSubComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSelectPlayBinding.inflate(inflater, container, false);
        screenNavigator.setBackButton(getActivity(), false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.playGame.setOnClickListener(view -> {
            screenNavigator.navigateToFragment(new UNOGameFragment(), getActivity());
        });
    }


}