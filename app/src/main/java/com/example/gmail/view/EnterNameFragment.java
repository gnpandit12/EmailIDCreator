package com.example.gmail.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.gmail.R;

import org.w3c.dom.Text;

public class EnterNameFragment extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private EditText firstNameEditText, lastNameEditText;
    private Button nextButton;
//    private NavController navController;

    public EnterNameFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstNameEditText = view.findViewById(R.id.first_name_edit_text);
        lastNameEditText = view.findViewById(R.id.last_name_edit_text);
        nextButton = view.findViewById(R.id.next_button);
//        navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        nextButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == nextButton){
            if (!TextUtils.isEmpty(firstName()) && !TextUtils.isEmpty(lastName())){
//                navController.navigate(R.id.action_enter_name_to_enter_birth_details);
                EnterNameFragmentDirections.ActionEnterNameToEnterBirthDetails actionEnterNameToEnterBirthDetails =
                        EnterNameFragmentDirections.actionEnterNameToEnterBirthDetails();
                actionEnterNameToEnterBirthDetails.setFirstName(firstName());
                actionEnterNameToEnterBirthDetails.setLastName(lastName());
                Navigation.findNavController(v).navigate(actionEnterNameToEnterBirthDetails);
            }else if (TextUtils.isEmpty(firstName())){
                firstNameEditText.setError("Enter First Name");
            }else if (TextUtils.isEmpty(lastName())){
                lastNameEditText.setError("Enter Last Name");
            }else if (TextUtils.isEmpty(firstName()) && TextUtils.isEmpty(lastName())){
                firstNameEditText.setError("Enter First Name");
                lastNameEditText.setError("Enter Last Name");
            }
        }
    }

    private String firstName(){
        return firstNameEditText.getText().toString().trim();
    }

    private String lastName(){
        return lastNameEditText.getText().toString().trim();
    }



}
