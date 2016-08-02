package com.example.lexilelevels;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class vocabularyLists extends AppCompatActivity{

    TextView responseView;
    ListView vocabList;
    ArrayAdapter vocabAdapter;
    ArrayList<String> vocabListDisp = new ArrayList<String>();
    SharedPreferences vocabListSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_lists);
        vocabListDisp.clear();
        vocabListSharedPreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        responseView = (TextView) findViewById(R.id.resultsView);
        vocabList = (ListView) findViewById(R.id.vocab_list);
        createVocabListDisp();
        vocabAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,vocabListDisp);
        vocabList.setAdapter(vocabAdapter);
    }

    private void createVocabListDisp() {
        int vocabLevel = vocabListSharedPreferences.getInt("Level",-1);
        for (int i = 0; i < firstQuizPage.allLists[vocabLevel-1].length; i++) {
            vocabListDisp.add(firstQuizPage.allLists[vocabLevel-1][i][0] + ": " + firstQuizPage.allLists[vocabLevel-1][i][1].toLowerCase());
        }
    }

}

