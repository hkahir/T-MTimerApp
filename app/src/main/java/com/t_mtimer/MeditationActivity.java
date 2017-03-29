package com.t_mtimer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.t_mtimer.common.RingProgressBar;
import com.t_mtimer.common.Utilities;

import java.util.Timer;
import java.util.TimerTask;

public class MeditationActivity extends Activity {

    private RingProgressBar RPB;
    private MediaPlayer mPlayer;
    private Utilities utils;
    private Handler mHandler = new Handler();
    private TextView songCurrentDurationLabel, tvGoback;
    private String time_elapsed1 = "20:00";
    private String time_elapsed2 = "02:00";
    private Button btnRestart;
    private int progress = 0, secondsUntilFinished1 = 1200, secondsUntilFinished2 = 120, seconds1 = 0, minutes1 = 0, seconds2 = 0, minutes2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        RPB = (RingProgressBar) findViewById(R.id.pbWaterlab);
        songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
        tvGoback = (TextView) findViewById(R.id.tv_goback);
        btnRestart = (Button) findViewById(R.id.btn_restart);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = 0;
                mPlayer.stop();
                RPB.setProgress(0);
                time_elapsed1 = "20:00";
                time_elapsed2 = "02:00";
                songCurrentDurationLabel.setText(time_elapsed1);
                secondsUntilFinished1 = 1200;
                secondsUntilFinished2 = 120;
                mHandler.removeCallbacks(mUpdateTimeTask);
                Play_MP3();
            }
        });

        tvGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                finish();
                mHandler.removeCallbacks(mUpdateTimeTask);
            }
        });


        Play_MP3();
    }

    private void Play_MP3() {

        try {
            mPlayer = MediaPlayer.create(MeditationActivity.this, R.raw.tm_timer_sound);
            mPlayer.start();

            updateProgressBar();

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    mHandler.removeCallbacks(mUpdateTimeTask);

                }
            });
        } catch (Exception ex) {
            Log.e("Play_MP3() error", ex.toString());
        }
    }

    public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 10);
    }


    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {

            int i_current = mPlayer.getCurrentPosition() / 1000;

            if (i_current > 77) {

                progress += 1;
                if (i_current <= 1277) {

                    secondsUntilFinished1--;
                    RPB.setProgress(progress);


                    seconds1 = secondsUntilFinished1 % 60;
                    minutes1 = secondsUntilFinished1 / 60;

                    if (seconds1 >= 0 && minutes1 >= 0) {
                        time_elapsed1 = String.format("%02d", minutes1) + ":" + String.format("%02d", seconds1);

                        songCurrentDurationLabel.setText(time_elapsed1);
                    }
                    Log.e("In First Part ---->", time_elapsed1 + "And Timer --->" + Integer.toString(i_current));

                } else if (i_current == 1280) {

                    Log.e("In Rest ---->", Integer.toString(i_current));
                    progress = 0;
                    RPB.setMax(120);
                    RPB.setProgress(0);
                    songCurrentDurationLabel.setText(time_elapsed2);

                } else if (i_current > 1280) {

                    secondsUntilFinished2--;
                    RPB.setProgress(progress);


                    RPB.setProgress(progress);
                    seconds2 = secondsUntilFinished2 % 60;
                    minutes2 = secondsUntilFinished2 / 60;

                    if (seconds2 >= 0 && minutes2 >= 0) {
                        time_elapsed2 = String.format("%02d", minutes2) + ":" + String.format("%02d", seconds2);

                        songCurrentDurationLabel.setText(time_elapsed2);
                    }

                    Log.e("In Second Part ---->", time_elapsed2 + "And Timer --->" + Integer.toString(i_current));
                } else {
                    Log.e("Current second ---->", Integer.toString(i_current));
                }
            } else {
                Log.e("Current second ---->", Integer.toString(i_current));
            }
            mHandler.postDelayed(this, 1000);
        }
    };


    @Override
    public void onBackPressed() {
        mPlayer.stop();
        finish();
        mHandler.removeCallbacks(mUpdateTimeTask);
    }
}
