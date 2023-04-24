package com.example.myapplication7_click;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"匿名内部类",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new MyLitener());
        btn4.setOnClickListener(this);
        btn5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this,"长按实现匿名内部类",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }



    private class MyLitener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"自定义实现",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"继承方式实现",Toast.LENGTH_SHORT).show();
    }

    public void doClick(View view){
        Toast.makeText(MainActivity.this,"XML实现",Toast.LENGTH_SHORT).show();
    }
}