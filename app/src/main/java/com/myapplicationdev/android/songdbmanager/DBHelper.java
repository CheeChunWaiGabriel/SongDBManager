package com.myapplicationdev.android.songdbmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final String COLUMN_YEAR="year";
    private static final String COLUMN_STARS="stars";
    // Filename of the database
    private static final String DATABASE_NAME = "songs.db";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dropTableSql = "DROP TABLE IF EXISTS " + TABLE_SONG;
        db.execSQL(dropTableSql);
        String createTableSql = "CREATE TABLE " + TABLE_SONG +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_SINGERS+ " TEXT ,"
                + COLUMN_YEAR + " INTEGER ,"
                + COLUMN_STARS+ " INTEGER )";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SONG);
        // Create table(s) again
        onCreate(db);


    }
    public void insertSong(String title, String singers, int year, int stars){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGERS, singers);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_STARS, stars);

        // Store the column name as key and the date as value

        // Insert the row into the TABLE_TASK
       db.insert(TABLE_SONG, null, values);
        // Close the database connection
        db.close();
    }
    public ArrayList<song> getAllSongs() {
        ArrayList<song> songlist = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS,COLUMN_YEAR,COLUMN_STARS};

        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title=cursor.getString(1);
                String singers = cursor.getString(2);
                int year=cursor.getInt(3);
                int stars=cursor.getInt(4);
                song Song = new song(id,title,singers,year,stars);
                songlist.add(Song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songlist;
    }
    public ArrayList<song> getBestSongs() {
        ArrayList<song> bestsonglist = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS,COLUMN_YEAR,COLUMN_STARS};
        String condition = COLUMN_STARS + "= ?";
        String[] args = {"5"};
        Cursor cursor = db.query(TABLE_SONG, columns, condition, args,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title=cursor.getString(1);
                String singers = cursor.getString(2);
                int year=cursor.getInt(3);
                int stars=cursor.getInt(4);
                song Song = new song(id,title,singers,year,stars);
                bestsonglist.add(Song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bestsonglist;
    }
    public int updateSong(song Song) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, Song.getTitle());
        values.put(COLUMN_SINGERS, Song.getSingers());
        values.put(COLUMN_YEAR, Song.getYear());
        values.put(COLUMN_STARS, Song.getStars());
        String whereClause = COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(Song.getId())};
        int result=db.update(TABLE_SONG, values, whereClause, whereArgs);

        if (result < 1) {
            Log.d("DBHelper", "Update failed");

            db.close();
            return result;
        }


        return result;
    }
    public void deleteSong(int songId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = COLUMN_ID + "=?";
        String[] whereArgs = {String.valueOf(songId)};
       db.delete(TABLE_SONG, whereClause, whereArgs);
       db.close();
    }}



