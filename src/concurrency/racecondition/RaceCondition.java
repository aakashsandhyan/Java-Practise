package concurrency.racecondition;

import java.util.stream.IntStream;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
         LongWrapper longWrapper = new LongWrapper(0);

         Runnable runnable = () -> {
             for(int i = 0; i < 1000; i = i + 1){
                 longWrapper.incrementValue();
             }
         };

        Thread[] threads = new Thread[1000];
        IntStream.range(0, 1000).forEach(i -> {
            threads[i] = new Thread(runnable);
            threads[i].start();
        });

        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }

        System.out.println(longWrapper.getL());
    }
}
