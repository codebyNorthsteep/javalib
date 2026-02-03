package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void addTwoNumbersReturnsSum() {
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void addThreeNumbersReturnSum() {
        int result = Calculator.add(1, 2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void addMultipleNumbersReturnSum() {
        int result = Calculator.add(1, 2, 3, 4);
        assertThat(result).isEqualTo(10);
    }

}