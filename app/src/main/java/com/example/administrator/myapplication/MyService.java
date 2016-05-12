package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        if(intent.getFlags()==0){
            mediaPlayer=new MediaPlayer();

            mediaPlayer.setLooping(true);

            mediaPlayer=MediaPlayer.create(this,R.raw.zero);

            mediaPlayer.start();
        }else {
            mediaPlayer.stop();
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
