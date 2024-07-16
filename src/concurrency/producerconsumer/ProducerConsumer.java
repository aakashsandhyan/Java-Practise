package concurrency.producerconsumer;

public class ProducerConsumer {

    private static final Object lock = new Object();

    private static int[] buffer = new int[10];
    private static int count = 0;

    public static class Producer{

        void produce() throws InterruptedException {
            synchronized (lock){
                if(isFull()){
                    lock.wait();
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }

    public static class Consumer{

        void consume() throws InterruptedException {

            synchronized (lock){
                if(isEmpty()){
                    lock.wait();
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable producerTask = () -> {
            for (int x = 0; x < 50; x++) {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        };

        Runnable consumerTask = () -> {
            for (int x = 0; x < 45; x++) {
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        };

        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("count :" + count);
    }

    public static boolean isFull(){
        return count == buffer.length;
    }
    public static boolean isEmpty(){
        return count == 0;
    }
}
