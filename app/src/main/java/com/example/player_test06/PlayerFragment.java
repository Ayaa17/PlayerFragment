package com.example.player_test06;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.Delayed;

public class PlayerFragment extends Fragment implements SurfaceHolder.Callback {

//    Bundle bundle=new Bundle();
    private String TAG= getClass().getSimpleName();
    private FrameLayout frameLayout;
    private ProgressBar progressBarLoading,progressBarTime;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Runnable runnable;
    private Handler handler= new Handler();
    private MediaPlayer mediaPlayer;
    private String position123;
    private int count;
    private int surfaceWidth,surfaceHeight,videoWidth,VideoHight;
    private float max;
    private int pos;
    protected PlayerFragment(String position,int pos2){
        position123=position;
        pos=pos2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TAG=TAG+pos;
        frameLayout = view.findViewById(R.id.frameLayout01);
        progressBarLoading=view.findViewById(R.id.progressBar2);
        progressBarTime=view.findViewById(R.id.progressBar3);
        surfaceView=view.findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(PlayerFragment.this);
        mediaPlayer= new MediaPlayer();
        try {
            mediaPlayer.setDataSource(position123);
//            mediaPlayer.prepareAsync();
            mediaPlayer.prepareAsync();
//            mediaPlayer.prepareAsync();
//            mediaPlayer.seekTo(1);
//            progressBarTime.setMax(mediaPlayer.getDuration());
//            progressBarLoading.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onViewCreated: ");

        runnable=new Runnable() {
            @Override
            public void run() {
                progressBarTime.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 0);
                mediaPlayer.setLooping(true);
            }
        };
        handler.postDelayed(runnable, 0);


    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated: "+pos);

        mediaPlayer.setDisplay(surfaceHolder);
        Log.d(TAG, "surfaceCreated: +SET+OK");
        mediaPlayer.setScreenOnWhilePlaying(true);
        surfaceWidth=surfaceView.getWidth();
        surfaceHeight=surfaceView.getHeight();
//        Log.d(TAG, "surfaceCreated: "+surfaceWidth+"/"+surfaceHeight);
//

//        mediaPlayer.prepareAsync();
        progressBarLoading.setVisibility(View.VISIBLE);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressBarTime.setMax(mp.getDuration());
                progressBarLoading.setVisibility(View.INVISIBLE);
                mp.seekTo(1);
//                mp.start();
                Log.d(TAG, "onPrepared: OK"+pos);
//                Log.d(TAG, "onPrepared: "+mp.getVideoWidth()+"/"+mp.getVideoWidth());
//
                videoWidth=mp.getVideoWidth();
                VideoHight= mp.getVideoHeight();
//                max =  ((float)surfaceWidth/(float)videoWidth)<= ((float)surfaceHeight/(float)VideoHight)?((float)surfaceWidth/(float)videoWidth):((float)surfaceHeight/(float)VideoHight);}
                max =  ((float)surfaceWidth/(float)videoWidth)<= ((float)surfaceHeight/(float)VideoHight)?((float)surfaceWidth/(float)videoWidth):((float)surfaceHeight/(float)VideoHight);
                Log.d(TAG, "surfaceCreated: "+pos+":"+surfaceWidth+"/"+videoWidth);
                surfaceView.setLayoutParams(new FrameLayout.LayoutParams((int)(Math.ceil((videoWidth*max))),(int)(Math.ceil(VideoHight*max)),Gravity.CENTER));
//                Log.d("MMM", "onPrepared: "+surfaceView.getForegroundGravity().);

            }

        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "onCompletion: ");
            }
        });


        runnable=new Runnable() {
            @Override
            public void run() {
                progressBarTime.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, 0);
            }
        };
//        Log.d("MAX", "surfaceCreated: "+surfaceWidth+"/"+videoWidth);
//        Log.d("MAX", "surfaceCreated: "+((float)surfaceWidth/(float)videoWidth)+"/"+((float)surfaceHeight/(float)VideoHight));
//        Log.d("MAX", "surfaceCreated: "+max);
//        surfaceView.setLayoutParams(new FrameLayout.LayoutParams((int)(Math.ceil((videoWidth*max))),(int)(Math.ceil(VideoHight*max))));
//        mediaPlayer.setDisplay(surfaceHolder);
//        surfaceView.setLayoutParams(new FrameLayout.LayoutParams((int)Math.ceil((videoWidth*max)), (int)Math.ceil((VideoHight*max))));




    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged: "+pos);


//        runnable=new Runnable() {
//            @Override
//            public void run() {
//                progressBarTime.setProgress(mediaPlayer.getCurrentPosition());
//                handler.postDelayed(this, 0);
//            }
//        };
//        Log.d(TAG, "surfaceChanged: "+pos);
        handler.postDelayed(runnable, 0);

//        changeVideoSize();



    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed: "+pos);
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
//        onPause();



    }



    @Override
    public void onResume() {
        Log.d(TAG, "onResume: ");

        super.onResume();

//        Log.d(TAG, "onResume:pos: "+pos);

        mediaPlayer.start();
        if(mediaPlayer.isPlaying()){
            Log.d(TAG, "onResume: isplaying");
        }

        handler.postDelayed(runnable, 0);
        count = 0;
        while(!mediaPlayer.isPlaying() && count<20 ){
            try {

                Log.d(TAG, "onResume: delay"+pos);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            mediaPlayer.start();
        }
        if (mediaPlayer.isPlaying()){
            progressBarLoading.setVisibility(View.INVISIBLE);
        }


    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        };
        if(!mediaPlayer.isPlaying()){
//            mediaPlayer.start();
//            mediaPlayer.pause();
            progressBarLoading.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void changeVideoSize() {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();

        //根據視頻尺寸去計算->視頻可以在sufaceView中放大的最大倍數。
        float max=1;
//        if (getResources().getConfiguration().orientation== ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
//            //豎屏模式下按視頻寬度計算放大倍數值
//            max = Math.max((float) videoWidth / (float) surfaceWidth,(float) videoHeight / (float) surfaceHeight);
//        } else{
//            //橫屏模式下按視頻高度計算放大倍數值
//            max = Math.max(((float) videoWidth/(float) surfaceHeight),(float) videoHeight/(float) surfaceWidth);
//        }

        //視頻寬高分別/最大倍數值 計算出放大后的視頻尺寸
        videoWidth = (int) Math.ceil((float) videoWidth / max);
        videoHeight = (int) Math.ceil((float) videoHeight / max);

        //無法直接設置視頻尺寸，將計算出的視頻尺寸設置到surfaceView 讓視頻自動填充。
        surfaceView.setLayoutParams(new RelativeLayout.LayoutParams(videoWidth, videoHeight));

    }

}