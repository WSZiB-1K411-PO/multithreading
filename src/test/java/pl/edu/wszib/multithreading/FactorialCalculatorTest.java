package pl.edu.wszib.multithreading;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCalculatorTest {

    public static List<Arguments> getFactorialTestArguments() {
        return List.of(
                Arguments.of(0, BigInteger.valueOf(1)),
                Arguments.of(1, BigInteger.valueOf(1)),
                Arguments.of(2, BigInteger.valueOf(2)),
                Arguments.of(3, BigInteger.valueOf(6)),
                Arguments.of(4, BigInteger.valueOf(24)),
                Arguments.of(5, BigInteger.valueOf(120))
        );
    }

    @ParameterizedTest
    @MethodSource("getFactorialTestArguments")
    void shouldCalculateFactorial(long number, BigInteger factorial) {
        //given
        FactorialCalculator factorialCalculator = new FactorialCalculator(number);

        //when
        BigInteger result = factorialCalculator.call();

        //then
        assertEquals(result, factorial);
    }
}