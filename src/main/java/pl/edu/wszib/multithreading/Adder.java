package pl.edu.wszib.multithreading;

public class Adder implements Runnable {
    public static Integer count = 0;
    public static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            count += 1;
            System.out.println(count);
        }
    }
}
