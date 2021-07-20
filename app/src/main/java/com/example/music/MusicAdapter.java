package com.example.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    public MusicAdapter(Context context, ArrayList<Music> musics) {
        super(context, 0, musics);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Music currentMusic = getItem(position);

        TextView songTitle = listItemView.findViewById(R.id.song_title);
        songTitle.setText(currentMusic.getSongTitle());


        TextView songArtist =listItemView.findViewById(R.id.artist_name);
        songArtist.setText(currentMusic.getSongArtist());

        TextView songDuration= listItemView.findViewById(R.id.song_duration);
        songDuration.setText(currentMusic.getSongDuration());

        ImageView songImage=listItemView.findViewById(R.id.song_img);
        songImage.setImageResource(currentMusic.getSongImg());
        return listItemView;
    }
}
