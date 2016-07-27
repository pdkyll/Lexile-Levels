package com.example.lexilelevels;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class firstQuizPage extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    TextView question;
    ListView listview;
    ArrayAdapter adapter;
    Button submitAnswer;
    ArrayList<String> lst = new ArrayList<String>();
    String[] questions = {"What is the definition of hat?","Question 2","Question 3","Question 4","Question 5","Question 6","Question 7","Question 8",
            "Question 9","Question 10","Question 11"};
    String[][] values = { {"A piece of clothing worn on the head", "A stringy root", "A tree", "A feral cat found in South America"},
            {"q2a1" , "q2a2" , "q2a3" , "q2a4"},{"q3a1" , "q3a2" , "q3a3" , "q3a4"},{"q4a1" , "q4a2" , "q4a3" , "q4a4"},{"q5a1" , "q5a2" , "q5a3" , "q5a4"},
            {"q6a1" , "q6a2" , "q6a3" , "q6a4"},{"q7a1" , "q7a2" , "q7a3" , "q7a4"},{"q8a1" , "q8a2" , "q8a3" , "q8a4"},{"q9a1" , "q9a2" , "q9a3" , "q9a4"},
            {"q10a1" , "q10a2" , "q10a3" , "q10a4"},{"q10a1" , "q10a2" , "q10a3" , "q10a4"}};
    int[] correctAnswerIndices = {0,1,2,3,0,1,2,3,0,1,2};
    int totalNumberOfQuestions = values.length - 1;
    int questionNumber = -1;
    boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz_page);
        listview = (ListView) findViewById(R.id.choices);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lst);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        question = (TextView) findViewById(R.id.firstQuestion);
        question.setText("This is a quiz to determine your English proficiency so that we can recommend level-appropriate books to you. Please" +
                " press the 'Begin Quiz' button in order to answer the questions.");
        submitAnswer = (Button) findViewById(R.id.submit);
        submitAnswer.setText(R.string.beginQuiz);
        answered = false;
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long l) {
        if (!answered) {
            String colorHighlighted;
            if (position == correctAnswerIndices[questionNumber]) {
                colorHighlighted = "#" + Integer.toHexString(getColor(R.color.correctChoice));
            } else {
                colorHighlighted = "#" + Integer.toHexString(getColor(R.color.incorrectChoice));
            }
            view.setBackgroundColor(Color.parseColor(colorHighlighted));
            answered = true;
        }
    }

    @Override
    public void onClick(View view) {
        answered = false;
        question.setText("");
        lst.clear();
        submitAnswer.setText(R.string.nextQuestion);
        listview.setAdapter(adapter);
        if (questionNumber < totalNumberOfQuestions) {
            questionNumber += 1;
        } else {
            questionNumber = totalNumberOfQuestions;
        }
        question.setText(questions[questionNumber]);
        for (int i = 0; i < values[questionNumber].length; ++i) {
            lst.add(values[questionNumber][i]);
        }
    }
}
