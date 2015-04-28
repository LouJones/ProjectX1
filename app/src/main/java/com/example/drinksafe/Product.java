package com.example.drinksafe;

/**
 * Created by Louise on 26/04/2015.
 */
public class Product {
    private int _id;
    private String _day;
    private int _units;

    public Product(){

    }
    public Product(int id, String day, int units){

    }
   public Product(String day, int units){
       this._day = day;
       this._units = units;

   }
    public void setID(int id){
        this._id = id;
    }
    public int getID(){
        return this._id;
    }
    public void setDay(String day){
        this._day = day;
    }
    public String get_Day(){
        return this._day;
    }
    public void setUnits(int units){
        this._units = units;
    }
    public int getUnits(){
        return this._units;
    }

}
