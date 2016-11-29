package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                    startActivity(myIntent);
                }
            }
        );
    }
}
