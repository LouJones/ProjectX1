package com.example.drinksafe;

/**
 * Created by Louise on 26/04/2015.
 */
public class Name {
    //declaring variables to be used in class
    private int _id;
    private String _name;
    private String _emailadd;

    public Name(){

    }
    public Name(int id, String name, String emailadd){
        //within this class and assigning name including the id
        this._id = id;
        this._name = name;
        this._emailadd = emailadd;

    }
   public Name(String name, String emailadd){
       //declaring both string to declared variables
       this._name = name;
       this._emailadd = emailadd;

   }
    public void setID(int id){
        this._id = id;

    }
    public int getID(){
        return this._id;
    }
    public void setDay(String name){
        this._name = name;
    }
    public String getName(){
        return this._name;

    }
    public void setEmailAdd(String emailadd){
        this._emailadd = emailadd;
    }
    public String getEmailAdd(){
        return this._emailadd;
    }
}
