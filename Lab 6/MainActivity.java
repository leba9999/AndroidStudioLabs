package com.example.lab6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "com.example.lab6_1.APP_MAIN";
    public static final String EXTRA = "com.example.lab6_1.PRESIDENT_POSITION";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewPresidents);
        listView.setAdapter(new ArrayAdapter<President>(this, android.R.layout.simple_list_item_1, GlobalModel.getInstance().getPresidents()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick(" + position + ")");
                Intent nextActivity = new Intent(MainActivity.this, PresidentDetailsActivity.class);
                nextActivity.putExtra(EXTRA, position);
                startActivity(nextActivity);
            }
        });
    }
}