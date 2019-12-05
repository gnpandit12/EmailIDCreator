package com.example.gmail.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.gmail.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button createEmailIDButton;
    private NavController navController;

    public HomeFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createEmailIDButton = view.findViewById(R.id.create_email_id_button);
        createEmailIDButton.setOnClickListener(this);

        navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);


    }


    @Override
    public void onClick(View v) {
        if (v == createEmailIDButton){
            navController.navigate(R.id.action_home_to_enter_name_fragment);
        }
    }
}
