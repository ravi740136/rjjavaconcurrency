package synchronization;
public class PartialSynchronizationWithSharedResource {
    public static void main(String[] args) {
        // Create shared resource
        SharedResource sharedResource = new SharedResource();

        // Create thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is preparing to increment...");
                sharedResource.increment();
                System.out.println(Thread.currentThread().getName() + " has finished incrementing.");
            }
        });

        // Create thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is preparing to increment...");
                sharedResource.increment();
                System.out.println(Thread.currentThread().getName() + " has finished incrementing.");
            }
        });

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final counter value
        System.out.println("Final counter value: " + sharedResource.getCounter());
    }
}