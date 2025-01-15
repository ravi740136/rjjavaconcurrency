package synchronization;
// Shared Resource Class
class SharedResource {
    private int counter = 0; // Shared variable
    private final Object lock = new Object(); // Lock for synchronization

    // Method to increment the counter
    public void increment() {
        synchronized (lock) { // Synchronize only the critical section
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        }
    }

    // Method to get the counter value
    public int getCounter() {
        return counter;
    }
}