package com.example.djy.secondmarket.Fragment.Me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.djy.secondmarket.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
