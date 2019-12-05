package com.example.gmail.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gmail.R;
import com.example.gmail.databinding.FragmentGeneratEmailIdBinding;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GenerateEmailID extends Fragment implements View.OnClickListener {

    private Button generateEmailIDButton;
    private TextView newEmailIDTextView;
    private FragmentGeneratEmailIdBinding generatEmailIdBinding;
    private String randomEmailID;
    private String firstName, lastName, month, day, year, gender;
    private  String[] userDetails;

    public GenerateEmailID() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        generatEmailIdBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_generat_email_id, container, false);
        generateEmailIDButton = generatEmailIdBinding.createEmailIdButton;
        newEmailIDTextView = generatEmailIdBinding.newEmailIdTextView;
        return generatEmailIdBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateEmailIDButton.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            GenerateEmailIDArgs generateEmailIDArgs = GenerateEmailIDArgs.fromBundle(getArguments());
            firstName = generateEmailIDArgs.getFirstName();
            lastName = generateEmailIDArgs.getLastName();
            month = generateEmailIDArgs.getMonth();
            day = generateEmailIDArgs.getDay();
            year = generateEmailIDArgs.getYear();
            gender = generateEmailIDArgs.getGender();
            userDetails = new String[]{firstName, lastName, month, day, year};
        }
    }

    @Override
    public void onClick(View v) {
        if (v == generateEmailIDButton){
            String string = firstName+lastName+day+month+year;
            String newEmailID = randomAlphaNumeric(8, string) + "@gmail.com";
            newEmailIDTextView.setText(newEmailID);
        }
    }


    private String randomAlphaNumeric(int count, String string) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*string.length());
            builder.append(string.charAt(character));
        }
        return builder.toString();
    }
}
