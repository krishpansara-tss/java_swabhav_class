package com.tsscosultancy.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;
    private Object ArithmeticException;

    @BeforeAll
    static void init(){
        calculator = new Calculator();
    }
    
    @Test
    void addition() {
        assertEquals(15, calculator.addition(5 , 10));
    }

    @Test
    void subtract() {
        assertEquals(-5, calculator.subtract(5 , 10));
    }

    @Test
    void multiply() {
        assertEquals(50, calculator.multiply(5 , 10));
    }

    @Test
    void division() {
        assertEquals(0,  calculator.division(0 , 10));
        assertEquals(1, calculator.division(10 , 10));
        assertThrows(ArithmeticException.class, () -> {
            calculator.division(1, 0);
        });
    }
}