package pl.edu.wszib.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private final Queue<Integer> queue = new LinkedList<>();
    private Lock storeLock = new ReentrantLock();
    private final int capacity;

    public Store(int capacity) {
        this.capacity = capacity;
    }

    public void store(int number) {
        synchronized (queue) {
            if(queue.size() > capacity) {
                storeLock.lock();
            }

            queue.offer(number);
            System.out.println("Store size: " + queue.size());
        }
    }

    public Integer get() {
        Integer poll = queue.poll();
        synchronized (queue) {
            storeLock.unlock();
            return poll;
        }
    }
}
