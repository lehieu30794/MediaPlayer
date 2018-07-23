package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);



        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();

//                No need a class name here because only use once
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "Done Playing", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });



        Button playPause = (Button) findViewById(R.id.pause_button);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.pause();

            }
        });
    }

}
