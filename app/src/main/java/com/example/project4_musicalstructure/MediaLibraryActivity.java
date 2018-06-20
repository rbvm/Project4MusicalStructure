package com.example.project4_musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MediaLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);


        //Find the view that shows the list of songs
        final ListView listView = (ListView) findViewById(R.id.list);

        //Set a onItemClickListener on that view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Intent nowPlayingActivity = new Intent(MediaLibraryActivity.this, NowPlayingActivity.class);

                nowPlayingActivity.putExtra("Artist Name", song.getArtistName());
                nowPlayingActivity.putExtra("Song Title", song.getSongTitle());
                startActivity(nowPlayingActivity);
            }
        });

        TextView backToMain = (TextView) findViewById(R.id.back_to_main);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(MediaLibraryActivity.this, MainActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(backIntent);
            }

        });

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Ludwig van Beethoven", "Moonlight Sonata", R.drawable.music_icon));
        songs.add(new Song("Ludwig van Beethoven", "Symphony No. 5", R.drawable.music_icon));
        songs.add(new Song("Johann Pachelbel", "Canon In D Major", R.drawable.music_icon));
        songs.add(new Song("Ludwig van Beethoven", "Ode To Joy", R.drawable.music_icon));
        songs.add(new Song("Antonio Vivaldi", "The Four Seasons", R.drawable.music_icon));
        songs.add(new Song("Edvard Grieg", "In the Hall of the Mountain King", R.drawable.music_icon));
        songs.add(new Song("Johann Sebastian Bach", "Toccata and Fugue In D Minor", R.drawable.music_icon));
        songs.add(new Song("Wolfgang Amadeus Mozart", "Eine kleine Nachtmusik K525", R.drawable.music_icon));
        songs.add(new Song("Georg Friedrich Händel", "Hallelujah Chorus", R.drawable.music_icon));
        songs.add(new Song("Wolfgang Amadeus Mozart", "Requiem", R.drawable.music_icon));

        // Create an adapter for displaying the list of songs from the list of songs
        SongAdapter adapter = new SongAdapter(this, songs);
        listView.setAdapter(adapter);

    }
}

