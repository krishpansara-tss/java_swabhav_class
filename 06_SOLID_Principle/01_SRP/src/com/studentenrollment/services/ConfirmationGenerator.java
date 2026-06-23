package com.studentenrollment.services;

import java.util.Random;

public class ConfirmationGenerator {
    Random random = new Random();
    public String generateConfirmation(){
        return "CNF" + random.nextInt();
    }
}
