package com.example.lexilelevels;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class activityLog extends AppCompatActivity {

    ListView scoreHistory;
    ArrayAdapter scoreAdapter;
    ArrayList<String> scores = new ArrayList<String>();
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_log);
        scores.clear();
        sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        putValues();
        scoreHistory = (ListView) findViewById(R.id.score_history);
        scoreAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,scores);
        scoreHistory.setAdapter(scoreAdapter);
    }

    private void putValues() {
        String savedScores = sharedpreferences.getString(MainActivity.allScores,"");
        String[] items = savedScores.split(",");
        for(int i=0; i < items.length; i++){
            scores.add(items[i]);
        }
    }
}
