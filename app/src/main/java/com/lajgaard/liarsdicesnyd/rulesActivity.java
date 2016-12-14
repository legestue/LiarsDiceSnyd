package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class rulesActivity extends AppCompatActivity {

    Spinner spinneruse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        spinneruse = (Spinner)findViewById(R.id.spinner);
        spinneruse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView myText = (TextView) findViewById(R.id.ruleText);
                //using the spinner to select between the rules that you want to read by placing a already written string into it
                switch (position) {
                    case 0 :
                        //adding toast in each spinner item. You can use any code here
                        Toast.makeText(getApplicationContext(), "Overall rules selected", Toast.LENGTH_SHORT).show();
                        myText.setText(R.string.overAllRules);
                        break;
                    case 1 :
                        Toast.makeText(getApplicationContext(), "How to count eyes selected", Toast.LENGTH_SHORT).show();
                        myText.setText(R.string.eyeCounting);
                        break;
                    case 2 :
                        Toast.makeText(getApplicationContext(), "How the stair works selected", Toast.LENGTH_SHORT).show();
                        myText.setText(R.string.theStairRule);
                        break;
                    case 3 :
                        Toast.makeText(getApplicationContext(), "How the bids works", Toast.LENGTH_SHORT).show();
                        myText.setText(R.string.biddingRule);
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Not required now
            }
        });
    }

    public void exitRules(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
