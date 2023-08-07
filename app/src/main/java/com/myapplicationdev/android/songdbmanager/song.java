package com.myapplicationdev.android.songdbmanager;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;


    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

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


    @NonNull
    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", singers='" + singers + '\'' +
                ", year=" + year +
                ", stars=" + stars
               ;
    }
}


