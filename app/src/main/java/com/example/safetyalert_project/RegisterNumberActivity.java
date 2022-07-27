package com.example.safetyalert_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterNumberActivity extends AppCompatActivity {

    TextInputEditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_number);

        number = findViewById(R.id.numberEdit);
    }

    public void saveNumber(View view) {
        String numberString = number.getText().toString();
        if(numberString.length()==11){
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("ENUM", numberString);
            myEdit.apply();
            RegisterNumberActivity.this.finish();
        }else {
            Toast.makeText(this, "Entered number is not valid", Toast.LENGTH_SHORT).show();
        }
    }
}