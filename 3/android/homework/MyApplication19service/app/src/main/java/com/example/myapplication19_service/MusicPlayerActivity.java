package com.example.myapplication19_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MusicPlayerActivity extends Activity {
    Button start,stop;
    ImageView faceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_layout);
        findView();
        start.setOnClickListener(startlis);
        stop.setOnClickListener(stoplis);
    }

    private View.OnClickListener startlis=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            faceImage.setBackgroundResource(R.drawable.ic_launcher_foreground);
            startService(new Intent(MusicPlayerActivity.this,MusicService.class));
        }
    };

    private View.OnClickListener stoplis=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            faceImage.setBackgroundResource(R.drawable.ic_launcher_background);
            stopService(new Intent(MusicPlayerActivity.this,MusicService.class));
        }
    };
    
    private void findView() {
        start=(Button) findViewById(R.id.start);
        stop=(Button) findViewById(R.id.stop);
        faceImage=(ImageView) findViewById(R.id.faceImage);
    }


}
