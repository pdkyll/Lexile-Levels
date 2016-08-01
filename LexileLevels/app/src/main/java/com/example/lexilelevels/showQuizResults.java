package com.example.lexilelevels;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class showQuizResults extends AppCompatActivity {

    TextView results;
    TextView resultsDescription;
    ListView wordsWrongView;
    ArrayAdapter wordsWrongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quiz_results);
        int level = firstQuizPage.numberCorrect;
        String resultsDisplay = "Results: " + Integer.toString(level) + " / " + Integer.toString(firstQuizPage.numberOfWords) + "\n \nPlacement: Level " + Integer.toString(level);
        String description = "You got " + Integer.toString(firstQuizPage.wordsWrong.size()) + " questions wrong. The following list includes any words you may have missed.";
        results = (TextView) findViewById(R.id.displayResults);
        results.setText(resultsDisplay);
        resultsDescription = (TextView) findViewById(R.id.description);
        resultsDescription.setText(description);
        wordsWrongView = (ListView) findViewById(R.id.wordsWrong);
        wordsWrongAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,firstQuizPage.wordsWrong);
        wordsWrongView.setAdapter(wordsWrongAdapter);
    }
}
