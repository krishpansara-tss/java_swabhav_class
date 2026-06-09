package com.tssconsultancy.array;

import java.util.Scanner;

public class CharShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true){
            System.out.print("Enter String : ");
            if(scanner.hasNext()){
                str = scanner.next();
                break;
            }else{
                System.out.println("Please enter the valid input (String)");
                scanner.next();
            }
        }

        int n;
        while(true){
            System.out.print("Enter the value of shift : ");
            if(scanner.hasNextInt()){
                n = scanner.nextInt();
                break;
            }else{
                System.out.println("Please enter the valid input (Inteeger)");
                scanner.next();
            }
        }


        System.out.println(str);
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if(Character.isLowerCase(ch)){
                arr[i] = (char) ('a' + ((ch - 'a' + n + 26)) % 26);
            }else{
                arr[i] = (char) ('A' + ((ch - 'A' + n + 26)) % 26);
            }
        }

        System.out.println(new String(arr));
    }
}
