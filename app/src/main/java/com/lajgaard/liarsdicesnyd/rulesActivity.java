package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
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
                switch (position) {
                    case 0 :
                        //adding toast in each spinner item. You can use any code here
                        Toast.makeText(getApplicationContext(), "Over all rules selected", Toast.LENGTH_LONG).show();
                        break;
                    case 1 :
                        Toast.makeText(getApplicationContext(), "How to count eyes selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2 :
                        Toast.makeText(getApplicationContext(), "How the bids works", Toast.LENGTH_LONG).show();
                        break;
                    case 3 :
                        Toast.makeText(getApplicationContext(), "How the stair works selected", Toast.LENGTH_LONG).show();
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
