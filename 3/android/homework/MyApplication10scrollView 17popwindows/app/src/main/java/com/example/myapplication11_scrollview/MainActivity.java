package com.example.myapplication11_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im1 = (ImageView) findViewById(R.id.im1);
        ImageView im2 = (ImageView) findViewById(R.id.im2);
        ImageView im3 = (ImageView) findViewById(R.id.im3);
        ImageView im4 = (ImageView) findViewById(R.id.im4);

        Glide.with(this).load(R.drawable.i).into(im1);
        Glide.with(this).load(R.drawable.i2).into(im2);
        Glide.with(this).load(R.drawable.i3).into(im3);
        Glide.with(this).load(R.drawable.i4).into(im4);
//        Glide.with(this).load("https://pics7.baidu.com/feed/3b292df5e0fe99257ee20109ee08fed98cb17120.jpeg").into(im1);
//        Glide.with(this).load("https://pics7.baidu.com/feed/58ee3d6d55fbb2fbc01556fc97ea80a24723dc4d.jpeg").into(im2);
//        Glide.with(this).load("https://pics2.baidu.com/feed/1b4c510fd9f9d72a2f3ba2490d8a8832359bbbaa.jpeg").into(im3);
//        Glide.with(this).load("https://pics2.baidu.com/feed/4e4a20a4462309f71a72a39fa5aeacf5d6cad641.jpeg").into(im4);

    }
    public void goNext(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}