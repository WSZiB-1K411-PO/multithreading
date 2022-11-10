package pl.edu.wszib.multithreading;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Counter implements Runnable {
    private final int count;

    @Override
    @SneakyThrows
    public void run() {
        for (int i = count; i >= 0;i--) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            Thread.sleep(1000);
        }
    }

    public static void start(int count) {
        new Thread(new Counter(count)).start();
    }

    public static void start(int count, String threadName) {
        new Thread(new Counter(count), threadName).start();
    }
}
