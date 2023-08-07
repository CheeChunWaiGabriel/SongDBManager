package com.myapplicationdev.android.songdbmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<song> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.songList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(layoutResourceId, parent, false);
        }

        song currentSong = songList.get(position);

        TextView yearInput = rowView.findViewById(R.id.textViewVYear);
        TextView singerInput = rowView.findViewById(R.id.textViewSingers);
        TextView titleInput = rowView.findViewById(R.id.textViewTitle);
        RadioGroup radioGroupRating =rowView.findViewById(R.id.radiogroup);

        titleInput.setText(currentSong.getTitle());
        singerInput.setText(currentSong.getSingers());
        yearInput.setText(String.valueOf(currentSong.getYear()));

        int selectedValue = currentSong.getStars();
        int radioButtonId = 0;
        switch (selectedValue) {
            case 1:
                radioButtonId = R.id.radio_1;
                break;
            case 2:
                radioButtonId = R.id.radio_2;
                break;
            case 3:
                radioButtonId = R.id.radio_3;
                break;
            case 4:
                radioButtonId = R.id.radio_4;
                break;
            case 5:
                radioButtonId = R.id.radio_5;
                break;
        }
        radioGroupRating.check(radioButtonId);

        return rowView;


}}
