package com.example.project4_musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    TextView nowPlayingArtist;
    TextView nowPlayingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Intent i = getIntent();
        if (i == null)
            return;

        nowPlayingArtist = findViewById(R.id.current_artist_name);
        nowPlayingSong = findViewById(R.id.current_song_title);
        nowPlayingArtist.setText(i.getStringExtra("Artist Name"));
        nowPlayingSong.setText(i.getStringExtra("Song Title"));


        TextView backToMain = (TextView) findViewById(R.id.back_to_main);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(backIntent);
            }

        });
        TextView backToMedia = (TextView) findViewById(R.id.back_to_media);
        backToMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(NowPlayingActivity.this, MediaLibraryActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(backIntent);
            }
        });

    }
}
