package com.lajgaard.liarsdicesnyd;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class playActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mySensor;
    private SensorManager SM;
    private MediaPlayer player;

    int[] playerdice = new int[6];
    Random rnd = new Random();
    int[] playerDice1 = new int[6]; int[] playerDice2 = new int[6]; int[] playerDice3 = new int[6]; int[] playerDice4 = new int[6]; int[] playerDice5 = new int[6]; int[] playerDice6 = new int[6];
    int turn, diceNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        turn = 0;

        for (int i = 1; i < setupActivity.playerNumber; i++) {
            playerdice[i] = setupActivity.diceNumber;
            updateDice(playerdice[i]);
        }

        //Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Setting the player to play a specific sound
        player = MediaPlayer.create(this, R.raw.freedicerollsoundeffect);
    }

    public void updateDice(int dice){
        if (dice == 1){
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
        } else if (dice == 2) {
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
            findViewById(R.id.dice2).setVisibility(View.VISIBLE);
        } else if (dice == 3) {
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
            findViewById(R.id.dice2).setVisibility(View.VISIBLE);
            findViewById(R.id.dice3).setVisibility(View.VISIBLE);
        } else if (dice == 4) {
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
            findViewById(R.id.dice2).setVisibility(View.VISIBLE);
            findViewById(R.id.dice3).setVisibility(View.VISIBLE);
            findViewById(R.id.dice4).setVisibility(View.VISIBLE);
        } else if (dice == 5) {
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
            findViewById(R.id.dice2).setVisibility(View.VISIBLE);
            findViewById(R.id.dice3).setVisibility(View.VISIBLE);
            findViewById(R.id.dice4).setVisibility(View.VISIBLE);
            findViewById(R.id.dice5).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.dice1).setVisibility(View.VISIBLE);
            findViewById(R.id.dice2).setVisibility(View.VISIBLE);
            findViewById(R.id.dice3).setVisibility(View.VISIBLE);
            findViewById(R.id.dice4).setVisibility(View.VISIBLE);
            findViewById(R.id.dice5).setVisibility(View.VISIBLE);
            findViewById(R.id.dice6).setVisibility(View.VISIBLE);
        }
    }



    public void newBid(View view) //the same as the other way of changing activity
    {
        Toast.makeText(getApplicationContext(), "A new bet will be placed", Toast.LENGTH_LONG).show();
    }

    public void liftCup(View view) //the same as the other way of changing activity
    {
        Toast.makeText(getApplicationContext(), "You didn't believe the earlier player", Toast.LENGTH_LONG).show();
    }

    public void exitGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to the main window", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.values[0] > 15 || event.values[1] > 15 || event.values[2] > 15){ //checks both x, y and z values
            Toast.makeText(getApplicationContext(), "Shaking dices", Toast.LENGTH_LONG).show();
            player.start();

            if (turn < setupActivity.playerNumber) {
                giveRndValues(turn);
                turn++;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not used
    }

    public void giveRndValues(Integer player){
        for (int i = 1; i < playerdice[turn]; i++){
            if (player == 1){
                playerDice1[i] = rnd.nextInt(6) + 1; //nextInt returns int from zero to value but exclusive therefor + 1
                if (setupActivity.playerNumber == 1) turn = 0;
                changePicture(1, i, playerDice1[i]);
            } else if (player == 2) {
                playerDice2[i] = rnd.nextInt(6) + 1;
                if (setupActivity.playerNumber == 2) turn = 0;
                changePicture(2, i, playerDice2[i]);
            } else if (player == 3) {
                playerDice3[i] = rnd.nextInt(6) + 1;
                if (setupActivity.playerNumber == 3) turn = 0;
                changePicture(3, i, playerDice3[i]);
            } else if (player == 4) {
                playerDice4[i] = rnd.nextInt(6) + 1;
                if (setupActivity.playerNumber == 4) turn = 0;
                changePicture(4, i, playerDice4[i]);
            } else if (player == 5) {
                playerDice5[i] = rnd.nextInt(6) + 1;
                if (setupActivity.playerNumber == 5) turn = 0;
                changePicture(5, i, playerDice5[i]);
            } else {
                playerDice6[i] = rnd.nextInt(6) + 1;
                if (setupActivity.playerNumber == 6) turn = 0;
                changePicture(6, i, playerDice6[i]);
            }
        }
    }

    public void changePicture (Integer player, Integer picNum, Integer picVal){
        if (player == 1){
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        } else if (player == 2){
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        } else if (player == 3){
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        } else if (player == 4){
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        } else if (player == 5){
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        } else {
            if (picNum == 1){
                if (picVal == 1)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice1).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 2){
                if (picVal == 1)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice2).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 3){
                if (picVal == 1)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice3).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 4){
                if (picVal == 1)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice4).setBackgroundResource(R.drawable.dice6);
            } else if (picNum == 5){
                if (picVal == 1)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice5).setBackgroundResource(R.drawable.dice6);
            } else {
                if (picVal == 1)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice1);
                else if (picVal == 2)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice2);
                else if (picVal == 3)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice3);
                else if (picVal == 4)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice4);
                else if (picVal == 5)findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice5);
                else findViewById(R.id.dice6).setBackgroundResource(R.drawable.dice6);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        player.release();
    }
}
