package com.example.djy.secondmarket.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.djy.secondmarket.R;

public class HomeSearch extends AppCompatActivity {

//    private SearchView mSearchView;
//    private ListView mListView;
//    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_search);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        mSearchView = (SearchView) findViewById(R.id.searchView);
//        mListView = (ListView) findViewById(R.id.listView);
//        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
//        mListView.setTextFilterEnabled(true);
//
//        // 设置搜索文本监听
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            // 当点击搜索按钮时触发该方法
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            // 当搜索内容改变时触发该方法
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (!TextUtils.isEmpty(newText)){
//                    mListView.setFilterText(newText);
//                }else{
//                    mListView.clearTextFilter();
//                }
//                return false;
//            }
//        });

    }


}
