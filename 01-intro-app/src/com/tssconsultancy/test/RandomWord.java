package com.tssconsultancy.test;

import java.util.Random;
import java.util.Scanner;

public class RandomWord {
    public static void main(String[] args) {
        String[] wordsArray = {"apple", "banana", "coffee", "swamaan", "developer", "eclipse", "java"};

        Random random = new Random();
        String randomWord = wordsArray[random.nextInt(wordsArray.length)];

        char[] guessedWord = new char[randomWord.length()];

        for(int i = 0; i < guessedWord.length; i++){
            guessedWord[i] = '_';
        }

        int lives = 6;
        Scanner scanner = new Scanner(System.in);

        while(lives > 0){
            System.out.println("\nWord: ");
            for(char c : guessedWord){
                System.out.print(c + " ");
            }

            System.out.println("\nRemaining Lives : " + lives);
            System.out.print("Guess the letter : ");
            char guessedChar = scanner.next().toLowerCase().charAt(0);

            boolean found = false;

            for(int i = 0; i < randomWord.length(); i++){
                if(randomWord.charAt(i) == guessedChar){
                    guessedWord[i] = guessedChar;
                    found = true;
                }
            }

            if(found){
                System.out.println("Correct Guess!");
            }else{
                lives--;
                System.out.println("Incorrect Guess!");
            }

            boolean completed = true;
            for(int i = 0; i < guessedWord.length; i++){
                if(guessedWord[i] == '_'){
                    completed = false;
                    break;
                }
            }

            if(completed){
                System.out.println("congratulations!!! You have guessed the word");
                break;
            }
        }

        if(lives == 0){
            System.out.println("\nYou ran out of moves");
            System.out.println("The word was : " + randomWord);
        }
    }
}
