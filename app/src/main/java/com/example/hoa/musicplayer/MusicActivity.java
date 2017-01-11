package com.example.hoa.musicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hoa.musicplayer.Class.Song;
import com.example.hoa.musicplayer.CustomListview.MusicAdapter;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity {

    private List<Song> listSong;
    private ListView lvMusic;
    private MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        getListSong();
        references();

    }

    private void references() {
        lvMusic = (ListView) findViewById(R.id.lv_music);
        musicAdapter = new MusicAdapter(listSong,MusicActivity.this);
        lvMusic.setAdapter(musicAdapter);
    }

    private void getListSong(){
        listSong =new ArrayList<>();
        ContentResolver contentResolver=getContentResolver();
        Uri songUri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor =contentResolver.query(songUri,null,null,null,null);

        if (songCursor!=null && songCursor.moveToFirst()){
            int songId=songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int songTitle=songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist=songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

            do {
                long currentId=songCursor.getLong(songId);
                String currentTitle=songCursor.getString(songTitle);
                String currentArtist = songCursor.getString(songArtist);
                listSong.add(new Song(currentId,currentTitle,currentArtist));
            }while (songCursor.moveToNext());
        }
    }
}
