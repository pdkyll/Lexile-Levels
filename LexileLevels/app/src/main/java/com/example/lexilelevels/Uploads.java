package com.example.lexilelevels;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

public class Uploads extends AppCompatActivity {

    TextView dispBookLevel;
    String dracula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);
        dispBookLevel = (TextView) findViewById(R.id.bookTrial);
        MyVocab.main();
        dracula = "Under construction... \n \nDracula \nby Bram Stoker \n \n_3 May. Bistritz._--Left Munich at 8:35 P. M., on 1st May, arriving at " +
                "Vienna early next morning; should have arrived at 6:46, but train was an" +
                " hour late. Buda-Pesth seems a wonderful place, from the glimpse which I" +
                " got of it from the train and the little I could walk through the" +
                " streets. I feared to go very far from the station, as we had arrived" +
                " late and would start as near the correct time as possible. The" +
                " impression I had was that we were leaving the West and entering the" +
                " East; the most western of splendid bridges over the Danube, which is" +
                " here of noble width and depth, took us among the traditions of Turkish" +
                " rule... \n \nLevel: " + Integer.toString(MyVocab.greatestLevel);
        dispBookLevel.setText(dracula);
    }

}
