package advanced;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 working...");
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2 working...");
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
