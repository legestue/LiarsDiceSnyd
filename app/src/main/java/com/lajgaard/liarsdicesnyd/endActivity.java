package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class endActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView looserText = (TextView)findViewById(R.id.looserText);
        looserText.setText("The looser is: " + nameActivity.playerString[playActivity.looser]);
    }

    public void toMain (View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to Main", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }

    public void toSetup(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, setupActivity.class);
        Toast.makeText(getApplicationContext(), "Starting new game with new setup", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }

    public void toPlay(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, playActivity.class);
        Toast.makeText(getApplicationContext(), "Starting new game with same setup", Toast.LENGTH_SHORT).show();
        startActivity(myIntent);
    }
}
