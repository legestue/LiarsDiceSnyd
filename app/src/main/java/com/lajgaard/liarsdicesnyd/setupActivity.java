package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class setupActivity extends AppCompatActivity {

    static int playerNumber, diceNumber;
    EditText playNumField, diceNumField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

    }

    //the EditText is used to give a number that are stored for the number of players and dices
    public void chosePlayer(View view) //the same as the other way of changing activity
    {
        playNumField = (EditText) findViewById(R.id.playerNumField);
        playerNumber = Integer.valueOf(playNumField.getText().toString());

        diceNumField = (EditText) findViewById(R.id.diceNumField);
        diceNumber = Integer.valueOf(diceNumField.getText().toString());

        if (playerNumber > 6){
            Toast.makeText(getApplicationContext(), "The maximum players are 6", Toast.LENGTH_SHORT).show();
        } else  if (diceNumber > 6) {
            Toast.makeText(getApplicationContext(), "The maximum dices are 6", Toast.LENGTH_SHORT).show();
        } else {
            Intent myIntent = new Intent(this, nameActivity.class);
            Toast.makeText(getApplicationContext(), "Chose players", Toast.LENGTH_SHORT).show();
            startActivity(myIntent);
        }

    }

    public void exitGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to the main window", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }
}
