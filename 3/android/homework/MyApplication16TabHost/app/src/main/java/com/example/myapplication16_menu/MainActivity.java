package com.example.myapplication16_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    private TabHost tabHost;
    private  float initx;
    private float currentx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        获取组件
        tabHost=(TabHost) findViewById(R.id.tabhost);
//        初始化
        tabHost.setup();
//        监听
        tabHost.setOnTouchListener(this);
//        添加tab
        for(int i=0;i<4;i++){
            View view= LayoutInflater.from(this).inflate(R.layout.myindicator,null,false);
            TextView textView=(TextView) view.findViewById(R.id.tv_indicator);
            ImageView imageView=(ImageView) view.findViewById(R.id.iv_indicator);
            switch (i){
                case 0:
                    textView.setText("微信");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    tabHost.addTab(tabHost.newTabSpec("1").setIndicator(view).setContent(R.id.tv_one));
                    break;
                case 1:
                    textView.setText("通讯录");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    tabHost.addTab(tabHost.newTabSpec("2").setIndicator(view).setContent(R.id.tv_two));
                    break;
                case 2:
                    textView.setText("发现");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    tabHost.addTab(tabHost.newTabSpec("3").setIndicator(view).setContent(R.id.tv_three));
                    break;
                case 3:
                    textView.setText("微信");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    tabHost.addTab(tabHost.newTabSpec("4").setIndicator(view).setContent(R.id.tv_four));
                    break;
            }
        }

        ((TextView)tabHost.getCurrentTabView().findViewById(R.id.tv_indicator))
                .setTextColor(getResources().getColor(R.color.colorPrimary));
//        设置标签切换监听器
        tabHost.setOnTabChangedListener((tabId)->{
            for(int i=0;i<4;i++){
                ((TextView)tabHost.getTabWidget().getChildTabViewAt(i).findViewById(R.id.tv_indicator))
                        .setTextColor(getResources().getColor(R.color.colorAccent));
            }
            if(tabHost.getCurrentTabTag()==tabId){
                ((TextView)tabHost.getCurrentTabView().findViewById(R.id.tv_indicator))
                        .setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                initx=motionEvent.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                currentx= motionEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                if((currentx-initx)>25){
                    if(tabHost.getCurrentTab()!=0){
                        tabHost.setCurrentTab(tabHost.getCurrentTab()-1);
                    }
                }else if((currentx-initx)<-25){
                    if(tabHost.getCurrentTab()!=tabHost.getTabContentView().getChildCount()){
                        tabHost.setCurrentTab(tabHost.getCurrentTab()+1);
                    }
                }
                break;
        }
        return true;
    }
}