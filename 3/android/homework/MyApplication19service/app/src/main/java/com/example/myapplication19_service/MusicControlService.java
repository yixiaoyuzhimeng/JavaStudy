package com.example.myapplication19_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;



public class MusicControlService extends Service {

    private MediaPlayer mp;

    public class Controller extends Binder{

        public void pause(){
            if(mp!=null && mp.isPlaying()){
                mp.pause();
            }
        }

        public void play(){
            if(mp!=null ){
                mp.start();
            }
        }

        public void stop(){
            if(mp!=null ){
                mp.stop();
            }
            MusicControlService.this.stopSelf();
        }

        public int getDuration(){
            return mp.getDuration();
        }

        public int getCurrentPosition(){
            return mp.getCurrentPosition();
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return new Controller();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.koko);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp!=null)
            mp.release();
        mp=null;
    }

}
