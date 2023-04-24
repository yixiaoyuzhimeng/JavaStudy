package com.example.myapplication19_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) this.findViewById(R.id.btn1);
        btn2=(Button) this.findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点击第1个按钮",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,MusicPlayerActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点击第2个按钮",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,MusicControlPlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}