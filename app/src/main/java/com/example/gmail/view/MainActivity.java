package com.example.gmail.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gmail.R;
import com.example.gmail.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.createEmailIdButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == mainBinding.createEmailIdButton){
            startActivity(new Intent(this, EnterNameActivity.class));
        }
    }
}
