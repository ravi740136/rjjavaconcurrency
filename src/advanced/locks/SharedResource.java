package advanced.locks;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedCounter = 0;

    public void performTask(String threadName, int iterations) {
        for (int i = 0; i < iterations; i++) {
          lock.lock(); // Acquire the lock
            try {
                sharedCounter++;
                System.out.println(threadName + " incremented counter to: " + sharedCounter);
                // Simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
                System.out.println(threadName + " was interrupted.");
            } finally {
              lock.unlock(); // Release the lock
            }
        }
    }
    
    public void performTask2(String threadName, int iterations) {
        lock.lock(); // Acquire the lock before the loop
        try {
            for (int i = 0; i < iterations; i++) {
                sharedCounter++;
                System.out.println(threadName + " incremented counter to: " + sharedCounter);
                Thread.sleep(100); // Simulate some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(threadName + " was interrupted.");
        } finally {
            lock.unlock(); // Release the lock after completing the loop
        }
    }

}