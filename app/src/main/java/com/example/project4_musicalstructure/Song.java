package com.example.project4_musicalstructure;

public class Song {

    /**
     * Artist Name
     */
    private String mArtistName;
    /**
     * Song Title
     */
    private String mSongTitle;
    /**
     * Image resource ID for the song
     */
    private int mImageResourceId;

    public Song(String artistName, String songTitle) {

        mArtistName = artistName;
        mSongTitle = songTitle;
    }

    /**
     * Create a new Song object.
     *
     * @param artistName      is the name of the artist that play the song
     * @param songTitle       is the name of the song played
     * @param imageResourceId is the drawable resource ID for the image associated with the song
     */
    public Song(String artistName, String songTitle, int imageResourceId) {
        mArtistName = artistName;
        mSongTitle = songTitle;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }


    /**
     * Get the song title.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
