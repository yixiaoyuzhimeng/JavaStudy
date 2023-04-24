package com.example.myapplication19_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {
    private MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.koko);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(MusicService.this,"开始播放",Toast.LENGTH_LONG).show();
        mp.start();
    }


        @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(MusicService.this,"结束播放",Toast.LENGTH_LONG).show();
        mp.stop();
    }
}
