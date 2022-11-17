package pl.edu.wszib.multithreading;

public class DeadLock {
    private static final Object first = new Object();
    private static final Object second = new Object();

    public static class First implements Runnable {

        @Override
        public void run() {
            synchronized (first) {
                System.out.println("First::first");
                synchronized (second) {
                    System.out.println("First::second");
                }
            }
        }
    }

    public static class Second implements Runnable {

        @Override
        public void run() {
            synchronized (second) {
                System.out.println("Second::second");
                synchronized (first) {
                    System.out.println("Second::first");
                }
            }
        }
    }
}
