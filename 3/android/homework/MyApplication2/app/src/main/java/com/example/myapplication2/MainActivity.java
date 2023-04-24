package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity------>onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity------>onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity----->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity----->onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity----->nResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity----->onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("MainActivity----->onRestart");
    }

    public void jump(View view){
//        桥梁intent
        Intent intent = new Intent();
//        设置从一个Activity跳到另一个Activity
        intent.setClass(MainActivity.this,SecondActivity.class);
//        启动
        startActivity(intent);
    }

}