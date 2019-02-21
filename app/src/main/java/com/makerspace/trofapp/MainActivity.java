package com.makerspace.trofapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //myFact contains Fact objects
    Fact[] myFacts = new Fact[5];
    //to track index of current fact, max value myFact.length
    int indexOfCurrentFact = 0;

    //track score value
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize facts
        myFacts[0] = new Fact("Earth is closest to the sun in January.", true);
        myFacts[1] = new Fact("An octopus  has two hearts.", false);
        myFacts[2] = new Fact("Birds are dinosaurs.", true);
        myFacts[3] = new Fact("Goldfish only have a memory of three seconds.", false);
        myFacts[4] = new Fact("The first detailed map of Mars dates back to 1877", true);

        changeFact();
    }

    public void onTrueButtonClicked(View view){
        Fact currentFact = myFacts[indexOfCurrentFact];
        boolean isCurrentFactTrue = currentFact.isTrue;

        if(isCurrentFactTrue){
            increaseScore();
        }

        changeFact();
    }

    public void onFalseButtonClicked(View view){
        Fact currentFact = myFacts[indexOfCurrentFact];
        boolean isCurrentFactTrue = currentFact.isTrue;

        if(!isCurrentFactTrue){
            increaseScore();
        }
        changeFact();
    }


    public void increaseScore(){
        score++;
        TextView tvScore = findViewById(R.id.tv_score);
        tvScore.setText("Score:"+score);
    }

    public void changeFact(){
        //increase value of index of current fact
        indexOfCurrentFact++;

        //check index for validity
        if(indexOfCurrentFact >= myFacts.length) indexOfCurrentFact = 0;

        //find text view by id
        TextView textView = findViewById(R.id.tv_fact);

        //set text of textview to current fact
        textView.setText(myFacts[indexOfCurrentFact].fact);
    }
}
