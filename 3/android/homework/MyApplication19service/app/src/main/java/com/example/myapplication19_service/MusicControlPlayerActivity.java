package com.example.myapplication19_service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MusicControlPlayerActivity extends Activity {
    Button start,stop,play,pause;
    boolean isStart=false;
    boolean isPlaying=false;
    ImageView faceImage;

    private MusicControlService.Controller service;

    private ServiceConnection mConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            service=(MusicControlService.Controller)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            service=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_control_layout);
        findView();
        start.setOnClickListener(startlis);
        stop.setOnClickListener(stoplis);
        pause.setOnClickListener(pauselis);
        play.setOnClickListener(playlis);
    }

    private View.OnClickListener startlis=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            faceImage.setBackgroundResource(R.drawable.playing);
            Intent intent=new Intent(MusicControlPlayerActivity.this,MusicControlService.class);
            bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
            isStart=true;
        }
    };

    private View.OnClickListener playlis=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isStart){
                faceImage.setImageResource(R.drawable.player);
                service.play();
                isPlaying=true;
                Toast.makeText(MusicControlPlayerActivity.this,""+service.getDuration(),Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MusicControlPlayerActivity.this,"请先启动播放器，然后播放！"+service.getDuration(),Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener pauselis=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isPlaying){
                faceImage.setImageResource(0);
                service.pause();
            }
        }
    };

    private View.OnClickListener stoplis=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isStart){
                faceImage.setImageResource(0);
                faceImage.setBackgroundResource(R.drawable.players);
                service.stop();
                unbindService(mConnection);
                service=null;
                isStart=false;
                isPlaying=false;
            }
        }
    };

    private void findView() {
        start=(Button) findViewById(R.id.start);
        stop=(Button)  findViewById(R.id.stop);
        play=(Button)  findViewById(R.id.play);
        pause= (Button) findViewById(R.id.pause);
        faceImage= (ImageView) findViewById(R.id.faceImage);
    }


}
