package com.aula.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {
    Calculator calculator;
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        //Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
    @Test
    void subtract_basic() {
        assertEquals(2, calculator.subtract(5,3));
    }

    @Test
    void multiply_zero() {
        assertEquals(0, calculator.multiply(0,99));
    }

    @Test
    void divide_integerAndZeroGuard() {
        assertEquals(3, calculator.divide(7,2));
        assertThrows(ArithmeticException.class, () -> calculator.divide(10,0));
    }
}