package com.example.drinksafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


    public class MainActivity extends Activity {
    ImageButton ibtnYou, ibtnContacta, ibtnNhsa, ibtnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinkCalc();
        healthVid();
        youT();
        contact();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void drinkCalc() {
        // TODO Auto-generated method stub
        //allocating btnGravity to previously named ibtnGravity in xml
        ibtnCalculate = (ImageButton) findViewById(R.id.ibtnCalc);
        //setting on click listener for button to do something when clicked
        ibtnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(MainActivity.this, "You clicked the  Calculate Drink Units button", Toast.LENGTH_SHORT).show();
              Intent drinkCalc = new Intent("com.example.drinksafe.DRINKCALC");
                startActivity(drinkCalc);
            }
        });

    }
    private void healthVid() {
        // TODO Auto-generated method stub
        //allocating btnGravity to previously named ibtnGravity in xml
        ibtnNhsa = (ImageButton) findViewById(R.id.ibtnNhs);
        //setting on click listener for button to do something when clicked
        ibtnNhsa.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(MainActivity.this, "You clicked the NHS website button", Toast.LENGTH_SHORT).show();
                Intent health = new Intent("com.example.drinksafe.USEFUL");
                startActivity(health);
            }
        });

    }
    private void youT() {
        // TODO Auto-generated method stub
        //allocating btnGravity to previously named ibtnGravity in xml
        ibtnYou = (ImageButton) findViewById(R.id.ibtnYoutube);
        //setting on click listener for button to do something when clicked
        ibtnYou.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(MainActivity.this, "You clicked the YouTube button", Toast.LENGTH_SHORT).show();
                Intent you = new Intent("com.example.drinksafe.YOUTUBE");
                startActivity(you);
            }
        });

    }
    private void contact() {
        // TODO Auto-generated method stub
        //allocating btnGravity to previously named ibtnGravity in xml
        ibtnContacta = (ImageButton) findViewById(R.id.ibtnContact);
        //setting on click listener for button to do something when clicked
        ibtnContacta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(MainActivity.this, "You clicked the Contact us button", Toast.LENGTH_SHORT).show();
                Intent contactus = new Intent("com.example.drinksafe.CONTACTUS");
                startActivity(contactus);
            }
        });

    }

}
