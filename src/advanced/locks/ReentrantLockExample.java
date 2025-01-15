package advanced.locks;
public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Each thread will increment the counter 5 times
        Thread t1 = new Thread(() -> sharedResource.performTask("Thread 1", 5));
        Thread t2 = new Thread(() -> sharedResource.performTask("Thread 2", 5));

        t1.start();
        t2.start();
    }
}