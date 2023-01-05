package com.example.relatingdata;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TrackList extends ArrayAdapter<Track> {
    private Activity context;
     List<Track> trackList;

    public TrackList(Activity context, List<Track> trackList) {
        super(context, R.layout.tracklist_layout,trackList);
        this.context = context;
        this.trackList = trackList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.tracklist_layout,null,true);

        TextView tvName = view.findViewById(R.id.name_id);
        TextView tvrating = view.findViewById(R.id.rating_id);

        Track track = trackList.get(position);
        tvName.setText(track.getTrackName());
        tvrating.setText(String.valueOf(track.getTrackRating()));

        return view;
    }
}
