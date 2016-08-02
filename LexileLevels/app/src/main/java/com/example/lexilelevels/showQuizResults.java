package com.example.lexilelevels;

import android.content.Context;
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
    SharedPreferences quizResultsSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quiz_results);
        quizResultsSharedPreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        int level = firstQuizPage.numberCorrect;
        determineNewLevel();
        String resultsDisplay = "Results: " + Integer.toString(level) + " / " + Integer.toString(firstQuizPage.numberOfWords) + "\n \nPlacement: Level " + Integer.toString(quizResultsSharedPreferences.getInt("Level",-1));
        String description = "You got " + Integer.toString(firstQuizPage.wordsWrong.size()) + " questions wrong. The following list includes any words you may have missed.";
        results = (TextView) findViewById(R.id.displayResults);
        results.setText(resultsDisplay);
        resultsDescription = (TextView) findViewById(R.id.description);
        resultsDescription.setText(description);
        wordsWrongView = (ListView) findViewById(R.id.wordsWrong);
        wordsWrongAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,firstQuizPage.wordsWrong);
        wordsWrongView.setAdapter(wordsWrongAdapter);
    }

    private void determineNewLevel() {
        int newLevel;
        SharedPreferences.Editor editor = quizResultsSharedPreferences.edit();
        if (quizResultsSharedPreferences.getString("takenDiagnostic","")=="false") {
            newLevel = firstQuizPage.numberCorrect;
            editor.putString("takenDiagnostic","false").commit();
        } else {
            int oldLevel = quizResultsSharedPreferences.getInt("Level", -1);
            if (firstQuizPage.numberCorrect >= firstQuizPage.numberOfWords / 2) {
                newLevel = oldLevel + 1;
            } else {
                newLevel = oldLevel;
            }
        }
            editor.putInt("Level", newLevel);
            editor.commit();
            firstQuizPage.numberCorrect = 0;
    }

}
