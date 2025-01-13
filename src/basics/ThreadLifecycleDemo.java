package basics;

public class ThreadLifecycleDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycleDemo thread = new ThreadLifecycleDemo();
        System.out.println("Thread state: " + thread.getState());
        thread.start();
        System.out.println("Thread state after start(): " + thread.getState());
        thread.join();
        System.out.println("Thread state after completion: " + thread.getState());
    }
}
