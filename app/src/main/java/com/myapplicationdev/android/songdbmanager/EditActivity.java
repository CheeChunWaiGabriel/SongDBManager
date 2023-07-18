package com.myapplicationdev.android.songdbmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<song> songsList;
    ArrayAdapter<song> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        lv= findViewById(R.id.list_view);
        DBHelper db = new DBHelper(EditActivity.this);

        ArrayList<song> songs = db.getAllSongs();

        ArrayAdapter<song> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        lv.setAdapter(adapter);
    }
}