package com.example.djy.secondmarket.Fragment;


import android.app.TabActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.djy.secondmarket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    private TextView textView;


    public void onStart() {
        super.onStart();
        TabHost m = getActivity().findViewById(R.id.tabhost);
        m.setup();

        LayoutInflater i = LayoutInflater.from(getActivity());
        i.inflate(R.layout.tab01, m.getTabContentView());
        i.inflate(R.layout.tab02, m.getTabContentView());//动态载入XML，而不需要Activity

        m.addTab(m.newTabSpec("tab1").setIndicator("摊位").setContent(R.id.LinearLayout01));
        m.addTab(m.newTabSpec("tab2").setIndicator("求购").setContent(R.id.LinearLayout02));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        return view;
    }

}
