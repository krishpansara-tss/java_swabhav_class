package com.exception.voter.exceptions;

public class InvalidAgeException extends RuntimeException {
    private int age;
    public InvalidAgeException(int age) {
        this.age = age;
    }

    void displayMessage(){
        System.out.println("Your age must be more then 18.");
    }

}
