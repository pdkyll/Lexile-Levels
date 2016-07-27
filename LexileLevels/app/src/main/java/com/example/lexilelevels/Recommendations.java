package com.example.lexilelevels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Recommendations extends AppCompatActivity {

    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        results = (TextView) findViewById(R.id.displayResults);
        results.setText("Results: " + Integer.toString(firstQuizPage.numberCorrect));
        firstQuizPage.numberCorrect = 0;
    }
}
