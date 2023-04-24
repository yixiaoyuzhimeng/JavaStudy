package com.example.myapplication5_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean flag = false;
    private ImageView iv;
    private ImageView iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    flag = true;
//                    2.1
////                    1)首先拿到资源
//                    Resources resources=getApplicationContext().getResources();
////                    2)通过id获取到drawable对象
//                    Drawable drawable=resources.getDrawable(R.drawable.my);
////                    3）设置图片
//                    iv.setImageDrawable(drawable);
//                  2.2
                    iv.setImageResource(R.drawable.my);
//                    2.3
                    Resources resources=getApplicationContext().getResources();
                    Drawable drawable=resources.getDrawable(R.drawable.my);
                    iv2.setBackgroundDrawable(drawable);
                } else {
                    flag = false;
//                    2.1
//                    Resources resources=getApplicationContext().getResources();
//                    Drawable drawable=resources.getDrawable(R.drawable.home);
//                    iv.setImageDrawable(drawable);
//                    2.2
                    iv.setImageResource(R.drawable.home);
//                    2.3
                    Resources resources=getApplicationContext().getResources();
                    Drawable drawable=resources.getDrawable(R.drawable.home);
                    iv2.setBackgroundDrawable(drawable);
                }
            }
        });





    }
}