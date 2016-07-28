package com.example.lexilelevels;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Recommendations extends AppCompatActivity {

    TextView results;
    ArrayList<String> recsLevelBooks = new ArrayList<String>();
    String[][] booksLevel0 = {
            {"The Hungry, Hungry Caterpillar","Eric Carle"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel1 = {
            {"The Cat in the Hat","Dr. Seuss"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel2 = {
            {"The Giving Tree","Shel Silverstein"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel3 = {
            {"Charlotte's Web","E. B. White"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel4 = {
            {"The Tale of Desperaux","Kate DiCamillo"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel5 = {
            {"The Graveyard Book","Neil Gaiman"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel6 = {
            {"The Giver","Lois Lowry"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel7 = {
            {"And Then There Were None","Agatha Christie"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel8 = {
            {"Heart of Darkness","Joseph Conrad"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel9 = {
            {"The Great Gatsby","F. Scott Fitzgerald"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel10 = {
            {"Frankenstein","Mary Shelley"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][] booksLevel11 = {
            {"Masque of the Red Death","Edgar Allen Poe"},
            {"Book 2","Author 2"},
            {"Book 3","Author 3"},
            {"Book 4","Author 4"},
            {"Book 5","Author 5"}
    };
    String[][][] allBooks = {booksLevel0,booksLevel1,booksLevel2,booksLevel3,booksLevel4,booksLevel5,booksLevel6,booksLevel7,booksLevel8,booksLevel9,booksLevel10,booksLevel11};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        results = (TextView) findViewById(R.id.displayResults);
        results.setText("Results: " + Integer.toString(firstQuizPage.numberCorrect) + " / " + Integer.toString(firstQuizPage.numberOfWords) + "\n \nPlacement: Level " + Integer.toString(firstQuizPage.numberCorrect));
        recs();
        firstQuizPage.numberCorrect = 0;
    }
    public void recs(){
        int level = firstQuizPage.numberCorrect;
        // in the middle of adding to recommendations
    }
}
