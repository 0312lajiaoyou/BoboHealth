package com.example.bobohealth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view) {
        Intent intent1 = new Intent(this, HomepageActivity.class);

        EditText nameInput = findViewById(R.id.Name);
        EditText pwdInput = findViewById(R.id.Password);
        if (nameInput.length()==0||pwdInput.length()==0){
            //提示消息
            Toast.makeText(this, "账号或密码不可以为空", Toast.LENGTH_SHORT).show();
        }else {
            //登录成功则直接进入首页 登录失败则提示登录失败
            Float name = Float.valueOf(nameInput.getText().toString());
            Float pwd = Float.valueOf(pwdInput.getText().toString());
            startActivity(intent1);
        }
    }
    public void register(View view) {
        //open activity
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void prob(View view) {
        //open activity
        Intent intent = new Intent(this,HomepageActivity.class);
        startActivity(intent);
    }
}