package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        System.out.println("2Activity------>onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("2Activity------>onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("2Activity----->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("2Activity----->onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("2Activity----->nResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("2Activity----->onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("2Activity----->onRestart");
    }


}