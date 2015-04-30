package com.example.drinksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Useful extends ActionBarActivity {
    //declaring button variable
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set page to activity_useful to open
        setContentView(R.layout.activity_useful);
        //call buttonSetUp method below
        buttonSetUp();
        //setting textviews up to be hyperlinks
        TextView west = (TextView) findViewById(R.id.tvWestCheshire);
        west.setMovementMethod(LinkMovementMethod.getInstance());
        TextView nhs = (TextView) findViewById(R.id.tvNhs);
        nhs.setMovementMethod(LinkMovementMethod.getInstance());
        TextView drinkaware = (TextView) findViewById(R.id.tvDrinkaware);
        drinkaware.setMovementMethod(LinkMovementMethod.getInstance());
        TextView concern = (TextView) findViewById(R.id.tvConcern);
        concern.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void buttonSetUp() {
        //linking button in activity page to variable above
        home = (Button) findViewById(R.id.btnHome);
        //setting on click listener for button to do something when clicked
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(Useful.this, "You clicked the Main Menu Button", Toast.LENGTH_SHORT).show();
                //dclaring the intent from the manifest and assigning it to mainmenu
                Intent mainmenu = new Intent("com.example.drinksafe.MAIN");
                //starting the intent created
                startActivity(mainmenu);
            }
        });
    }
}