package pl.edu.wszib.multithreading;

import lombok.SneakyThrows;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        /*System.out.println(Thread.currentThread().getName());
        Counter.start(10);
        Counter.start(5, "2");

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new Counter(20));
        executorService.execute(new Counter(30));
        executorService.execute(new Counter(40));
        executorService.execute(new Counter(50));*/

        ExecutorService executorService = Executors.newFixedThreadPool(16);

        List<FactorialCalculator> calculators = Stream.iterate(0, integer -> integer + 1)
                .limit(10000)
                .map(FactorialCalculator::new)
                .toList();

        executorService.invokeAll(calculators)
                .stream()
                .map(bigIntegerFuture -> {
                    try {
                        return bigIntegerFuture.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(System.out::println);

        executorService.shutdown();
    }
}
