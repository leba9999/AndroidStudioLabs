package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String name_message = intent.getStringExtra(MainActivity.EXTRA_NAME_MESSAGE);
        String age_message = intent.getStringExtra(MainActivity.EXTRA_AGE_MESSAGE);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello " + name_message + ", you are " + age_message + " year old");
    }
}