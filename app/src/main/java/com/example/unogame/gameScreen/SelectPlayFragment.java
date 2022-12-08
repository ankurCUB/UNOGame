package com.example.unogame.gameScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.unogame.databinding.FragmentSelectPlayBinding;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;

import javax.inject.Inject;

public class SelectPlayFragment extends Fragment {

    @Inject
    SelectPlayController selectPlayController;

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
        selectPlayController.setBackButtonVisibility(getActivity(), false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.playGame.setOnClickListener(view -> selectPlayController.startGame(getActivity()));
        // add stat screen
    }


}