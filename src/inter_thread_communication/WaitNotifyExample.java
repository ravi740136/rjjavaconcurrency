package inter_thread_communication;
public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                shared.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> shared.consume());

        producer.start();
        consumer.start();
    }
}