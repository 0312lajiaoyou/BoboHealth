package com.example.bobohealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this,HomepageActivity.class);
        startActivity(intent);
    }
}