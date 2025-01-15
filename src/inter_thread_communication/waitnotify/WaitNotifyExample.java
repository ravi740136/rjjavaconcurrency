package inter_thread_communication.waitnotify;
public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                shared.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> shared.consume());

        producer.start();
        consumer.start();
    }
}