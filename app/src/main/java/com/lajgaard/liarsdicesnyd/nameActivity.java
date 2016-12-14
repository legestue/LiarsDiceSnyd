package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class nameActivity extends AppCompatActivity {

    static String[] playerString = new String[6];
    TextView[] playerText = new TextView[6];
    EditText[] playerEditText = new EditText[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //array of image views
        playerText[0] = (TextView) findViewById(R.id.player1);
        playerText[1] = (TextView) findViewById(R.id.player2);
        playerText[2] = (TextView) findViewById(R.id.player3);
        playerText[3] = (TextView) findViewById(R.id.player4);
        playerText[4] = (TextView) findViewById(R.id.player5);
        playerText[5] = (TextView) findViewById(R.id.player6);

        playerEditText[0] = (EditText)findViewById(R.id.playerEditText1);
        playerEditText[1] = (EditText)findViewById(R.id.playerEditText2);
        playerEditText[2] = (EditText)findViewById(R.id.playerEditText3);
        playerEditText[3] = (EditText)findViewById(R.id.playerEditText4);
        playerEditText[4] = (EditText)findViewById(R.id.playerEditText5);
        playerEditText[5] = (EditText)findViewById(R.id.playerEditText6);

        for (int i = 0; i < setupActivity.playerNumber; i++){
            playerText[i].setVisibility(View.VISIBLE);
            playerEditText[i].setVisibility(View.VISIBLE);
        }

    }

    public void playGame(View view) //the same as the other way of changing activity
    {
        //storing the names of the players in static string array
        for (int i = 0; i < 6; i++){
            playerString[i] = playerEditText[i].getText().toString();
        }

        Intent myIntent = new Intent(this, playActivity.class);
        Toast.makeText(getApplicationContext(), "Starting the game", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }

    public void exitGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to the main window", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }
}
