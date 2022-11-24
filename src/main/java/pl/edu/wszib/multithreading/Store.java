package pl.edu.wszib.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private final Queue<Integer> queue = new LinkedList<>();

    private final Object storeLock = new Object();
    private final Object getLock = new Object();

    private final int capacity;

    public Store(int capacity) {
        this.capacity = capacity;
    }

    public void store(int number) {
        synchronized (storeLock) {
            if (queue.size() >= capacity) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    storeLock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            synchronized (getLock) {
                synchronized (queue) {
                    queue.offer(number);
                    System.out.println("Store size: " + queue.size());
                }
                getLock.notify();
            }
        }
    }

    public Integer get() {
        synchronized (getLock) {
            if (queue.size() <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    getLock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        synchronized (storeLock) {
            synchronized (queue) {
                Integer poll = queue.poll();
                storeLock.notify();

                return poll;
            }
        }
    }
}
