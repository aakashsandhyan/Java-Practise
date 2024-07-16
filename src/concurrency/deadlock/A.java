package concurrency.deadlock;

public class A {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    public void a(){
        synchronized (key1){
            System.out.println("Inside method a : thread: " + Thread.currentThread().getName());
            b();
        }
    }

    public void b() {
        synchronized (key2){
            System.out.println("Inside method b : thread: " + Thread.currentThread().getName());
            c();
        }
    }

    private void c() {
        synchronized (key1){
            System.out.println("Inside method c : thread: " + Thread.currentThread().getName());
        }
    }
}
