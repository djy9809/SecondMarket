package com.example.djy.secondmarket.Fragment.Sort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.djy.secondmarket.R;

public class SortClothes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_clothes);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
