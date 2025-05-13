/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberguesinggame;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author lab_services_student
 */
public class NumberGuesingGame {

    public static void main(String[] args) {
        //Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        //Create a Random object to generate a random number
        Random random = new Random();
        //Generate a random number betweeen 1 and 100 (inclusive)
        
        int numberToGuess = random.nextInt(100)+1;
        //Counter to keep track of the numberof the guesses the user makes 
        
        int numberOfTries = 0;
        
        //Variable to store the user's guess
        int guess;
        
        //boolean flag to determine if the user has guessed correctly 
        boolean hasWon = false;
        
        //wlecome message to the user 
        System.out.println("Welcome to the guessing game!");
        System.out.println("I Have Selected a anumber between 1 and 100 can you guess the correct number");
        
        //loop continues  until the user guesses the correct number 
        while (!hasWon){
            //prompt the user to enter a guess
            System.out.println("Enter your guess");
            
            //read the guess
            guess = scanner.nextInt();
            //increment the number of tries 
            numberOfTries++;
            
            //Check if the guess is lowe than the targeted number 
            if (guess<numberToGuess){
                System.out.println("Thats low :( ,try higher .");
                
            }
            //Check if the number is higher then the wanted number 
            else if (guess>numberToGuess){
                System.out.println("Thats a bit too high :( ,try going lower");
                
            }
            //if the guess is correct print the results 
            else{
                //set flag to true to exit loop
                hasWon = true; 
                System.out.println("You guessed correctly:), Congratulatiins! " + "You gueesed the number in " + numberOfTries + " tries");
            }
        }
        
        
    }
}
