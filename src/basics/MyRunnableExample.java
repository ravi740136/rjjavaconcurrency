package basics;

public class MyRunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnableExample());
        thread.start();
    }
}
