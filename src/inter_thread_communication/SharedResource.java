package inter_thread_communication;

class SharedResource {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producing...");
        wait();
        System.out.println("Resumed production...");
    }

    synchronized void consume() {
        System.out.println("Consuming...");
        notify();
    }
}