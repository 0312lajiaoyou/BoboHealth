package com.example.bobohealth;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //接收传入数据
        Intent intent = getIntent();
        float weight1 = intent.getFloatExtra("weight_key", 0);
        String date1=intent.getStringExtra("date_key");
        Log.i(TAG,"onCreate: get weight2="+weight1);

        TextView myout=findViewById(R.id.out);
        myout.setText(String.format("今日体重：%.2f "+"kg", weight1));
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this,HomepageActivity.class);
        startActivity(intent);
    }
    public void add(View view) {
        //open activity
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}