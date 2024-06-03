package com.example.bobohealth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        Intent intent1 = new Intent(this, LoginActivity.class);

        EditText nameInput = findViewById(R.id.Name);
        EditText pwdInput = findViewById(R.id.Password);
        EditText cpwdInput = findViewById(R.id.ConfigPassword);
        if (nameInput.length()==0||pwdInput.length()==0||cpwdInput.length()==0){
            //提示消息
            Toast.makeText(this, "账号或密码不可以为空", Toast.LENGTH_SHORT).show();
        }else if (pwdInput!=cpwdInput){
            //提示消息
            Toast.makeText(this, "请确认两次密码无误", Toast.LENGTH_SHORT).show();
        }else {
            //注册成功则弹出对话框 点击<去登录>后进入登录页面 注册失败则提醒注册失败
            Float name = Float.valueOf(nameInput.getText().toString());
            Float pwd = Float.valueOf(pwdInput.getText().toString());
            Float cpwd = Float.valueOf(cpwdInput.getText().toString());
        }
    }
    public void login(View view) {
        //open activity
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}