package com.example.biologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReportStudent extends AppCompatActivity {


    private TextView textViewAnswer;
    private String text;

    String[] addresses = {""};
    String subject = "Звіт учня";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_student);

        setTitle("Ваша відповідь");


        Intent answerIntent = getIntent();
        text = answerIntent.getStringExtra("text");

        emailText =  "Відповідь: " + "\n" +
                text;

        textViewAnswer = findViewById(R.id.textViewAnswer);
        textViewAnswer.setText(emailText);
    }

    public void onClickStart4(View view) {
         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("*/*");
         intent.putExtra(Intent.EXTRA_STREAM, addresses);
         intent.putExtra(Intent.EXTRA_SUBJECT, subject);
         intent.putExtra(Intent.EXTRA_TEXT, emailText);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}