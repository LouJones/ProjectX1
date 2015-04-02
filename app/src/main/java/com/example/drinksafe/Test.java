package com.example.drinksafe;

/**
 * Created by Louise on 31/03/2015.
 */
public class Test {
    public int _id;
    public String drink_name, female_units, male_units;

    public Test() {
    }

    @Override
    public String toString() {
                    return "drinkTable [id=" + _id
                    + ",drink_name=" + drink_name
                    + ",female_units=" + female_units
                    + ",male_units=" + male_units + "]";
        }

    }