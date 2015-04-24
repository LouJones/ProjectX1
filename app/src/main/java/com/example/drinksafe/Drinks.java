package com.example.drinksafe;

/**
 * Created by Louise on 31/03/2015.
 */
public class Drinks {
    public int ID;
    public String Drink;
    public Double Units;

    public Drinks() {
    }

    @Override
    public String toString() {
                    return "Drinks [_id=" + ID
                    + ",Drink=" + Drink
                    + ",Units=" + Units
                    +  "]";
        }

    }