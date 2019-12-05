package com.example.gmail.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gmail.R;
import com.example.gmail.databinding.FragmentEnterBirthDetailsBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterBirthDetails extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private EditText monthEditText, dayEditText, yearEditText;
    private Spinner genderSpinner;
    private Button nextButton;
    private String[] genderArray;
    private String selectedGender;
    public static final String TAG = "enter_birth_details";
    private final String VALID_MONTH = "Enter Valid Month!";
    private final String VALID_DAY = "Enter Valid Day!";
    private final String VALID_YEAR = "Enter Valid Year!";
    private final String VALID_GENDER = "Select Valid Gender!";
    private String firstName, lastName;

    public EnterBirthDetails() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        genderArray = new String[]{"Male", "Female", "Other"};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentEnterBirthDetailsBinding enterBirthDetailsBinding =
                DataBindingUtil.inflate(inflater,  R.layout.fragment_enter_birth_details, container, false);
        monthEditText = enterBirthDetailsBinding.monthEditText;
        dayEditText = enterBirthDetailsBinding.dayEditText;
        yearEditText = enterBirthDetailsBinding.yearEditText;
        genderSpinner = enterBirthDetailsBinding.genderSpinner;
        nextButton = enterBirthDetailsBinding.nextButton;
        return enterBirthDetailsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        monthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                if (monthEditText.getText().toString().equals(String.valueOf(0)) || monthEditText.getText().toString().equals(String.valueOf(13))){
                    monthEditText.setError(VALID_MONTH);
                    monthEditText.getText().clear();
                }
            }
        });

        dayEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                if (dayEditText.getText().toString().equals(String.valueOf(0)) || dayEditText.getText().toString().equals(String.valueOf(32))){
                    dayEditText.setError(VALID_DAY);
                    dayEditText.getText().clear();
                }
            }
        });

        yearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                try {
                    if (yearEditText.getText().toString().equals("2019")){
                        yearEditText.setError(VALID_YEAR);
                        yearEditText.getText().clear();
                    }
                }catch (Exception e){
                    Log.d(TAG, "afterTextChanged_Exception: "+e.toString());
                }

            }
        });

        genderSpinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, genderArray);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(arrayAdapter);

        nextButton.setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            EnterBirthDetailsArgs enterBirthDetailsArgs = EnterBirthDetailsArgs.fromBundle(getArguments());
            firstName = enterBirthDetailsArgs.getFirstName();
            lastName = enterBirthDetailsArgs.getLastName();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        monthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                if (monthEditText.getText().toString().equals(String.valueOf(0)) || monthEditText.getText().toString().equals(String.valueOf(13))){
                    monthEditText.setError(VALID_MONTH);
                    monthEditText.getText().clear();
                }
            }
        });

        dayEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                if (dayEditText.getText().toString().equals(String.valueOf(0)) || dayEditText.getText().toString().equals(String.valueOf(32))){
                    dayEditText.setError(VALID_DAY);
                    dayEditText.getText().clear();
                }
            }
        });

        yearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: "+s);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
                try {
                    if (yearEditText.getText().toString().equals("2019")){
                        yearEditText.setError(VALID_YEAR);
                        yearEditText.getText().clear();
                    }
                }catch (Exception e){
                    Log.d(TAG, "afterTextChanged_Exception: "+e.toString());
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedGender = genderArray[position];
        Log.d(TAG, "Selected Gender: "+selectedGender);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v == nextButton){
            if (!TextUtils.isEmpty(selectedMonth()) && !TextUtils.isEmpty(selectedMonth()) && !TextUtils.isEmpty(selectedMonth())){
                EnterBirthDetailsDirections.ActionBirthDetailsToGenerateEmailId actionBirthDetailsToGenerateEmailId
                        = EnterBirthDetailsDirections.actionBirthDetailsToGenerateEmailId();
                actionBirthDetailsToGenerateEmailId.setFirstName(firstName);
                actionBirthDetailsToGenerateEmailId.setLastName(lastName);
                actionBirthDetailsToGenerateEmailId.setMonth(selectedMonth());
                actionBirthDetailsToGenerateEmailId.setDay(selectedDay());
                actionBirthDetailsToGenerateEmailId.setYear(selectedYear());
                actionBirthDetailsToGenerateEmailId.setGender(selectedGender);
                Navigation.findNavController(nextButton).navigate(actionBirthDetailsToGenerateEmailId);
            }else if (TextUtils.isEmpty(selectedMonth())){
                monthEditText.setError(VALID_MONTH);
            }else if (TextUtils.isEmpty(selectedDay())){
                dayEditText.setError(VALID_DAY);
            }else if (TextUtils.isEmpty(selectedYear())){
                yearEditText.setError(VALID_YEAR);
            }else if (TextUtils.isEmpty(selectedGender)){
                ((TextView)genderSpinner.getSelectedView()).setError(VALID_GENDER);
            }
        }
    }

    private String selectedMonth(){
        return monthEditText.getText().toString().trim();
    }

    private String selectedDay(){
        return dayEditText.getText().toString().trim();
    }

    private String selectedYear(){
        return yearEditText.getText().toString().trim();
    }



}
