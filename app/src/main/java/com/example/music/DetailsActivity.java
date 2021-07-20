package com.example.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;


public class DetailsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle b = this.getIntent().getExtras();
        ArrayList<Music> musics = b.getParcelableArrayList("musics");
        int index = b.getInt("index");

        getSupportActionBar().setTitle(musics.get(index).getSongArtist());

        TextView songTitle = findViewById(R.id.detail_song_title);
        songTitle.setText(musics.get(index).getSongTitle());

        TextView songArtist = findViewById(R.id.detail_song_artist);
        songArtist.setText(musics.get(index).getSongArtist());

        TextView songLyrics = findViewById(R.id.detail_song_lyrics);
        songLyrics.setText(musics.get(index).getSongLyrics());

        Button start = findViewById(R.id.start_btn);
        Button pause = findViewById(R.id.pause_btn);
        Button stop = findViewById(R.id.stop_btn);
        mediaPlayer = MediaPlayer.create(DetailsActivity.this, musics.get(index).getSongId());

        start.setOnClickListener((v) -> {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Playing song", Toast.LENGTH_SHORT).show();
            }
        });
        pause.setOnClickListener((v) -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                Toast.makeText(getApplicationContext(), "Pausing song", Toast.LENGTH_SHORT).show();
            }
        });
        stop.setOnClickListener((v) -> {
            stopPlaying();
        });
    }

    private void stopPlaying() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            Toast.makeText(getApplicationContext(), "Stopping song", Toast.LENGTH_SHORT).show();
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


}