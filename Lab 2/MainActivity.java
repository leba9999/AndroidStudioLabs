package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Counter counter;
    private TextView textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = new Counter(-14, 14, 0, 7);
        textViewCounter = findViewById(R.id.textViewCounter);
        updateUI();
    }

    public void buttonPressed(View view) {
        switch (view.getId()) {
            // Buttons id:
            case R.id.buttonAdd:
                counter.add();
                break;
            case R.id.buttonSubtract:
                counter.subtract();
                break;
            case R.id.buttonReset:
                counter.reset();
                break;
            default:
                counter.reset();
                break;
        }
        //Small Log
        Log.i("APP_MAIN", "Button pressed and value is " + counter.getValue());
        //UpdateUI elements
        updateUI();
    }

    public void updateUI() {
        //Update textViewCounter text field to new counter value
        textViewCounter.setText(Integer.toString(counter.getValue()));
    }
}
