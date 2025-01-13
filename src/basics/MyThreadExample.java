package basics;

public class MyThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThreadExample thread1 = new MyThreadExample();
        thread1.start();
    }
}
