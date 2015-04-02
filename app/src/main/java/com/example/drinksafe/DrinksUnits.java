package com.example.drinksafe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Louise on 30/03/2015.
 */
public class DrinksUnits {
    //name of first row
    public static final String KEY_ROWID = "_id";
    //name of second row
    public static final String KEY_DRINK = "drink_name";
    //third name of row
    public static final String KEY_UNITS = "drink_units";
    //database name
    private static final String DATABASE_NAME = "DrinkAndUnits";
    //table name
    public static final String DATABASE_TABLE = "drinkTable";
    //database version
    private static final int DATABASE_VERSION = 1;
    //creating and instance of the DBHelp class
    private DbHelp databasehelp;
    //contaxt for the class
    private final Context ourContext;
    //
    private SQLiteDatabase newDatabase;


    private static class DbHelp extends SQLiteOpenHelper{


        public DbHelp(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //CREATING TABLE AND COLUMNS ASKING ID TO AUTOINCREMENT
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_DRINK + " TEXT NOT NULL, " +
                            KEY_UNITS + " TEXT NOT NULL);"
            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
//constructor for public class
    public DrinksUnits (Context a){
        ourContext = a;
    }
    // open database through helper created
    public DrinksUnits open(){
        databasehelp = new DbHelp(ourContext);
        newDatabase = databasehelp.getWritableDatabase();
        return this;
    }
    //closing the database
    public void close(){
        databasehelp.close();
    }
}
