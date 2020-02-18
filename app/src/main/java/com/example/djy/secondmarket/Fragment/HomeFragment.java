package com.example.djy.secondmarket.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.djy.secondmarket.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.LinearLayout.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnBannerListener {
    //这是第一种做法，从刚才的方法来看，onBannerListerer中只声明了一个抽象方法，所以，如果实现了这个接口，一定要定义onBannerClick的方法
//    public class HomeFragment extends Fragment implements OnBannerListener{

    private Banner banner;
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;

    public void onStart() {
        super.onStart();
        initView();
        TextView textView_search = getActivity().findViewById(R.id.search_message_home);
        textView_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),HomeSearch.class);
                startActivity(intent);
            }
        });
    }

    //绑定此fragment的布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }


    //视图控件实例化
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void initView() {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add(R.drawable.p1);
        list_path.add(R.drawable.p2);
        list_path.add(R.drawable.p3);
        list_title.add("hey girl!");
        list_title.add("good job!");
        list_title.add("well done!");
        banner = getActivity().findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setBannerTitles(list_title);
        banner.isAutoPlay(true);
        banner.setDelayTime(5000);
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default)
                .setOnBannerListener(this)
                .start();

    }

    //轮播图的监听方法
    public void OnBannerClick(int position) {
        //这个地方是第一种做法，实现onBannerListener接口的重写方法
        Log.i("tag", "你点了第" + position + "张轮播图");
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


}





