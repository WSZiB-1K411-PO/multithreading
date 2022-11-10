package pl.edu.wszib.multithreading;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class FactorialCalculator implements Callable<BigInteger> {
    private final long number;

    @Override
    public BigInteger call() {
        return factorial(BigInteger.valueOf(number));
    }

    private BigInteger factorial(BigInteger number) {
        if(number.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        }

        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }
}
