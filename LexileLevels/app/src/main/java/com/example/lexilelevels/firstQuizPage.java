package com.example.lexilelevels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class firstQuizPage extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    private static Random ran = new Random();
    TextView question;
    TextView progress;
    ListView listview;
    ArrayAdapter adapter;
    Button submitAnswer;
    ArrayList<String> lst = new ArrayList<String>();
    static String[][] level1 = {{"aware", "Having knowledge of a situation"},
            {"fierce", "Displaying aggression"},
            {"accident", "An unfortunate incident that occurs unexpectedly"},
            {"collapse", "To fall down suddenly"},
            {"weigh", "How heavy something is"},
            {"brain", "An organ functioning as the central for nervous activity"},
            {"dozen", "A group of twelve"},
            {"lizard", "A reptile"},
            {"cube", "A solid created by 6 equal squares"},
            {"degree", "A measure of temperature or pressure"},
            {"besides", "At the side of"}};
    static String[][] level2 = {{"regret", "To feel remorse"},
            {"additional","Added"},
            {"grasp","To seize"},
            {"launch","To send forth"},
            {"device", "A thing made for a particular purpose"},
            {"hint", "A helpful suggestion"},
            {"coast", "The land next to the sea"},
            { "structure", "A mode of building"},
            {"positive","Possessing happiness"},
            {"thrill", "To affect with sudden excitement"},
            {"vision", "The act of sensing with eyes"}};
    static String[][] level3 = {{"dismay", "Disheartened"},
            {"lack","Deficiency"},
            {"applaud","To clap in expression of approval"},
            {"intend","To have in mind something that needs to be done"},
            {"calculate", "Compute"},
            {"limb","Projecting part of the body"},
            {"dispute", "Conflict or disagreement"},
            {"outrage", "Act of cruelty or violence"},
            {"engage", "Occupy the attention or efforts of a person"},
            {"recognize", "To identify as something or someone previously seen"},
            {"create", "To come into being"}};
    static String[][] level4 = {{"ample", "Fully sufficient"},
            {"comply","To act or be in accordance with wishes"},
            {"dormant","Lying asleep"},
            {"anxious","Full of mental distress"},
            {"proceed", "To go forward"},
            {"blizzard","A storm with driving snow"},
            {"previous", "Occurring before something else"},
            {"combine","To join in a close union or whole"},
            {"brittle","Having hardness or rigidity but breaking easily"},
            {"extract","To get, pull, or draw out"},
            {"comprehend", "To understand"}};
    static String[][] level5 = {{"affection", "Fond attachment or love"},
            {"exhibit", "To offer or expose to view"},
            {"arrogant","Making claims to superior importance of rights, proud"},
            {"campaign", "A systematic course of aggressive activities"},
            {"degrade", "To lower in dignity or estimation"},
            {"abundant", "Present in great quantity"},
            {"rural","Living in the country"},
            {"aloft","High up"},
            {"inflate","To distend, swell, or puff out"},
            {"futile","Ineffective"},
            {"sneer", "To smile contemptuously"}};
    static String[][] level6 = {{"epidemic", "Extremely prevalent or widespread"},
            {"industrious", "Working energetically"},
            {"compel","To force"},
            {"emit","To send forth"},
            {"formidable", "Causing fear"},
            {"prospective","In the future"},
            {"alternative", "A choice limited to two or more possibilities"},
            {"distinction", "Marking off or distinguishing as different"},
            {"dissuade","To deter by advice or persuasion"},
            {"resolve","To come to a definite or earnest decision, determine"},
            {"perturb", "To agitate"}};
    static String[][] level7 = {{"reproach","To find fault with, blame"},
            {"inflammatory","Tending to arouse anger"},
            {"concise", "Expressing or covering much in a few words"},
            {"excruciating", "Extremely painful"},
            {"abrasion","A scraped spot or area"},
            {"inventory","A complete listing of merchandise"},
            {"succumb","To give way to a superior force"},
            {"ordain","To invest with ministerial functions"},
            {"ovation","Enthusiastic public reception of a person"},
            {"vilify","To speak ill of"},
            {"surpass","To go beyond in amount, be greater than"}};
    static String[][] level8 = {{"quirk","A peculiarity of action or behavior"},
            {"sanction","Authoritative permission or approval"},
            {"enshrine","To enclose in a shrine"},{"apex","A vertex"},
            {"sordid","Morally ignoble or base"},
            {"vitriolic","Caustic"},
            {"expend","To use up"},
            {"truism","Self-evident truth"},
            {"spry","Active or nimble"},
            {"belated","Late"},
            {"caliber","Degree of excellence, quality"},
            {"potential","Having possibility"}};
    static String[][] level9 = {{"hypothetical","Supposed"},
            {"avarice","Insatiable greed for riches"},
            {"fortuitous","Lucky or fortunate"},
            {"incoherent","Without logical or meaningful connection"},
            {"charisma","Authority over large groups of people"},
            {"incumbent","Holding an indicated position"},
            {"harbinger","A herald"},
            {"ebullient","Overflowing with fervor"},
            {"amenable","Ready or willing to answer"},
            {"bane","A person or thing that ruins"},
            {"rambunctious","Difficult to control or handle"}};
    static String[][] level10 = {{"antipathy","A natural repugnance"},
            {"idiosyncrasy","A characteristic particular to an individual"},
            {"pedagogue","A teacher"},
            {"deleterious","Injurious to health"},
            {"moratorium","A suspension of activity"},
            {"promulgate","To publish or proclaim publicly"},
            {"effrontery","Shameless or impudent boldness"},
            {"incensed","To be angered intensely"},
            {"grisly","Gruesome"},
            {"propound","Set forth, propose"},
            {"apocryphal","Of doubtful authorship or authenticity"}};
    static String[][] level11 = {{"parlous","Perilous, dangerous"},
            {"exegesis","A critical explanation of a text"},
            {"peccadillo","A very minor or slight sin or offense"},
            {"prolix","Long and wordy"},
            {"appellation","A name or title"},
            {"limn","To represent in a drawing or painting"},
            {"cadaver","A dead body"},
            {"onus","A difficult or disagreeable task or burden"},
            {"nadir","The lowest point"},
            {"sybaritic","Characterized by loving luxury"},
            {"verisimilitude","The appearance or semblance of truth"},
            {"pastiche","A mixture of disparate items"}};
    public static String[][][] allLists = {level1,level2,level3,level4,level5,level6,level7,level8,level9,level10,level11};
    ArrayList<String> allDefs = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    List<Integer> correctAnswerIndices = new ArrayList<>();
    int questionNumber = -1;
    boolean answered;
    String[][] questions = {null,null,null,null,null,null,null,null,null,null,null};
    public static int numberCorrect = 0;
    public static int numberOfWords = allLists.length;
    public static ArrayList<String> wordsWrong = new ArrayList<String>();
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz_page);
        sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        numberCorrect = 0;
        wordsWrong.clear();
        numberOfWords = allLists.length;
        question = (TextView) findViewById(R.id.firstQuestion);
        createQuestionWords();
        listview = (ListView) findViewById(R.id.choices);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lst);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        progress = (TextView) findViewById(R.id.progress);
        submitAnswer = (Button) findViewById(R.id.submit);
        submitAnswer.setText(R.string.beginQuiz);
        answered = false;
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long l) {
        if (!answered) {
            String colorHighlighted;
            if (position == correctAnswerIndices.get(questionNumber)) {
                colorHighlighted = getResources().getString(R.color.correctChoice);
                numberCorrect += 1;
            } else {
                colorHighlighted = getResources().getString(R.color.incorrectChoice);
                wordsWrong.add(questions[questionNumber][0]);
            }
            if (sharedpreferences.getInt("Level",-1) == 12) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("Level",0).commit();
            }
            view.setBackgroundColor(Color.parseColor(colorHighlighted));
            answered = true;
        }
}

    @Override
    public void onClick(View view) {
        allDefs.clear();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                allDefs.add(allLists[i][j][1]);
            }
        }
        for (int i = 0; i < 11; i++) {
            allDefs.remove(questions[i][1]);
        }
        if (questionNumber <= numberOfWords - 1) {
            answered = false;
            question.setText("");
            lst.clear();
            values.clear();
            if (questionNumber >= numberOfWords - 2) {
                progress.setText("Question " + Integer.toString(numberOfWords) + " of " + Integer.toString(numberOfWords));
                submitAnswer.setText("Submit Quiz");
            } else {
                progress.setText("Question " + Integer.toString(questionNumber + 2) + " of " + Integer.toString(numberOfWords));
                submitAnswer.setText(R.string.nextQuestion);
            }
            listview.setAdapter(adapter);
            if (questionNumber < numberOfWords - 1) {
                questionNumber += 1;
                int answerIndex = ran.nextInt(4);
                for (int j = 0; j < 4; j++) {
                    if (j == answerIndex) {
                        values.add(questions[questionNumber][1]);
                        correctAnswerIndices.add(answerIndex);
                    } else {
                        String pickedDef = allDefs.get(ran.nextInt(allDefs.size()));
                        values.add(pickedDef);
                        allDefs.remove(pickedDef);
                    }
                }
            }
            else {
                Intent showQuizResults = new Intent(this,showQuizResults.class);
                String extractedValue = sharedpreferences.getString(MainActivity.allScores, "");
                SharedPreferences.Editor editor = sharedpreferences.edit();
                if (extractedValue == "") {
                    extractedValue+=(("Diagnostic Quiz Result: " + Integer.toString(numberCorrect))+",");
                    editor.putInt("Level",numberCorrect);
                } else {
                    extractedValue += (("Leveling Up Quiz Result: " + Integer.toString(numberCorrect)) + ",");
                }
                editor.putString(MainActivity.allScores,extractedValue).commit();
                finish();
                startActivity(showQuizResults);
            }
        }
        if (questionNumber <= numberOfWords-1) {
            String wordChosen = questions[questionNumber][0];
            question.setText("What is the definition of " + wordChosen + "?");
            for (int i = 0; i < values.size(); ++i) {
                lst.add(values.get(i));
            }
        }
    }

    public void createQuestionWords() {
        if (sharedpreferences.getInt("Level",-1) == 0 && !(sharedpreferences.getString("takenDiagnostic","")=="false")) {
            for (int i = 0; i < numberOfWords; i++) {
                questions[i] = allLists[i][ran.nextInt(numberOfWords)];
            }
            question.setText("This is a quiz to determine your English proficiency so that we can recommend level-appropriate books to you. Please press the 'Begin Quiz' button in order to answer the questions.");
        } else {
            int dispLevel = sharedpreferences.getInt("Level", -1) - 1;
            if (dispLevel == 11) {
                question.setText("You have finished all of the available levels and are now a master of the English language!");
                submitAnswer.setVisibility(View.GONE);
            }
            if (dispLevel <= numberOfWords) {
                ArrayList<String[]> removingArrayList = new ArrayList<String[]>();
                for (int j = 0; j < numberOfWords; j++) {
                    removingArrayList.add(allLists[dispLevel][j]);
                }
                for (int i = 0; i < numberOfWords; i++) {
                    int indexChosen = ran.nextInt(removingArrayList.size());
                    questions[i] = removingArrayList.get(indexChosen);
                    removingArrayList.remove(indexChosen);
                }
                question.setText("Because you have completed all of the books in level " + Integer.toString(Recommendations.unchangedLevel) + ", you can now level up to Level " + Integer.toString(Recommendations.unchangedLevel + 1) + " by taking this quiz. Good luck!");
            }
        }

    }

}
