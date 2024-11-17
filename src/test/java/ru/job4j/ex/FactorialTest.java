package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Factorial f = new Factorial();
                    f.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void when2Then() {
        int expected = 6;
        Factorial f = new Factorial();
        int result = f.calc(3);
        assertThat(result).isEqualTo(expected);
    }
}