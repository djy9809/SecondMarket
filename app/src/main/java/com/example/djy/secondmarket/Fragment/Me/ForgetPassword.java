package com.example.djy.secondmarket.Fragment.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.djy.secondmarket.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
