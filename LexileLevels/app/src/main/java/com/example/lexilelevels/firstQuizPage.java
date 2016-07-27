package com.example.lexilelevels;

import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.Random;

import java.util.ArrayList;

public class firstQuizPage extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    /*private static final String persistingData = "persistingData";
    private static final String data_name = "takenTest";*/
    boolean takenTest = false;
    SharedPreferences savedData;
    private Random ran = new Random();
    TextView question;
    ListView listview;
    ArrayAdapter adapter;
    Button submitAnswer;
    ArrayList<String> lst = new ArrayList<String>();
    int numberOfWords = 11;
    String[][] level1 = {{"ware", "Having knowledge of a situation"}, {"fierce", "Displaying aggression"}, {"accident", "An unfortunate incident that occurs unexpectedly"}, {"collapse", "To fall down suddenly"}, {"weigh", "How heavy something is"},
            {"brain", "An organ functioning as the central for nervous activity"}, {"dozen", "A group of twelve"}, {"lizard", "A reptile"}, {"cube", "A solid created by 6 equal squares"}, {"degree", "A measure of temperature or pressure"}, {"besides", "At the side of"}};
    String[][] level2 = {{"regret", "To feel remorse"},{"additional","Added"}, {"grasp","To sieze"}, {"launch","To send forth"}, {"device", "A thing made for a particular purpose"},
            {"hint", "A helpful suggestion"}, {"coast", "The land next to the sea"}, { "structure", "A mode of building"}, {"positive","Possessing happiness"},
            {"thrill", "To affect with sudden excitement"}, {"vision",}, {"The act of sensing with eyes"}};
    String[][] level3 = {{"dismay", "Disheartened"}, {"lack","Deficiency"}, {"applaud","To clap in expression of approval"}, {"intend","To have in mind something that needs to be done"},
            {"calculate", "Compute"}, {"limb","Projecting part of the body"},{"dispute", "Conflict or disagreement"},{"outrage", "Act of cruelty or violence"},{"engage", "Occupy the attention or efforts of a person"}, {"recognize", "To identify as something or someone previously seen"}, {"create", "To come into being"}};
    String[][] level4 = {{"ample", "Fully sufficient"},{"comply","To act or be in accordance with wishes"}, {"dormant","Lying asleep"},{"anxious","Full of mental distress"},{"proceed", "To go forward"},{"blizzard","A storm with driving snow"},{"previous", "Occurring before something else"},{"combine","To join in a close union or whole"},{"brittle","Having hardness or rigidity but breaking easily"}, {"extract","To get, pull, or draw out"},{"comprehend", "To understand"}};
    String[][] level5 = {{"affection", "Fond attachment or love"},{"exhibit", "To offer or expose to view"},{"arrogant","Making claims to superior importance of rights, proud"}, {"campaign", "A systematic course of aggressive activities"}, {"degrade", "To lower in dignity or estimation"},{"abundant", "Present in great quantity"},{"rural","Living in the country"},{"aloft","High up"},{"inflate","To distend, swell, or puff out"},{"futile","Ineffective"},{"sneer", "To smile contemptuously"}};
    String[][] level6 = {{"epidemic", "Extremely prevalent or widespread"},{"industrious", "Working energetically"},{"compel","To force"},{"emit","To send forth"},{"formidable", "Causing fear"},{"prospective","In the future"},{"alternative", "A choice limited to two or more possibilities"},{"distinction", "Marking off or distinguishing as different"},{"dissuade","To deter by advice or persuasion"},{"resolve","To come to a definite or earnest decision, determine"},{"perturb", "To agitate"}};
    String[][] level7 = {{"reproach","To find fault with, blame"},{"inflammatory","Tending to arouse anger"},{"concise", "Expressing or covering much in a few words"},{"excruciating", "Extremely painful"},{"abrasion","A scraped spot or area"},{"inventory","A complete listing of merchandise"},{"succumb","To give way to a superior force"},{"ordain","To invest with ministerial functions"},{"ovation","Enthusiastic public reception of a person"},{"vilify","To speak ill of"},{"surpass","To go beyond in amount, be greater than"}};
    String[][] level8 = {{"quirk","A pecularity of action or behavior"},{"sanction","Authoritative permission or approval"}, {"enshrine","To enclose in a shrine"},{"apex","A vertex"},{"sordid","Morally ignoble or base"},{"vitriolic","Caustic"},{"expend","To use up"},{"truism","Self-evident truth"},{"spry","Active or nimble"},{"belated","Late"},{"caliber","Degree of excellence, quality"}};
    String[][] level9 = {{"hypothetical","Supposed"},{"avarice","Insatiatible greed for riches"},{"fortuitous","Lucky or forturnate"},{"incoherent","Without logical or meaningful connection"},{"charisma","Authority over large groups of people"},{"incumbent","Holding an indicated position"},{"harbinger","A herald"},{"ebullient","Overflowing with fervor"},{"amenable","Ready or willing to answer"},{"bane","A person or thing that ruins"},{"rambunctious","Difficult to control or handle"}};
    String[][] level10 = {{"antipathy","A natural repugnance"},{"idiosyncrasy","A characteristic particular to an individual"},{"pedagogue","A teacher"},{"deleterious","Injurious to health"},{"moratorium","A suspension of activity"},{"promulgate","To publish or proclaim publicly"},{"effrontery","Shameless or impudent boldness"},{"incensed","To be angered intensely"},{"grisly","Gruesome"},{"propound","Set forth, propose"},{"apocryphal","Of doubtful authorship or authenticity"}};
    String[][] level11 = {{"parlous","Perilous, dangerous"},{"exegesis","A critical explanation of a text"},{"peccadillo","A very minor or slight sin or offense"},{"prolix","Long and wordy"},{"appellation","A name or title"},{"limn","To represent in a drawing or painting"},{"cadaver","A dead body"},{"onus","A difficult or disagreeable task or burden"},{"nadir","The lowest point"},{"sybaritic","Characterized by loving luxury"},{"verisimilitude","The appearance or semblance of truth"}};
    String[][][] allLists = {level1,level2,level3,level4,level5,level6,level7,level8,level9,level10,level11};
    String[][] questions = {level1[ran.nextInt(numberOfWords)],level2[ran.nextInt(numberOfWords)],level3[ran.nextInt(numberOfWords)],
            level4[ran.nextInt(numberOfWords)],level5[ran.nextInt(numberOfWords)],level6[ran.nextInt(numberOfWords)],level7[ran.nextInt(numberOfWords)],
            level8[ran.nextInt(numberOfWords)],level9[ran.nextInt(numberOfWords)],level10[ran.nextInt(numberOfWords)],level11[ran.nextInt(numberOfWords)]};
    String[][] values = { {"A piece of clothing worn on the head", "A stringy root", "A tree", "A feral cat found in South America"},
            {"q2a1" , "q2a2" , "q2a3" , "q2a4"},{"q3a1" , "q3a2" , "q3a3" , "q3a4"},{"q4a1" , "q4a2" , "q4a3" , "q4a4"},{"q5a1" , "q5a2" , "q5a3" , "q5a4"},
            {"q6a1" , "q6a2" , "q6a3" , "q6a4"},{"q7a1" , "q7a2" , "q7a3" , "q7a4"},{"q8a1" , "q8a2" , "q8a3" , "q8a4"},{"q9a1" , "q9a2" , "q9a3" , "q9a4"},
            {"q10a1" , "q10a2" , "q10a3" , "q10a4"},{"q10a1" , "q10a2" , "q10a3" , "q10a4"}};
    int[] correctAnswerIndices = {0,1,2,3,0,1,2,3,0,1,2};
    int totalNumberOfQuestions = values.length - 1;
    int questionNumber = -1;
    boolean answered;
    public static int numberCorrect = 0;

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
                numberCorrect += 1;
            } else {
                colorHighlighted = "#" + Integer.toHexString(getColor(R.color.incorrectChoice));
            }
            view.setBackgroundColor(Color.parseColor(colorHighlighted));
            answered = true;
        }
}

    @Override
    public void onClick(View view) {
        if (questionNumber <= totalNumberOfQuestions) {
            answered = false;
            question.setText("");
            lst.clear();
            submitAnswer.setText(R.string.nextQuestion);
            listview.setAdapter(adapter);
            if (questionNumber < totalNumberOfQuestions) {
                questionNumber += 1;
            }
            else {
                submitAnswer.setText("Submit Quiz");
                Intent showQuizResults = new Intent(this,Recommendations.class);
                finish();
                startActivity(showQuizResults);
                takenTest = true;
            }
        }
        question.setText("What is the definition of " + questions[questionNumber][0] + "?");
        for (int i = 0; i < values[questionNumber].length; ++i) {
            lst.add(values[questionNumber][i]);
        }
    }
}
