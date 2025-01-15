package advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int task = i;
            executor.submit(() -> {
                System.out.println("Task " + task + " is running on " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
