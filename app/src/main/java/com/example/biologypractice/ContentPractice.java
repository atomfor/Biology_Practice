package com.example.biologypractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContentPractice extends AppCompatActivity {

    private ListView recyclerView;
    private ArrayList<Work> works;

    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_practice);
        recyclerView = findViewById(R.id.recyclerview);
        setTitle("Зміст");


        works = new ArrayList<>();
        works.add(new Work(getString(R.string.work_one_title), getString(R.string.work_one_them)));
        works.add(new Work(getString(R.string.work_two_title), getString(R.string.work_two_them)));
        works.add(new Work(getString(R.string.work_three_title), getString(R.string.work_three_them)));
        works.add(new Work(getString(R.string.work_for_title), getString(R.string.work_two_them)));

        ArrayAdapter<Work> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.my_list_item, works);
        recyclerView.setAdapter(adapter);
    }

    public void onClickStart2(View view) {
        Intent NextIntent = new Intent(this, WorkNumberOne.class);
        startActivity(NextIntent);
    }
}