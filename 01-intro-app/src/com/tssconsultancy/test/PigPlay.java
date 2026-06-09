package com.tssconsultancy.test;

import java.util.Random;
import java.util.Scanner;

public class PigPlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int turn = 0;
        int score = 0;

        while(score < 20 ){
            int currScore = 0;
            System.out.println("\n\nTURN "+(turn+1));

            while(true){
                char choice;
                do{
                    System.out.print("Roll or hold? (r/h) : ");
                    choice = scanner.next().toLowerCase().charAt(0);
                }while(choice != 'r' && choice != 'h');

                if(choice == 'r'){
                    int rolldedNumber  = random.nextInt(6) + 1;
                    System.out.println("Die: "+rolldedNumber);

                    if(rolldedNumber == 1){
                        currScore = 0;
                        System.out.println("Turn Over");
                        break;
                    }else{
                        currScore += rolldedNumber;
                    }
                }else{
                    score += currScore;
                    System.out.println("Score in this turn : " + currScore);
                    System.out.println("Total Score : " + score);
                    break;

                }
            }

            turn++;

        }

        System.out.println("You finished in " + (turn) + " turns");
    }
}
