package com.example.bobohealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DietActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        ViewPager2 viewPager = findViewById(R.id.viewpager);
        MyPageAdapter pageAdapter=new MyPageAdapter(this);
        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout =findViewById(R.id.navigation);
        new TabLayoutMediator(tabLayout,viewPager,new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                tab.setText("早餐,午餐,晚餐".split(",")[position]);
            }
        }).attach();
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this,HomepageActivity.class);
        startActivity(intent);
    }
}