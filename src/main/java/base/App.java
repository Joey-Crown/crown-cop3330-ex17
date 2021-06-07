/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 first_name last_name
 */
package base;

import java.util.Scanner;

/* Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make
 a determination.

Create a program that prompts for your weight, gender, number of drinks, the amount of alcohol by volume of the drinks
 consumed (as a percent), and the amount of time since your last drink. Calculate your blood alcohol content (BAC)
 using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where

A = (number of drinks * alcohol by volume) is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output

Your BAC is 0.08
It is not legal for you to drive.

Constraint

Prevent the user from entering non-numeric values.

Challenges

Handle metric units.
Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.

*/
public class App 
{
    static double illegalBAC = 0.08;

    public static void main( String[] args )
    {
        Scanner number1 = new Scanner(System.in);
        Scanner string = new Scanner(System.in);
        Scanner number2 = new Scanner(System.in);
        Scanner number3 = new Scanner(System.in);
        Scanner number4 = new Scanner(System.in);


        // input weight
        System.out.print("What is your weight? ");
        int weight =  number1.nextInt();

        // input sex
        System.out.print("What is your sex? (M/W) ");
        String sex =  string.nextLine();

        // input number of drinks
        System.out.print("How many drinks have you had? ");
        int noOfDrinks =  number2.nextInt();

        // input alcohol by volume
        System.out.print("What is the alcohol by volume of the drink? (Enter as percent) ");
        double alcoholByVolume =  number3.nextDouble() / 100;

        // input hours since last drink
        System.out.print("How many hours since your last drink? ");
        int hours =  number4.nextInt();

        // calculate BAC
        double bloodAlcohol = calculateBloodAlcohol(weight, sex, noOfDrinks, alcoholByVolume, hours);

        // determine if your BAC is legal to drive
        if (bloodAlcohol >= illegalBAC) {
            System.out.printf("Your BAC is %.2f\n", bloodAlcohol);
            System.out.println("It is not legal for you to drive.");
        }
        if (bloodAlcohol < illegalBAC) {
            System.out.printf("Your BAC is %.2f\n", bloodAlcohol);
            System.out.println("It is legal for you to drive.");
        }

    }

    public static double calculateBloodAlcohol(int weight, String sex, int noOfDrinks, double alcoholByVolume, int hours) {

        double bloodAlcoholLevel = 0;

        // calculates BAC based on the provided gender
        if (sex.equals("M")) {
            bloodAlcoholLevel = ((noOfDrinks * alcoholByVolume) * 5.14) / (weight * 0.73);
            bloodAlcoholLevel = bloodAlcoholLevel - (0.015 * hours);
        }
        if (sex.equals("W")) {
            bloodAlcoholLevel = ((noOfDrinks * alcoholByVolume) * 5.14) / (weight * 0.66);
            bloodAlcoholLevel = bloodAlcoholLevel - (0.015 * hours);
        }
        if (bloodAlcoholLevel < 0) {
            bloodAlcoholLevel = 0;
        }

        // returns BAC to main
        return bloodAlcoholLevel;
    }

}
