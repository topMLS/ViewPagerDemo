package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //设置Page间间距
        mViewPager.setPageMargin(20);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter = new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                int p=position%(imgRes.length);
                ImageView view = new ImageView(MainActivity.this);
                view.setScaleType(ImageView.ScaleType.FIT_XY);
                view.setImageResource(imgRes[p]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View) object);
            }

            @Override
            public int getCount()
            {
                return imgRes.length*1000;
            }

            @Override
            public boolean isViewFromObject(View view, Object o)
            {
                return view == o;
            }
        });
        mViewPager.setCurrentItem(imgRes.length*200);
        mViewPager.setPageTransformer(true, new RotateYTransformer(new ScaleInTransformer(new AlphaPageTransformer())));

    }
}
