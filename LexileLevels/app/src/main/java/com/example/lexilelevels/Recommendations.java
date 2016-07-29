package com.example.lexilelevels;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Recommendations extends AppCompatActivity {

    TextView results;
    LinearLayout allRecs;
    String[][] booksLevel0 = {
            {"The Very Hungry Caterpillar", "Eric Carle"},
            {"Llama Llama Mad at Mama", "Anna Dewdeney"},
            {"Room on the Broom", "Julia Donaldson"},
            {"Baby Beluga", "Raffi Cavoukian"},
            {"The Pigeon Wants a Puppy", "Moe Williams"},
    };
    String[][] booksLevel1 = {
            {"The Cat in the Hat", "Dr. Seuss"},
            {"Where the Wild Things Are", "Maurice Sendak"},
            {"Frog and Toad Together", "Arnold Lobell"},
            {"Tikki Tikki Tembo", "Arlene Mosel"},
            {"Strega Nona", "Tomie DePaola"}
    };
    String[][] booksLevel2 = {
            {"The Giving Tree", "Shel Silverstein"},
            {"Mufaro's Beautiful Daughters", "John Stepto"},
            {"The Rough Face Girl", "Rafee Martin"},
            {"Anansi the Spider", "Gerald McDermott"},
            {"The Emperor and the Kite", "Jane Yolen"}
    };
    String[][] booksLevel3 = {
            {"Charlotte's Web", "E. B. White"},
            {"Nancy Drew", "Carolyn Keene"},
            {"The Penderwicks", "Jeanne Birdsal"},
            {"Little House on the Prairie", "Laura Ingalls Wilder"},
            {"Ginger Pye", "Eleanor Estes"}
    };
    String[][] booksLevel4 = {
            {"The Tale of Desperaux", "Kate DiCamillo"},
            {"The Phantom Tollbooth", "Norton Juster"},
            {"George's Marvelous Medicine", "Roald Dahl"},
            {"Esperanza Rising", "Pam Ryan"},
            {"City of Ember", "Jeanne DuPrau"}
    };
    String[][] booksLevel5 = {
            {"The Mysterious Benedict Society", "Trenton Lee Stewart"},
            {"The Golden Compass", "Phillip Pulman"},
            {"The Witch of Blackbird Pond", "Elizabeth George Spear"},
            {"Island of the Blue Dolphins", "Scott O'Dell"},
            {"Howl's Moving Castle", "Diana Wynn Jones"}
    };
    String[][] booksLevel6 = {
            {"The Graveyard Book", "Neil Gaiman"},
            {"The Giver", "Lois Lowry"},
            {"Harry Potter and the Sorcerer's Stone", "J. K. Rowling"},
            {"The Westing Game", "Ellen Raskin"},
            {"The Name of this Book is Secret", "Pseudonymous Bosch"}
    };
    String[][] booksLevel7 = {
            {"And Then There Were None", "Agatha Christie"},
            {"The Night Circus", "Erin Morgenstern"},
            {"Journey to the Center of the Earth", "Jules Verne"},
            {"Ender's Game", "Orson Scott Card"},
            {"A Study in Scarlet", "Arthur Conan Doyle"}
    };
    String[][] booksLevel8 = {
            {"Heart of Darkness", "Joseph Conrad"},
            {"A Christmas Carol", "Charles Dickens"},
            {"The Book Thief", "Marcus Zusak"},
            {"The Hobbit", "J. R. Tolkien"},
            {"The Hunger Games", "Suzanne Collins"}
    };
    String[][] booksLevel9 = {
            {"The Great Gatsby", "F. Scott Fitzgerald"},
            {"The Catcher in the Rye", "J. D. Salinger"},
            {"Travels With Charley", "John Steinbeck"},
            {"The Strange Case of Dr. Jekyll and Mr. Hyde", "Robert Louis Stevenson"},
            {"War of the Worlds", "H. G. Wells"}
    };
    String[][] booksLevel10 = {
            {"Frankenstein", "Mary Shelley"},
            {"Pride and Prejudice", "Jane Austen"},
            {"Alice's Adventures in Wonderland", "Lewis Carroll"},
            {"Les Miserables", "Victor Hugo"},
            {"The Fool", "Fyodor Dostoyevsky"}
    };
    String[][] booksLevel11 = {
            {"Masque of the Red Death", "Edgar Allen Poe"},
            {"Huckleberry Finn", "Mark Twain"},
            {"The Tempest", "William Shakespeare"},
            {"The Sound and the Fury", "William Faulkner"},
            {"Paradise Lost", "John Milton"}
    };
    static int onDisplay = 0;
    static int bookCounter = 0;
    static int level = firstQuizPage.numberCorrect;
    static int unchangedLevel = level;
    String resultsDisplay = "Results: " + Integer.toString(level) + " / " + Integer.toString(firstQuizPage.numberOfWords) + "\n \nPlacement: Level " + Integer.toString(level);
    String[][][] allBooks = {booksLevel0, booksLevel1, booksLevel2, booksLevel3, booksLevel4, booksLevel5, booksLevel6, booksLevel7, booksLevel8, booksLevel9, booksLevel10, booksLevel11};
    int bookTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        results = (TextView) findViewById(R.id.displayResults);
        results.setText(resultsDisplay);
        allRecs = (LinearLayout) findViewById(R.id.allRecs);
        recs();
    }

    public void recs() {
        for (int j = 0; j < allBooks.length; j++) {
            for (int k = 0; k < allBooks[j].length; k++) {
                bookTotal += 1;
            }
        }
        level = firstQuizPage.numberCorrect;
        unchangedLevel = level;
        String resultsDisplay = "Results: " + Integer.toString(level) + " / " + Integer.toString(firstQuizPage.numberOfWords) + "\n \nPlacement: Level " + Integer.toString(level);
        results.setText(resultsDisplay);
        for (int i = 0; i < allBooks[i].length; i++) {
            createOneRec(i);
            onDisplay += 1;
            bookCounter += 1;
        }
    }

    public void createOneRec(final int i) {
        final LinearLayout rec = new LinearLayout(this);
        rec.setLayoutParams(new LinearLayout.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        rec.setPadding(0,70,0,70);
        rec.setOrientation(LinearLayout.HORIZONTAL);
        CheckBox checkOff = new CheckBox(this);
        rec.addView(checkOff);
        for (int j = 0; j < allBooks[unchangedLevel][i].length; j++) {
            TextView bookElement = new TextView(this);
            checkOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rec.setPadding(0, 0, 0, 0);
                    if (onDisplay >= allBooks[level].length - 1) {
                        if (level < allBooks.length - 1) {
                            level += 1;
                            firstQuizPage.numberCorrect = 0;
                            onDisplay = 0;
                            createOneRec(0);
                        }
                    } else {
                        onDisplay += 1;
                        createOneRec(onDisplay);
                    }
                    rec.removeAllViews();
                    bookCounter+=1;
                    if (bookCounter == ((allBooks.length + 1) - unchangedLevel) * 5) {
                        results.setText(R.string.completionCongratulations);
                        onDisplay = 0;
                        bookCounter = 0;
                        level = 0;
                        unchangedLevel = 0;
                        final int score = firstQuizPage.numberCorrect;
                        firstQuizPage.numberCorrect = 0;
                    }
                }
            });
            bookElement.setText(allBooks[level][i][j]);
            bookElement.setTypeface(Typeface.SERIF);
            bookElement.setPadding(10, 0, 10, 0);
            bookElement.setTextSize(20);
            bookElement.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            rec.addView(bookElement);
        }
        allRecs.addView(rec);
    }
}
