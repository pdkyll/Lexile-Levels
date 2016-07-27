package com.example.lexilelevels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    public void recs(){
        if(firstQuizPage.numberCorrect == 0){
            Log.d("Book Title","Hungry Hungry Caterpillar by Eric Carle");
        }
        if(firstQuizPage.numberCorrect == 1){
            Log.d("Book Title","Cat in the Hat by Dr. Seuss");
        }
        if(firstQuizPage.numberCorrect == 2){
            Log.d("Book Title","The Giving Tree by Shel Silverstein");
        }
        if(firstQuizPage.numberCorrect == 3){
            Log.d("Book Title","Charlotte's Web by E.B. White");
        }
        if(firstQuizPage.numberCorrect == 4){
            Log.d("Book Title","The Tale of Desperaux by Kate DiCamillo");
        }
        if(firstQuizPage.numberCorrect == 5){
            Log.d("Book Title","The Graveyard Book by Neil Gaiman");
        }
        if(firstQuizPage.numberCorrect == 6){
            Log.d("Book Title","The Giver by Lois Lowery");
        }
        if(firstQuizPage.numberCorrect == 7){
            Log.d("Book Title","And Then There Were None by Agatha Christie");
        }
        if(firstQuizPage.numberCorrect == 8){
            Log.d("Book Title","Heart of Darkness by Joseph Conrad");
        }
        if(firstQuizPage.numberCorrect == 9){
            Log.d("Book Title","The Great Gatsby by F.Scott Fitzgerald");
        }
        if(firstQuizPage.numberCorrect == 10){
            Log.d("Book Title","Frankenstein by Mary Shelley");
        }
        if(firstQuizPage.numberCorrect == 11){
            Log.d("Book Title","The Fall of the House of Usher by Edgar Allan Poe");
        }
    }
}
