package com.example.gmail.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.gmail.R;
import com.example.gmail.databinding.ActivityEnterNameBinding;

public class EnterNameActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityEnterNameBinding enterNameBinding;
    private String firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enterNameBinding = DataBindingUtil.setContentView(this, R.layout.activity_enter_name);

    }

    @Override
    public void onClick(View v) {
        if (v == enterNameBinding.nextButton){
            // Navigate To Birth Details Activity...
            firstName = enterNameBinding.firstNameEditText.getText().toString().trim();
            lastName = enterNameBinding.lastNameEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)
                    || !TextUtils.isEmpty(firstName) || !TextUtils.isEmpty(lastName)){
                // First & Last Name Not Empty
                // Navigate to Next Activity || Save First & Last Name In Local Database For Temp...



            }else {
                enterNameBinding.firstNameEditText.setError("First Name Can Not Be Empty!");
                enterNameBinding.lastNameEditText.setError("Last Name Can Not Be Empty!");
            }

        }
    }



}
