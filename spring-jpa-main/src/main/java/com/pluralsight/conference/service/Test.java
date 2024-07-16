import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {5, 8, 2, 1, 9};
        int[] array2 = {4, 3, 7, 6, 10};
        int k = 3;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        // Push elements from array1 into pq1
        for(int i = 0; i < array1.length; i++){
            if(pk.size() == 3){

            }
            else{
                pq1.offer(num);
            }
        }
        for (int num : array1) {
            pq1.offer(num);
        }
        
         */

        // Push elements from array2 into pq2
        for (int num : array2) {
            pq2.offer(num);
        }

        // Printing elements of pq1
        System.out.println("Elements of pq1 (Min Heap):");
        while (!pq1.isEmpty()) {
            System.out.print(pq1.poll() + " ");
        }
        System.out.println();

        // Printing elements of pq2
        System.out.println("Elements of pq2 (Min Heap):");
        while (!pq2.isEmpty()) {
            System.out.print(pq2.poll() + " ");
        }
        System.out.println();
    }
}
