package pl.edu.wszib.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        /*ExecutorService executorService = Executors.newFixedThreadPool(16);

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

        executorService.shutdown();*/

        ExecutorService executorService = Executors.newFixedThreadPool(16);

        /*Stream.iterate(0, i -> i + 1)
                .limit(10000)
                .forEach(i -> executorService.submit(new Adder()));

        executorService.shutdown();
        TimeUnit.SECONDS.sleep(5);

        System.out.println();
        System.out.println(Adder.count);*/

        /*new Thread(new DeadLock.First()).start();
        new Thread(new DeadLock.Second()).start();*/

        Store store = new Store(1000);

        new Thread(new Producer(store), "Producer1").start();
        new Thread(new Producer(store), "Producer1").start();
        new Thread(new Consumer(store), "Consumer1").start();
        //new Thread(new Consumer(store), "Consumer2").start();
        //new Thread(new Consumer(store), "Consumer3").start();
    }
}
