package com.example.unogame.gameScreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.unogame.ScreenNavigator;
import com.example.unogame.databinding.FragmentLoginBinding;
import com.example.unogame.dependencyInjection.AppComponent;
import com.example.unogame.dependencyInjection.DaggerAppComponent;
import com.example.unogame.gameScreen.data.DatabaseManager;

import javax.inject.Inject;

public class LoginFragment extends Fragment {

    @Inject
    ScreenNavigator screenNavigator;

    @Inject
    DatabaseManager databaseManager;

    FragmentLoginBinding binding;

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
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        screenNavigator.setBackButton(this.getActivity(), false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.loginButton.setOnClickListener(view -> {
            Log.i("Username", binding.useName.getText().toString());
            Log.i("Password", binding.password.getText().toString());
            Bundle bundle = new Bundle();
            bundle.putString("Username", binding.useName.getText().toString());

            Intent intent = new Intent(this.getActivity(), GameScreenActivity.class);
            intent.putExtra("Username", bundle);
            startActivity(intent);
            if (this.getActivity() != null) {
                this.getActivity().finish();
            }
        });
//        binding.playGame.setOnClickListener(view -> selectPlayController.startGame(getActivity()));
    }


}