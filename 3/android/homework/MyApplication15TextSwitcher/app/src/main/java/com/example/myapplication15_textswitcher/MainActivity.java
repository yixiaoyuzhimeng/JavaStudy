package com.example.myapplication15_textswitcher;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnTouchListener {

    final String[] strs=new String[]{"丹麦","芬兰","挪威","瑞典","冰岛"};
    private int index;
    private float downX,upX;
    private TextSwitcher textSw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSw=(TextSwitcher) findViewById(R.id.textSw);
        textSw.setFactory(this);
        textSw.setOnTouchListener(this);
        index=0;
        textSw.setInAnimation( AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        textSw.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX= motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                upX=motionEvent.getX();
                if (upX>downX) {
                    if(index>0){
                        index--;
                        textSw.setCurrentText(strs[index]);
                    }else{
                        Toast.makeText(this,"到头了",Toast.LENGTH_SHORT).show();
                    }
                }
                if (upX<downX) {
                    if(index<strs.length-1){
                        index++;
                        textSw.setCurrentText(strs[index]);
                    }else{
                        Toast.makeText(this,"到尾了",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public View makeView() {
        final TextView textView=new TextView(this);
        textView.setTextColor(Color.rgb(0,0,255));
        textView.setTextSize(100);
//        注意布局的设置
        textView.setLayoutParams(new TextSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        textView.setText(strs[index]);
        return textView;
    }
}