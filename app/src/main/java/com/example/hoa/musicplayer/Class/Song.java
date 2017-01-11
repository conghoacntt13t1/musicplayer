package com.example.hoa.musicplayer.Class;

/**
 * Created by hoa on 10/01/2017.
 */

public class Song {
    private long mSongID;
    private String mSongTitle;
    private String mSongArtist;

    public Song(long mSongID, String mSongTitle,String mSongArtist) {
        this.mSongID = mSongID;
        this.mSongTitle = mSongTitle;
        this.mSongArtist = mSongArtist;
    }

    public long getID() {
        return mSongID;
    }

    public void setID(long mSongID) {
        this.mSongID = mSongID;
    }

    public String getTitle() {
        return mSongTitle;
    }

    public String getArtist() {
        return mSongArtist;
    }

    public void setArtist(String mSongArtist) {
        this.mSongArtist = mSongArtist;
    }

    public void setTitle(String mSongTitle) {
        this.mSongTitle = mSongTitle;
    }

}
