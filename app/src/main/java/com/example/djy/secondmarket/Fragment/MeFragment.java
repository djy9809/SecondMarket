package com.example.djy.secondmarket.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.djy.secondmarket.Fragment.Me.Login;
import com.example.djy.secondmarket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {


    public void onStart(){
        super.onStart();
        LinearLayout click_login = getActivity().findViewById(R.id.click_login);
        click_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_cl = new Intent(getActivity(), Login.class);
                startActivity(intent_cl);
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        return view;
    }

}
