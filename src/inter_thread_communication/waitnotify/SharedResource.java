package inter_thread_communication.waitnotify;
class SharedResource {
    private int data;
    private boolean isProduced = false;

    // Producer method
    //here we are not handling the exception for wait method and using throws clause
    public synchronized void produce() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            while (isProduced) {
                // Wait if data is already produced
                wait();
            }
            data = i; // Producing data
            System.out.println("Produced: " + data);
            isProduced = true;
            notify(); // Notify the consumer
        }
    }

    // Consumer method
    public synchronized void consume() {
        for (int i = 1; i <= 5; i++) {
            try {
                while (!isProduced) {
                    // Wait if data is not yet produced
                    wait();
                }
                System.out.println("Consumed: " + data);
                isProduced = false;
                notify(); // Notify the producer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}