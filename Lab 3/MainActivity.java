package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupValues;
    private Counter counter;
    private TextView textViewCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = new Counter(-10, 255, 0, 5);
        textViewCounter = findViewById(R.id.textViewCounter);
        radioGroupValues = findViewById(R.id.radioGroupValues);
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
            case R.id.imageButtonReset:
                counter.reset();
                break;
            default:
                counter.reset();
                break;
        }
        //Small Log
        Log.i("APP_MAIN", "Button " + view.getId() + " pressed and counter value is " + counter.getValue());
        //UpdateUI elements
        updateUI();
    }
    public void radioButtonPressed(View view) {
        //Small Log
        Log.i("APP_MAIN", "RadioButton " + view.getId() + " pressed  and counter value is " + counter.getValue());
        //UpdateUI elements
        updateUI();
    }

    public void updateUI() {
        switch (radioGroupValues.getCheckedRadioButtonId()) {
            // Radio button id:
            case R.id.radioButtonDEC:
                textViewCounter.setText(counter.toString());
                break;
            case R.id.radioButtonBIN:
                textViewCounter.setText(counter.toBinaryString());
                break;
            case R.id.radioButtonHEX:
                textViewCounter.setText(counter.toHexString());
                break;
            default:
                textViewCounter.setText(counter.toString());
                break;
        }
    }
}