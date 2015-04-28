package com.example.drinksafe;

/**
 * Created by Louise on 26/04/2015.
 */
public class DrinkCalculations  {
    //private variables to be used in this class
    private int numOne=0;
    private int numTwo=0;
    private int result=0;

    public DrinkCalculations(int numA, int numB) {
        // setting NumOne and NumTwo
        setNumOne(numA);
        setNumTwo(numB);
    }

    //allocating values to attributes
    public void setNumOne(int num1){
        numOne=num1;
    }
    //allocating values to attributes
    public void setNumTwo(int num2){
        numTwo=num2;
    }

    //allocating values to attributes
    public int getNumOne(){
        return numOne;
    }
    //allocating values to attributes
    public int getNumTwo(){
        return numTwo;
    }

    //method to work out the result from calculations created
    public int units(){
        result=numOne*numTwo;
        return result;
    }
}
