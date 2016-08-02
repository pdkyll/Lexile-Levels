package com.example.lexilelevels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Uploads extends AppCompatActivity {

    TextView dispBookLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);
        dispBookLevel = (TextView) findViewById(R.id.bookLevel);
        MyVocab.main();
        dispBookLevel.setText(Integer.toString(MyVocab.greatestLevel));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
