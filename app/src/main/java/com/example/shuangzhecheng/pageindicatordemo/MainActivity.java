package com.example.shuangzhecheng.pageindicatordemo;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager vp;
    private int[] layoutSet = {R.layout.firstpage, R.layout.secondpage, R.layout.thirdpage};
    private CustomPagerAdapter customPagerAdapter;
    private LinearLayout dotsLayout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.viewPager);
        customPagerAdapter = new CustomPagerAdapter(layoutSet, this);
        vp.setAdapter(customPagerAdapter);
        dotsLayout = findViewById(R.id.dotLayout);
        createDots(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void createDots(int position){
        if(dotsLayout != null){
            dotsLayout.removeAllViews();
            dots = new ImageView[layoutSet.length];
            for(int i = 0; i < dots.length; i++){
                dots[i] = new ImageView(this);
                if(i == position){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
                }
                else{
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dot));
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,0,10,0);
                dotsLayout.addView(dots[i],params);
            }
        }
    }
}
