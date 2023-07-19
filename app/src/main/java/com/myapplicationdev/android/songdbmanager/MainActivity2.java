package com.myapplicationdev.android.songdbmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnUpdate,btnCancel,btnDelete;
    EditText YearInput;
    EditText SongInput;
    EditText SingerInput;
    RadioGroup RadioGroupRating;

    song selectedSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DBHelper db = new DBHelper(MainActivity2.this);
        Intent intent = getIntent();
        song clickedSong = intent.getParcelableExtra("song");
        btnUpdate=findViewById(R.id.btnupdate);
        btnCancel=findViewById(R.id.btnCancel);
        btnDelete=findViewById(R.id.btndelete);
        YearInput=findViewById(R.id.insertYear);
        SongInput=findViewById(R.id.insertTitle);
        SingerInput=findViewById(R.id.insertSingers);

        RadioGroupRating=findViewById(R.id.radio_group);

        selectedSong = clickedSong;
        YearInput.setText(clickedSong.getYear());
        SongInput.setText(clickedSong.getTitle());
        SingerInput.setText(clickedSong.getSingers());
        setStarsSelection(selectedSong.getStars());


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedSong.setTitle(SongInput.getText().toString());
                selectedSong.setSingers(SingerInput.getText().toString());
                selectedSong.setYear(Integer.parseInt(YearInput.getText().toString()));
                selectedSong.setStars(getSelectedStars());
                db.updateSong(selectedSong);
                db.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteSong(selectedSong.getId());
                db.close();
                finish();
            }
        });


}

    private int getSelectedStars() {
        int selectedId = RadioGroupRating.getCheckedRadioButtonId();
        RadioButton rbSelected = findViewById(selectedId);
        return Integer.parseInt(rbSelected.getText().toString());
    }
    private void setStarsSelection(int stars) {
        int radioButtonId = 0;
        switch (stars) {
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
        RadioGroupRating.check(radioButtonId);
    }


    }