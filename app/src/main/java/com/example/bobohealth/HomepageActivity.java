package com.example.bobohealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomepageActivity extends AppCompatActivity {
    private static final String Tag="homepageactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView myout= findViewById(R.id.out);
        myout.setText("BMI计算器");
        System.out.println("this is system.out.println");
    }
    public void calorie(View view) {
        //open activity
        Intent intent = new Intent(this,CalorieActivity.class);
        startActivity(intent);
    }
    public void diet(View view) {
        //open activity
        Intent intent = new Intent(this,DietActivity.class);
        startActivity(intent);
    }
    public void weight(View view) {
        //open activity
        Intent intent = new Intent(this,WeightActivity.class);
        startActivity(intent);
    }
    public void game(View view) {
        //open activity
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }
    public void Click(View view) {
        String msg = "Click:111111111";
        Log.i(Tag,msg);
        EditText input1=findViewById(R.id.input1);
        EditText input2=findViewById(R.id.input2);
        if (input1.length()==0||input2.length()==0){
            Toast.makeText(this, "请输入身高体重", Toast.LENGTH_SHORT).show();
        }else {
            float height=Float.parseFloat(input1.getText().toString());
            float weight=Float.parseFloat(input2.getText().toString());
            float x1=height*height;
            float bmi=weight/x1;

            TextView myout=findViewById(R.id.out);
            String result;
            if(bmi<18){
                result="\n您偏瘦了";
            }else if(bmi<24){
                result="\n您bmi正常";
            }else{
                result="\n您偏胖了";
            }
            myout.setText(String.format("您的BMI为：%.2f "+result, bmi));
        }
    }
}