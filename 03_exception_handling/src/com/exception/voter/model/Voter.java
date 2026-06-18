package com.exception.voter.model;

import com.exception.voter.exceptions.InvalidAgeException;

public class Voter {
    int age;
    String name;

    public Voter(int age, String name) {
        if(age < 18){
            throw new InvalidAgeException(age);
        }
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18){
            throw new InvalidAgeException(age);
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
