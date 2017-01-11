package com.example.hoa.musicplayer.CustomListview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoa.musicplayer.Class.Song;
import com.example.hoa.musicplayer.R;

import java.util.ArrayList;

/**
 * Created by hoa on 11/01/2017.
 */

public class MusicAdapter extends BaseAdapter {
    private ArrayList<Song> listSong;
    private LayoutInflater layoutInflater;
    private Context context;

    public MusicAdapter(ArrayList<Song> listSong, Context context) {
        this.listSong = listSong;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (listSong.isEmpty()){
            return 0;
        }
        return listSong.size();
    }

    @Override
    public Object getItem(int position) {
        return listSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.custom_listview,null);
            viewHolder=new ViewHolder();
            viewHolder.tvTitle=(TextView)convertView.findViewById(R.id.tv_title);
            viewHolder.tvArtist=(TextView) convertView.findViewById(R.id.tv_artist);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Song song=listSong.get(position);
        viewHolder.tvTitle.setText(song.getTitle());
        viewHolder.tvArtist.setText(song.getArtist());
        viewHolder.imageView.setImageResource(R.drawable.music_icon);
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView tvTitle;
        TextView tvArtist;
    }
}
