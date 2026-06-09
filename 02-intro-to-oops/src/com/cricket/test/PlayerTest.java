package com.cricket.test;

import com.cricket.entity.Player;

import java.util.Scanner;

public class PlayerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        int id, runs, wickets, matches;
        System.out.print("Enter name of the player : ");
        while(true){
            name = scanner.next();
            break;
        }

        System.out.print("Enter Id of the player : ");
        id = scanner.nextInt();

        System.out.print("Enter runs of the player : ");
        runs = scanner.nextInt();

        System.out.print("Enter wickets of the player : ");
        wickets = scanner.nextInt();

        System.out.print("Enter matches of the player : ");
        matches = scanner.nextInt();

        Player p1 = new Player(id, name, matches, runs, wickets);
        p1.displayPlayer();

        System.out.println("Average run" + p1.calculateAverage());

    }
}
