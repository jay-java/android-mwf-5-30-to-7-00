package com.example.relatingdata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {

    private Activity context;
    private List<Artist> artistList;

    public ArtistList(Activity context, List<Artist> artistList) {
        super(context, R.layout.list_layout,artistList);
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_layout,null,true);
        TextView tvName = view.findViewById(R.id.name_id);
        TextView tvGenre = view.findViewById(R.id.genre_id);
        Artist artist = artistList.get(position);
        tvName.setText(artist.getName());
        tvGenre.setText(artist.getArtistGenre());
        return view;
    }
}

