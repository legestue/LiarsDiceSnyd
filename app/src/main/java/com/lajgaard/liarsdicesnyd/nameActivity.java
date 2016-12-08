package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class nameActivity extends AppCompatActivity {

    static String play1, play2, play3, play4, play5, play6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        if (setupActivity.playerNumber == 1){
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
        } else if (setupActivity.playerNumber == 2) {
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
            findViewById(R.id.player2).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText2).setVisibility(View.VISIBLE);
        } else if (setupActivity.playerNumber == 3) {
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
            findViewById(R.id.player2).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText2).setVisibility(View.VISIBLE);
            findViewById(R.id.player3).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText3).setVisibility(View.VISIBLE);
        } else if (setupActivity.playerNumber == 4) {
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
            findViewById(R.id.player2).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText2).setVisibility(View.VISIBLE);
            findViewById(R.id.player3).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText3).setVisibility(View.VISIBLE);
            findViewById(R.id.player4).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText4).setVisibility(View.VISIBLE);
        } else if (setupActivity.playerNumber == 5) {
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
            findViewById(R.id.player2).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText2).setVisibility(View.VISIBLE);
            findViewById(R.id.player3).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText3).setVisibility(View.VISIBLE);
            findViewById(R.id.player4).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText4).setVisibility(View.VISIBLE);
            findViewById(R.id.player5).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText5).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.player1).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText1).setVisibility(View.VISIBLE);
            findViewById(R.id.player2).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText2).setVisibility(View.VISIBLE);
            findViewById(R.id.player3).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText3).setVisibility(View.VISIBLE);
            findViewById(R.id.player4).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText4).setVisibility(View.VISIBLE);
            findViewById(R.id.player5).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText5).setVisibility(View.VISIBLE);
            findViewById(R.id.player6).setVisibility(View.VISIBLE);
            findViewById(R.id.playerEditText6).setVisibility(View.VISIBLE);
        }

    }

    public void playGame(View view) //the same as the other way of changing activity
    {
        if (setupActivity.playerNumber == 1){
            play1 = (String)findViewById(R.id.playerEditText1).toString();
        } else if (setupActivity.playerNumber == 2) {
            play1 = (String)findViewById(R.id.playerEditText1).toString();
            play2 = (String)findViewById(R.id.playerEditText2).toString();
        } else if (setupActivity.playerNumber == 3) {
            play1 = (String)findViewById(R.id.playerEditText1).toString();
            play2 = (String)findViewById(R.id.playerEditText2).toString();
            play3 = (String)findViewById(R.id.playerEditText3).toString();
        } else if (setupActivity.playerNumber == 4) {
            play1 = (String)findViewById(R.id.playerEditText1).toString();
            play2 = (String)findViewById(R.id.playerEditText2).toString();
            play3 = (String)findViewById(R.id.playerEditText3).toString();
            play4 = (String)findViewById(R.id.playerEditText4).toString();
        } else if (setupActivity.playerNumber == 5) {
            play1 = (String)findViewById(R.id.playerEditText1).toString();
            play2 = (String)findViewById(R.id.playerEditText2).toString();
            play3 = (String)findViewById(R.id.playerEditText3).toString();
            play4 = (String)findViewById(R.id.playerEditText4).toString();
            play5 = (String)findViewById(R.id.playerEditText5).toString();
        } else {
            play1 = (String)findViewById(R.id.playerEditText1).toString();
            play2 = (String)findViewById(R.id.playerEditText2).toString();
            play3 = (String)findViewById(R.id.playerEditText3).toString();
            play4 = (String)findViewById(R.id.playerEditText4).toString();
            play5 = (String)findViewById(R.id.playerEditText5).toString();
            play6 = (String)findViewById(R.id.playerEditText6).toString();
        }

        Intent myIntent = new Intent(this, playActivity.class);
        Toast.makeText(getApplicationContext(), "Starting the game", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    public void exitGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to the main window", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }
}
