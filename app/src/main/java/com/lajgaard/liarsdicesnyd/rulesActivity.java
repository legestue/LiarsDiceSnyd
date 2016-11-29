package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class rulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    public void exitRules(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
