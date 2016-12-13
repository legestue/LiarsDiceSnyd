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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class playActivity extends AppCompatActivity {

    private Sensor mySensor;
    private SensorManager SM;
    private MediaPlayer player;

    static int looser = 0;
    int[][] playerdice = new int[setupActivity.playerNumber][setupActivity.diceNumber];
    Random rnd = new Random();
    int[] diceNumberLeft = new int[setupActivity.playerNumber];
    int turn, diceNum, diceSize;
    int[] rollFlag = new int [setupActivity.playerNumber];
    ImageView[] imageDice = new ImageView[6];
    NumberPicker rollerDice, rollerNumber;
    Button confirmBid;
    Boolean bid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        turn = 0;

        for (int i = 0; i < setupActivity.playerNumber; i++) {
            rollFlag[i] = 0;
            diceNumberLeft[i] = setupActivity.diceNumber;
            for (int n = 0; n < setupActivity.diceNumber; n++){
                playerdice[i][n] = 1;
            }
        }

        bid = false;

        //array of image views
        imageDice[0] = (ImageView)findViewById(R.id.dice1);
        imageDice[1] = (ImageView)findViewById(R.id.dice2);
        imageDice[2] = (ImageView)findViewById(R.id.dice3);
        imageDice[3] = (ImageView)findViewById(R.id.dice4);
        imageDice[4] = (ImageView)findViewById(R.id.dice5);
        imageDice[5] = (ImageView)findViewById(R.id.dice6);

        rollerDice = (NumberPicker)findViewById(R.id.diceChosen);
        rollerNumber = (NumberPicker)findViewById(R.id.numberOfDices);
        confirmBid = (Button) findViewById(R.id.confirmBot);

        rollerDice.setMinValue(2);
        rollerDice.setMaxValue(6);

        rollerNumber.setMinValue(1);
        rollerNumber.setMaxValue(42);

        updateDice();

        TextView playerID = (TextView)findViewById(R.id.playerID);
        playerID.setText("Turn: " + nameActivity.playerString[turn]);

        //Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor listener
        SM.registerListener(SMListener, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Setting the player to play a specific sound
        player = MediaPlayer.create(this, R.raw.freedicerollsoundeffect);

        for (int i = 0; i < setupActivity.playerNumber; i++){
            for (int n = 0; n < setupActivity.diceNumber; n++){
                playerdice[i][n] = 0;
            }
        }
    }

    public void newBid(View view) //the same as the other way of changing activity
    {
        if (rollFlag[turn] == 1){
            Toast.makeText(getApplicationContext(), "A new bet will be placed", Toast.LENGTH_LONG).show();
            rollerDice.setVisibility(View.VISIBLE);
            rollerNumber.setVisibility(View.VISIBLE);
            confirmBid.setVisibility(View.VISIBLE);
        } else Toast.makeText(getApplicationContext(), "A role has not happen", Toast.LENGTH_LONG).show();

    }

    public void confirmBid(View view){

        TextView lastBidText = (TextView)findViewById(R.id.lastBidText);
        lastBidText.setVisibility(View.VISIBLE);
        TextView playerID = (TextView)findViewById(R.id.playerID);

        if (diceNum < rollerDice.getValue()){
            if (diceSize <= rollerNumber.getValue()){
                bid = true;
                diceNum = rollerDice.getValue();
                diceSize = rollerNumber.getValue();

                lastBidText.setText("Last bid = Dice: " + diceNum + ", Number of Dices: " + diceSize);

                if (turn == setupActivity.playerNumber - 1) turn = 0;
                else{
                    do{
                        turn++;
                    }while(diceNumberLeft[turn] == 0);
                }

                playerID.setText("Turn: " + nameActivity.playerString[turn]);

                rollerDice.setVisibility(View.INVISIBLE);
                rollerNumber.setVisibility(View.INVISIBLE);
                confirmBid.setVisibility(View.INVISIBLE);

                updateDice();
                changePicture();
            } else {
                Toast.makeText(getApplicationContext(), "Cannot put that bid", Toast.LENGTH_LONG).show();
            }

        } else if (diceNum >= rollerDice.getValue()) {
            if (diceSize < rollerNumber.getValue()){
                bid = true;
                diceNum = rollerDice.getValue();
                diceSize = rollerNumber.getValue();

                lastBidText.setText("Last bid = Dice: " + diceNum + ", Number of Dices: " + diceSize);

                if (turn == setupActivity.playerNumber - 1) turn = 0;
                else {
                    do {
                        turn++;
                    } while (diceNumberLeft[turn] == 0);
                }

                playerID.setText("Turn: " + nameActivity.playerString[turn]);

                rollerDice.setVisibility(View.INVISIBLE);
                rollerNumber.setVisibility(View.INVISIBLE);
                confirmBid.setVisibility(View.INVISIBLE);

                updateDice();
                changePicture();
            } else {
                Toast.makeText(getApplicationContext(), "Cannot put that bid", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Cannot put that bid", Toast.LENGTH_LONG).show();
        }
    }

    public void liftCup(View view) //the same as the other way of changing activity
    {
        TextView playerID = (TextView)findViewById(R.id.playerID);
        if (bid){
            int sum = 0;
            Toast.makeText(getApplicationContext(), "You didn't believe the earlier player", Toast.LENGTH_LONG).show();
            for (int i = 0; i < setupActivity.playerNumber; i++){
                for (int n = 0; n < diceNumberLeft[i]; n++){
                    if (playerdice[i][n] == 1) sum++;
                    else if (playerdice[i][n] == diceNum) sum++;
                }
            }

            if (sum < diceSize){
                Toast.makeText(getApplicationContext(), "The dices are below the chosen the bid", Toast.LENGTH_LONG).show();

                for (int i = 0; i < setupActivity.playerNumber; i++){
                    rollFlag[i] = 0;
                    if (turn == 0){
                        if (i != setupActivity.playerNumber - 1){
                            if (diceNumberLeft[i] != 0) {diceNumberLeft[i]--;}}}
                    else if (i != turn - 1)
                        if (diceNumberLeft[i] != 0) diceNumberLeft[i]--;
                }
                if (turn == 0) turn = setupActivity.playerNumber - 1;
                else turn--;
                playerID.setText("Turn: " + nameActivity.playerString[turn]);

            } else {
                Toast.makeText(getApplicationContext(), "The dices are equal or above the chosen the bid", Toast.LENGTH_LONG).show();

                for (int i = 0; i < setupActivity.playerNumber; i++){
                    rollFlag[i] = 0;
                        if (i != turn){
                            if (diceNumberLeft[i] != 0) {diceNumberLeft[i]--;}}

                }
            }

            int playerLeft = 0;
            for (int i = 0; i < setupActivity.playerNumber; i++){
                if (diceNumberLeft[i] != 0) playerLeft++;
                looser = i;
            }

            if (playerLeft == 1) endGame(null);

            diceNum = 0;
            diceSize = 0;
            updateDice();
            changePicture();

            TextView lastBidText = (TextView)findViewById(R.id.lastBidText);
            lastBidText.setVisibility(View.INVISIBLE);

        } else Toast.makeText(getApplicationContext(), "A bid has to happen", Toast.LENGTH_LONG).show();

    }

    private final SensorEventListener SMListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent event) {

            if (event.values[0] > 15 || event.values[1] > 15 || event.values[2] > 15) { //checks both x, y and z values
                if (rollFlag[turn] == 0) {
                    giveRndValues(null);
                }
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //Not used
        }
    };

    public void giveRndValues(View view){

        if (rollFlag[turn] == 0) {
            player.start();
            Toast.makeText(getApplicationContext(), "Shaking dices", Toast.LENGTH_LONG).show();
            for (int i = 0; i < diceNumberLeft[turn]; i++) {
                playerdice[turn][i] = rnd.nextInt(5) + 1;
            }
            changePicture();
            updateDice();
            rollFlag[turn] = 1;
        }
        else Toast.makeText(getApplicationContext(), "You can only roll once", Toast.LENGTH_LONG).show();
    }

    public void updateDice(){
        for (int i = 0; i < setupActivity.diceNumber; i++){
            imageDice[i].setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < diceNumberLeft[turn]; i++){
            imageDice[i].setVisibility(View.VISIBLE);
        }
    }

    public void changePicture (){
        for (int i = 0; i < diceNumberLeft[turn]; i++) {
            switch (playerdice[turn][i]) {
                case 1:
                    imageDice[i].setBackgroundResource(R.drawable.dice1);
                    break;
                case 2:
                    imageDice[i].setBackgroundResource(R.drawable.dice2);
                    break;
                case 3:
                    imageDice[i].setBackgroundResource(R.drawable.dice3);
                    break;
                case 4:
                    imageDice[i].setBackgroundResource(R.drawable.dice4);
                    break;
                case 5:
                    imageDice[i].setBackgroundResource(R.drawable.dice5);
                    break;
                default:
                    imageDice[i].setBackgroundResource(R.drawable.dice6);
                    break;
            }
        }
    }

    public void endGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, endActivity.class);
        Toast.makeText(getApplicationContext(), "There is a looser", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    public void exitGame(View view) //the same as the other way of changing activity
    {
        Intent myIntent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Going back to the main window", Toast.LENGTH_LONG).show();
        startActivity(myIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SM.registerListener(SMListener, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        SM.unregisterListener(SMListener);
        player.release();
        super.onPause();
    }
}
