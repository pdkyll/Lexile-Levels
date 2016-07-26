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
    ArrayList<String> list = new ArrayList<String>();
    String[] values = new String[] { "A piece of clothing worn on the head", "A stringy root", "A tree", "A feral cat found in South America" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz_page);
        listview = (ListView) findViewById(R.id.list1);

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        question = (TextView) findViewById(R.id.firstQuestion);
        /*answers1 = (ListView) findViewById(R.id.list1);
        question = (TextView) findViewById(R.id.firstQuestion);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < choices1.length; ++i) {
            list.add(choices1[i]);
           // arrayAdapter1.addItem(choices1[i]);
        }


        arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_2, list);
        answers1.setAdapter(arrayAdapter1); */
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long l) {
        Log.d("android",position + " : " + list.get(position));
        view.setBackgroundColor(Color.parseColor(getString(R.color.selectedChoice)));
    }

    @Override
    public void onClick(View view) {
        question.setText("");

    }

}
