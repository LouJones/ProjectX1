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
    private static final String DATABASE_NAME = "productDB.db";
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_UNITS = "units";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE" +
                TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY, +COLUMN_DAY"
                + " TEXT, " + COLUMN_UNITS + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Product product) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_DAY, product.get_Day());
        values.put(COLUMN_UNITS, product.getUnits());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    public Product findProduct(String day) {
        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_DAY + " =  \"" + day + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setDay(cursor.getString(1));
            product.setUnits(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }
    public boolean deleteProduct(String day) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_DAY + " =  \"" + day + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Product product = new Product();

        if (cursor.moveToFirst()) {
            product.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(product.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
