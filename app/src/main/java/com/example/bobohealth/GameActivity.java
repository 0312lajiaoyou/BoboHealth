package com.example.bobohealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    int oldsum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this,HomepageActivity.class);
        startActivity(intent);
    }
    public void game(View view) {
        TextView scoreA=findViewById(R.id.out1);
        oldsum=Integer.parseInt(scoreA.getText().toString());
        if (view.getId()==R.id.button1) {//+1
            scoreA.setText(String.valueOf(oldsum+1));
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView scoreA=findViewById(R.id.out1);
        oldsum=Integer.parseInt(scoreA.getText().toString());
        outState.putInt("sum",oldsum);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView scoreA=findViewById(R.id.out1);
        oldsum = savedInstanceState.getInt("sum");
        scoreA.setText(String.valueOf(oldsum));
    }
}