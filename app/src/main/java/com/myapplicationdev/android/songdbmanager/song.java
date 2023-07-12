package com.myapplicationdev.android.songdbmanager;

import androidx.annotation.NonNull;

public class song {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public song (int id,
    String title,
    String singers,
    int year,
    int stars
    ){
        this.id=id;
        this.title=title;
        this.singers=singers;
        this.year=year;
        this.stars=stars;
    }
    public String getTitle() {
        return title;
    }
    public int getId(){
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public String getSingers() {
        return singers;
    }

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + title+"\n"+year + "\n" + stars + "\n" + singers;
    }

}


