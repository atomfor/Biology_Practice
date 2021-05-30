package com.example.biologypractice;

import androidx.annotation.NonNull;

public class Work {
    private String title;
    private String theam;


    public Work(String title, String theam) {
        this.title = title;
        this.theam = theam;

    }

    public String getTitle() {
        return title;
    }

    public String getTheam() {
        return theam;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
