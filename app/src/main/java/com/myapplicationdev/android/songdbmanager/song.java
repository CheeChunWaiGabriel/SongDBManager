package com.myapplicationdev.android.songdbmanager;

import androidx.annotation.NonNull;

public class song {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;



    public song (
                 String title,
                 String singers,
                 int year,
                 int stars
    ){
        this.title=title;
        this.singers=singers;
        this.year=year;
        this.stars=stars;
    }
    public song (
            int id,
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

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singers='" + singers + '\'' +
                ", year=" + year +
                ", stars=" + stars +
                '}';
    }
}


