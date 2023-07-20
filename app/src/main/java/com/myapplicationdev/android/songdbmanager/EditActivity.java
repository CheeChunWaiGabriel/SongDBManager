package com.myapplicationdev.android.songdbmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<song> songsList;
    ArrayAdapter<song> adapter;
    Button fivestarsongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        lv= findViewById(R.id.list_view);
        fivestarsongs=findViewById(R.id.btnShow5starsongs);
        DBHelper db = new DBHelper(EditActivity.this);

        ArrayList<song> songs = db.getAllSongs();

        ArrayAdapter<song> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        lv.setAdapter(adapter);
        fivestarsongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<song> BestSongs = db.getBestSongs();
                adapter.clear();
                adapter.addAll(BestSongs);
                adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                song ClickedSong = songs.get(position);
                Intent i = new Intent(EditActivity.this,
                        MainActivity2.class);
                i.putExtra("song", ClickedSong);
                startActivity(i);
            }
        });
    }

}