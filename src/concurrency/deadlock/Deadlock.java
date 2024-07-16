package concurrency.deadlock;

public class Deadlock {

    public static void main(String[] args) throws InterruptedException {

        A obj = new A();

        Runnable runnable1 = () -> obj.a();
        Runnable runnable2 = () -> obj.b();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
