package com.tssconsultancy.test;

import java.util.Random;
import java.util.Scanner;


public class GuessTheNumber {
    public static void main(String[] args) {

        int randomNumber = new Random().nextInt(1, 101);
        int attempts = 0;

        System.out.println("Generated Random Number is between 0 to 101");

        Scanner scanner = new Scanner(System.in);

        while (attempts < 5){
            System.out.print("\n\nGuess the Number : ");
            int guessedNumber = scanner.nextInt();

            if(guessedNumber == randomNumber){
                System.out.println("Yehh! you won the game in " + (attempts + 1) + " attempts");
                break;
            }else{
                if(guessedNumber < randomNumber){
                    System.out.println("Sorry, Too Small");
                }else{
                    System.out.println("Sorry, Too large");
                }
            }

            attempts++;
            System.out.println("Remaining attempt : " + (5 - attempts));

            if(attempts == 5){
                System.out.println("\n\nSorry, You lost!! better luck next time");
                System.out.println("Random number : "+ randomNumber);

            }
        }

    }

}
