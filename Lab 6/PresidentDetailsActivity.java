package com.example.lab6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PresidentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_details);
        Bundle b = getIntent().getExtras();
        int i = b.getInt(MainActivity.EXTRA, 0);

        ((TextView)findViewById(R.id.textViewName)).setText(GlobalModel.getInstance().getPresident(i).getName());
        ((TextView)findViewById(R.id.textViewDescripion)).setText(GlobalModel.getInstance().getPresident(i).getDescription());
        ((TextView)findViewById(R.id.textViewStartYear)).setText(Integer.toString(GlobalModel.getInstance().getPresident(i).getStartYear()));
        ((TextView)findViewById(R.id.textViewEndYear)).setText(Integer.toString(GlobalModel.getInstance().getPresident(i).getEndYear()));

    }
}