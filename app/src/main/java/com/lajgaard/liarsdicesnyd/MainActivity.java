package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ruleBot = (Button)findViewById(R.id.ruleBot); //setting up the button to be able to change te activity
        ruleBot.setOnClickListener(
            new Button.OnClickListener()
            {
                public void onClick(View view) //using intent to change activity
                {
                    Intent myIntent = new Intent(view.getContext(), rulesActivity.class);
                    Toast.makeText(getApplicationContext(), "Checking the rules", Toast.LENGTH_LONG).show();
                    startActivity(myIntent);
                }
            }
        );
    }

    public void newGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, playActivity.class);
        Toast.makeText(getApplicationContext(), "Starting a new game", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }
}
