package com.example.biologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.biologypractice.R.string.toast_password;

public class MainActivity extends AppCompatActivity {

    EditText editTextPersonName;
    EditText editTextNumberPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword);

        setTitle("Практичні роботи");

    }

    public void onClickStart(View view) {
        String name = editTextPersonName.getText().toString();
        String password = editTextNumberPassword.getText().toString().trim();
        if (!name.isEmpty() && !password.isEmpty()) {
            Intent nameIntent = new Intent(this, ContentPractice.class);
            nameIntent.putExtra("name", name);
            startActivity(nameIntent);
        } else {
            Toast.makeText(this, toast_password, Toast.LENGTH_SHORT).show();
        }
    }
}