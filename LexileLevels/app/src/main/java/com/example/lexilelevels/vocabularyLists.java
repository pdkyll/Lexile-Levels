package com.example.lexilelevels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class vocabularyLists extends AppCompatActivity{

    TextView responseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_lists);
        responseView = (TextView) findViewById(R.id.resultsView);
    }

}

