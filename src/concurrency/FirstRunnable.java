package concurrency;

public class FirstRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("I'm running thread: " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.setName("my current thread");
        thread.start();
    }
}
