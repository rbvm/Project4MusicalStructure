package com.example.project4_musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView artistName = (TextView) listItemView.findViewById(R.id.current_artist_name);
        // Get the version name from the current song object and
        // set this text on the name TextView
        artistName.setText(currentSong.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView songTitle = (TextView) listItemView.findViewById(R.id.current_song_title);
        // Get the version number from the current son object and
        // set this text on the number TextView
        songTitle.setText(currentSong.getSongTitle());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon);
        // Set the ImageView to the image resource specified in the current Song
        imageView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing two TextViews and one ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
