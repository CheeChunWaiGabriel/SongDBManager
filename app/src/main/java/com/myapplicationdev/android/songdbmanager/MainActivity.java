package com.myapplicationdev.android.songdbmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetSongs;
    TextView tvResults;
    ListView lv;
    ArrayList<song> al;
    ArrayAdapter<song> adapter;
    EditText YearInput;
    EditText SongInput;
    EditText SingerInput;

    ToggleButton SortBy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetSongs = findViewById(R.id.btnGetTasks);
        //List View->
        lv=findViewById(R.id.list_view);
        YearInput=findViewById(R.id.insertYear);
        SongInput=findViewById(R.id.insertTitle);
        SingerInput=findViewById(R.id.insertSingers);

        al = new ArrayList<>();
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertSong(SongInput.getText().toString(), SingerInput.getText().toString(), YearInput.getText().toString());

            }
        });
        btnGetSongs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                String sortOrder;
                if(SortBy.isChecked()) {
                    sortOrder="ASC";
                }
                else{
                    sortOrder="DESC";
                }

                // Insert a task
                ArrayList<song> data = db.getTasks(sortOrder);
                al.addAll(data);
                adapter.notifyDataSetChanged();
                db.close();

                String txt = "";
                for (int i = 0; i < al.size(); i++) {
                    song Song=al.get(i);
                    Log.d("Database Content", i +". "+song.+"\n");
                    txt += al.get(i).getTitle();
                    txt += al.get(i).getSingers();
                    txt += al.get(i).getStars();

                }
                tvResults.setText(txt);
            }
        });
    }

}




