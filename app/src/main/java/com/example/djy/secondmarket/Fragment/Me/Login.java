package com.example.djy.secondmarket.Fragment.Me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.djy.secondmarket.Fragment.MeFragment;
import com.example.djy.secondmarket.MainActivity;
import com.example.djy.secondmarket.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Button b_register = (Button)findViewById(R.id.b_register);
        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_register = new Intent(Login.this,Register.class);
                startActivity(intent_register);
            }
        });
        TextView t_foget = (TextView) findViewById(R.id.t_forget);
        t_foget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_forget = new Intent(Login.this,ForgetPassword.class);
                startActivity(intent_forget);
            }
        });


    }
}
