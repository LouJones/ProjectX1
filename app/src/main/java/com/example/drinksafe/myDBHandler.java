package com.example.drinksafe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Louise on 26/04/2015.
 */
public class myDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "nameDB.db";
    public static final String TABLE_NAMES = "names";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAILADD = "emailadd";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NAMES_TABLE = "CREATE TABLE" +
                TABLE_NAMES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY, + COLUMN_NAME"
                + " TEXT, " + COLUMN_EMAILADD + " TEXT" + ")";
        db.execSQL(CREATE_NAMES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMES);
        onCreate(db);
    }

    public void addName(Name name) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name.getName());
        values.put(COLUMN_EMAILADD, name.getEmailAdd());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_NAMES, null, values);
        db.close();
    }


}
