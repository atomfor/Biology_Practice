package com.example.biologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class WorkNumberOne extends AppCompatActivity {

    private EditText editTextMultiLine;
    private TextView textView;

    private String wordText = "https://docs.google.com/document/d/1CW3fG4ZYfuCgXT_n7KSv4Zf3MBsKz4nT/preview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_number_one);
        textView = findViewById(R.id.textView2);
        editTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        DownloadTask task = new DownloadTask();
        try {
            String result = task.execute(wordText).get();
            textView.setText(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setTitle("Практична робота №1");
    }

    private static class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings [0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result.toString();
        }
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