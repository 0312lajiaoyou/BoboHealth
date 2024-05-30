package com.example.bobohealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void fanhui(View view) {
        //open activity
        Intent intent = new Intent(this,WeightActivity.class);
        startActivity(intent);
    }
    public void save(View view) {
        Intent intent1 = new Intent(this, WeightActivity.class);

        EditText weightInput = findViewById(R.id.weight);
        if (weightInput.length()==0){
            //提示消息
            Toast.makeText(this, "请输入正确的数据", Toast.LENGTH_SHORT).show();
        }else {
            Float weight2 = Float.valueOf(weightInput.getText().toString());
            //传递参数
            intent1.putExtra("weight_key",weight2);

            startActivity(intent1);
        }
    }
}