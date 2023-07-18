package com.myapplicationdev.android.songdbmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetSongs;
    TextView tvResults;

    EditText YearInput;
    EditText SongInput;
    EditText SingerInput;
    RadioGroup RadioGroupRating;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetSongs = findViewById(R.id.btnGetTasks);
        //List View->
        YearInput=findViewById(R.id.insertYear);
        SongInput=findViewById(R.id.insertTitle);
        SingerInput=findViewById(R.id.insertSingers);
        RadioGroupRating=findViewById(R.id.radio_group);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String title=SongInput.getText().toString();
                String singers=SingerInput.getText().toString();
                int year=Integer.parseInt(YearInput.getText().toString());

                int selectedRatingId=RadioGroupRating.getCheckedRadioButtonId();
                RadioButton selectedRatingButton=findViewById(selectedRatingId);
                int rating=Integer.parseInt(selectedRatingButton.getText().toString());
                db.insertSong(title,singers,year,rating);

                SongInput.setText("");
                SingerInput.setText("");
                YearInput.setText("");
                RadioGroupRating.clearCheck();
            }
        });

        btnGetSongs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context

                // Insert a task
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                //Label the actual editactivity EditActivity2
                startActivity(intent);


            }
        });
    }



}




