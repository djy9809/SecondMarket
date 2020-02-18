package com.example.djy.secondmarket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.djy.secondmarket.Fragment.FindFragment;
import com.example.djy.secondmarket.Fragment.HomeFragment;
import com.example.djy.secondmarket.Fragment.MeFragment;
import com.example.djy.secondmarket.Fragment.SortFragment;

public class MainActivity extends AppCompatActivity {

    // private TextView mTextMessage;
    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment;
    private SortFragment sortFragment;
    private FindFragment findFragment;
    private MeFragment meFragment;
    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment


    //初始化fragment和fragment数组
    private void initFragment() {
        homeFragment = new HomeFragment();
        sortFragment = new SortFragment();
        findFragment = new FindFragment();
        meFragment = new MeFragment();
        fragments = new Fragment[]{homeFragment, sortFragment, findFragment, meFragment};
        lastfragment = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview, homeFragment).show(homeFragment).commit();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }


    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Log.i("test", "item.getItemId() is :" + item.getItemId());

            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    if (lastfragment != 0) {
                        switchFragment(lastfragment, 0);
                        lastfragment = 0;
                    }
                    return true;
                }
                case R.id.navigation_sort: {
                    if (lastfragment != 1) {
                        switchFragment(lastfragment, 1);
                        lastfragment = 1;
                    }
                    return true;
                }
                case R.id.navigation_find: {
                    if (lastfragment != 2) {
                        switchFragment(lastfragment, 2);
                        lastfragment = 2;
                    }
                    return true;
                }
                case R.id.navigation_me: {
                    if (lastfragment != 3) {
                        switchFragment(lastfragment, 3);
                        lastfragment = 3;
                    }
                    return true;
                }
            }
            return false;
        }


        //如何切换Fragment
        private void switchFragment(int lastfragment, int index) {
            Log.i("Marketlog", "lastfragment is : " + lastfragment);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
            if (fragments[index].isAdded() == false) {
                transaction.add(R.id.mainview, fragments[index]);
            }
            transaction.show(fragments[index]).commitAllowingStateLoss();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initFragment();
        //mTextMessage = (TextView) findViewById(R.id.textView1);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(changeFragment);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        // 通过反射机制实现超过3图标时，不能显示文字的问题
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

};

