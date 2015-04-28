package com.example.drinksafe;


import android.content.Intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class DrinkCalc extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {
    //declaring all the variables and objects to be used
    Button go, home;
    TextView Answer, finalAnswer;
    RadioGroup left;
    EditText input;
    //use to create calcs which is used to create instance of DrinkCalculations to link them to work together
    DrinkCalculations calcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set page activity for drink calculations to be shown
        setContentView(R.layout.activity_drink_calc);
        //linking the go variable with the btnUnit in the activity
        go = (Button) findViewById(R.id.btnUnit);
        //linking the home variable with the btnHome in the activity
        home = (Button) findViewById(R.id.btnHome);
        //linking the answer variable with the tvCol1 in activity
        Answer=(TextView) findViewById(R.id.tvCol1);
        //assigning input to the EditText within the activity
        input=(EditText) findViewById(R.id.etRadioGrp1);
        //linking the radio group with the object in the activity
        left=(RadioGroup)findViewById(R.id.rgLeft);
        //linking final answer to the results object in the activity
        finalAnswer = (TextView) findViewById(R.id.tvResult);
    //setting on click listener for the radio group in 'this' class
        left.setOnCheckedChangeListener(this);
           //setting the on click listener for the go variable/calculate button to the units method below
        go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                units();
            }
        });
        //setting the onclick listener for the home button to use the intent in manifest to open the main menu
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMain = new Intent(DrinkCalc.this, MainActivity.class);
                //start created intent to open main menu
                startActivity(openMain);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //using a switch case to listen to each radio button and dependant on selection allocating the
        // units for that drink to the Answer variable
        switch (checkedId) {
            case R.id.rbBeer:
                Answer.setText("2");
                break;
            case R.id.rbBeer5:
                Answer.setText("2");
                break;
            case R.id.rbCider:
                Answer.setText("3");
                break;
            case R.id.rbWine:
                Answer.setText("2");
                break;
            case R.id.rbSpirits:
                Answer.setText("1");
                break;
            case R.id.rbPops:
                Answer.setText("1");
                break;
        }

    }
    //units method called above
        public void units() {
            //declaring input 1 by getting the data from answer (above) parsing the int to string and saving to input1
            int input1 = Integer.parseInt(Answer.getText().toString());
            //declaring input 1 by getting the data from answer (above) parsing the int to string and saving to input1
            int input2= Integer.parseInt(input.getText().toString());
            //creating an instance of the Drink Calculations class to link them and use the methods
            calcs = new DrinkCalculations(input1, input2);
            //setting final answer to the allocated object in the activity using the instance of calcs and this method to calculate
            //then displaying out the answer + the message in ""
            finalAnswer.setText(Integer.toString(calcs.units())+ " Units."  + "\n" + "Recommended daily Units for a woman 2-3 and man 3-4");

        }
    }
