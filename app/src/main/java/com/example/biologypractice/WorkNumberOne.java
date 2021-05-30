package com.example.biologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WorkNumberOne extends AppCompatActivity {

    private EditText editTextMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_number_one);
        editTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        setTitle("Практична робота №1");
    }

    public void onClickStart3(View view) {
        String text = editTextMultiLine.getText().toString().trim();
        if (!text.isEmpty()) {
            Intent answerIntent = new Intent(this, ReportStudent.class);
            answerIntent.putExtra("text", text);
            startActivity(answerIntent);
        } else {
            Toast.makeText(this, R.string.toast_password, Toast.LENGTH_SHORT).show();
        }
    }
}