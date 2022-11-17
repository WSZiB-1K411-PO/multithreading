package pl.edu.wszib.multithreading;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Producer implements Runnable {
    private final Store store;

    @Override
    public void run() {
        while (true) {
            int number = getNumber();
            System.out.println(Thread.currentThread().getName() + " produced: " + number);
            store.store(number);
        }
    }

    private int getNumber() {
        return ThreadLocalRandom.current().nextInt(10, 21);
    }
}
