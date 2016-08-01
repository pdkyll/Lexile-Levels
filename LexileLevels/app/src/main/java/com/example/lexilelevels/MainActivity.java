package com.example.lexilelevels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String allScores = "scoresKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Recommendations.level = 0;
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (!(sharedpreferences.contains("Level"))) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt("Level",0).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void beginQuiz(View recommendationButton) {
        Intent quiz1 = new Intent(this,firstQuizPage.class);
        startActivity(quiz1);
    }

    public void showMap(View mapButton) {
        Intent libraryMap = new Intent(this,MapButton.class);
        startActivity(libraryMap);
    }

    public void vocabLists(View vocabButton) {
        Intent vocabLists = new Intent(this,vocabularyLists.class);
        startActivity(vocabLists);
    }

    public void showActivityLog(View activityLogButton) {
        Intent activityLog = new Intent(this,activityLog.class);
        startActivity(activityLog);
    }

    public void viewRecommendations(View recButton) {
        Intent showRecs = new Intent(this,Recommendations.class);
        startActivity(showRecs);
    }
}
