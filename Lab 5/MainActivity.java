package com.example.lab5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    private Counter hitCounter;
    private Counter createCounter;
    private Counter startCounter;
    private final String logTag = "com.example.lab5_1.APP_MAIN";
    private final String sharedPrefsCounterValues = "com.example.lab5_1.CounterValues";
    private final String hitCounterKey = "hitCounterValue";
    private final String createCounterKey = "createCounterValue";
    private final String startCounterKey = "startCounterValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(this.logTag, "onCreate");
        super.onCreate(savedInstanceState);

        this.sharedPrefs = getSharedPreferences(this.sharedPrefsCounterValues, Activity.MODE_PRIVATE);

        //Create all counters with stored values
        this.hitCounter = new Counter(-100, 100, this.sharedPrefs.getInt(this.hitCounterKey, 0), 1);
        this.createCounter = new Counter(-100, 100, this.sharedPrefs.getInt(this.createCounterKey, 0), 1);
        this.startCounter = new Counter(-100, 100, this.sharedPrefs.getInt(this.startCounterKey, 0), 1);
        //add one Creation to creationCounter
        this.createCounter.add();

        setContentView(R.layout.activity_main);
        //Update all UI elements
        this.updateUI();
    }

    @Override
    protected void onStart() {
        Log.d(this.logTag, "onStart");
        this.startCounter.add();
        this.updateUI();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(this.logTag, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(this.logTag, "onPause");
        //Save all counters values to SharedPreferences
        SharedPreferences.Editor prefEditor = this.sharedPrefs.edit();
        prefEditor.putInt(this.hitCounterKey, this.hitCounter.getValue());
        prefEditor.putInt(this.startCounterKey, this.startCounter.getValue());
        prefEditor.putInt(this.createCounterKey, this.createCounter.getValue());
        prefEditor.commit();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(this.logTag, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(this.logTag, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(this.logTag, "onDestroy");
        super.onDestroy();
    }

    public void buttonPressed(View view) {
        //Get widgets view id
        switch (view.getId()) {
            // Buttons id:
            case R.id.buttonReset:
                this.hitCounter.reset();
                this.createCounter.reset();
                this.startCounter.reset();
                break;
            case R.id.buttonHit:
                this.hitCounter.add();
                break;
            default:
                break;
        }
        updateUI();
    }
    //Update UI elements in activity
    public void updateUI() {
        TextView textView;
        textView = findViewById(R.id.textViewStart);
        textView.setText(getString(R.string.textViewStart) + " \n\n" + this.startCounter.toString());
        textView = findViewById(R.id.textViewCreate);
        textView.setText(getString(R.string.textViewCreate) + " \n\n" + this.createCounter.toString());
        textView = findViewById(R.id.textViewHit);
        textView.setText(getString(R.string.textViewHit) + " \n\n" + this.hitCounter.toString());
    }
}