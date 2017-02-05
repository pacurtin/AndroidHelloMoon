package com.example.padraigcurtin.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by padraig.curtin on 05/02/2017.
 */

public class AudioPlayer extends Object {
    private MediaPlayer mPlayer;
    private int length = 0;
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
            length=mPlayer.getCurrentPosition();
        }
    }
    public void play(Context c) {
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
                length=0;
            }
        });

        mPlayer.start();
        mPlayer.seekTo(length);
    }

}
