package pl.edu.wszib.multithreading;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Consumer implements Runnable {
    private final Store store;

    @Override
    public void run() {
        while (true) {
            Integer number = store.get();
            System.out.println(Thread.currentThread().getName() + " consumed: " + number);
        }
    }
}
