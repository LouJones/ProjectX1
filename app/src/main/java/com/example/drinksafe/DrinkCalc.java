package com.example.drinksafe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class DrinkCalc extends ActionBarActivity {
    Button home;
    /*Spinner spDrink, spQuantity;
    //The Android's default system path of your application database.
    private static String DB_PATH="data/data/package com.example.drinksafe/databases/";
    private static String DB_NAME = "DrinksUnitsCal";
    private static String TABLE_LOCATION = "drinks";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_calc);

       /* spDrink = (Spinner) findViewById(R.id.spDrink);
        spQuantity= (Spinner) findViewById(R.id.spQuantity);
        spDrink.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        spQuantity.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);*/
        Buttons();
        // Loading spinner data from database
       /* loadSpinnerData();
        getDrinks();*/



        }


    /*private void loadSpinnerData() {

        // database handler
        com.example.drinksafe.DatabaseHelp db = new com.example.drinksafe.DatabaseHelp(getApplicationContext());

        // Spinner Drop down elements
        List<String> drinks = db.getDrinks();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, drinks);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spDrink.setAdapter(dataAdapter);
    }
    // Get drinks
    public static List<Drinks> getDrinks() {

        List<Drinks> drinks = null;

        try {

            String      query  = "SELECT * FROM " + TABLE_LOCATION;
            SQLiteDatabase  db    = SQLiteDatabase.openDatabase( DB_PATH + DB_NAME , null, SQLiteDatabase.OPEN_READWRITE);
            Cursor cursor  = db.rawQuery(query, null);

            // go over each row, build elements and add it to list
            drinks = new LinkedList<Drinks>();

            if (cursor.moveToFirst()) {
                do {

                    Drinks Drinks  = new Drinks();
                    Drinks.ID      = Integer.parseInt(cursor.getString(0));
                    Drinks.Drink    = cursor.getString(1);
                    Drinks.Units    = Double.parseDouble(cursor.getString(2));

                    drinks.add(Drinks);

                } while (cursor.moveToNext());
            }
        } catch(Exception e) {
            // sql error
        }

        return drinks;
    }*/

    private void Buttons() {
        home = (Button) findViewById(R.id.btnHome);
        //setting on click listener for button to do something when clicked
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(DrinkCalc.this, "You clicked the  Calculate Drink Units button", Toast.LENGTH_SHORT).show();
                Intent menu = new Intent("com.example.drinksafe.MAIN");
                startActivity(menu);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drink_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}