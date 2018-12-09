package com.example.djy.secondmarket.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djy.secondmarket.Fragment.Sort.SortBooks;
import com.example.djy.secondmarket.Fragment.Sort.SortClothes;
import com.example.djy.secondmarket.Fragment.Sort.SortDaily;
import com.example.djy.secondmarket.Fragment.Sort.SortDigital;
import com.example.djy.secondmarket.Fragment.Sort.SortElectrical;
import com.example.djy.secondmarket.Fragment.Sort.SortSports;
import com.example.djy.secondmarket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment {

    private TextView textView2;


    public void onStart(){
        super.onStart();
        LinearLayout L_digital = getActivity().findViewById(R.id.ll_digital);
        L_digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_digital = new Intent(getActivity(),SortDigital.class);
                startActivity(intent_digital);

            }
        });

        LinearLayout L_electrical = getActivity().findViewById(R.id.ll_electrical);
        L_electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_electrical = new Intent(getActivity(), SortElectrical.class);
                startActivity(intent_electrical);

            }
        });


        LinearLayout L_daily = getActivity().findViewById(R.id.ll_daily);
        L_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_daily = new Intent(getActivity(), SortDaily.class);
                startActivity(intent_daily);

            }
        });

        LinearLayout L_books = getActivity().findViewById(R.id.ll_books);
        L_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_books = new Intent(getActivity(), SortBooks.class);
                startActivity(intent_books);

            }
        });

        LinearLayout L_clothes = getActivity().findViewById(R.id.ll_clothes);
        L_clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_clothes = new Intent(getActivity(), SortClothes.class);
                startActivity(intent_clothes);

            }
        });

        LinearLayout L_sports = getActivity().findViewById(R.id.ll_sports);
        L_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_sports = new Intent(getActivity(), SortSports.class);
                startActivity(intent_sports);

            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        return view;
    }


    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}