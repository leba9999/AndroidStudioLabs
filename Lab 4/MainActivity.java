package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Intent extra keys
    public static final String EXTRA_AGE_MESSAGE = "com.example.lab4_1.AGE_MESSAGE";
    public static final String EXTRA_NAME_MESSAGE = "com.example.lab4_1.NAME_MESSAGE ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Start DisplayMessageActivity when button send pressed
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextName);
        intent.putExtra(EXTRA_NAME_MESSAGE, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextAge);
        intent.putExtra(EXTRA_AGE_MESSAGE, editText.getText().toString());

        startActivity(intent);
    }
}