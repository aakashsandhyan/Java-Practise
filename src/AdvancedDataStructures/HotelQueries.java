package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HotelQueries {
    private int size;
    int[] tree;
    int N;
    int COUNT;
    int height;

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    private HotelQueries(String[] arr, int n){

        while(!isPowerOfTwo(n)){
            n++;
        }

        N = n;

        COUNT = 10;

        height = (int) (Math.log(N) / Math.log(2));

        this.size = n * 2;
        this.tree = new int[size];
        //buidling tree
        for(int i = 0; i < arr.length; i++){
            tree[n + i] = Integer.valueOf(arr[i]);
        }

        for(int i = n - 1; i >= 1; i--){
            tree[i] = Math.max(tree[2 * i], tree[(2 * i) + 1]);
        }

//        System.out.println();
//        Arrays.stream(tree).forEach(x -> System.out.print(x + "\t"));
//        System.out.println();
    }

    private int getRoom(int node, int query, int left, int right){
        if(node >= N){
            return node;
        }

        int leftChild = tree[node * 2];
//        int rightChild = tree[node * 2 + 1];
//        System.out.println(left + " " + right + " " + leftChild + " "+ node + " " + rightChild);
        int mid = (left + right) / 2;
        if(leftChild >= query){
            return getRoom(node * 2, query, left, mid);
        }
        else{
            return getRoom(node * 2 + 1, query, mid + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        int n = input.get(0);

        String[] arr = br.readLine().split(" ");
        HotelQueries segmentTree = new HotelQueries(arr, n);
//        segmentTree.printSegmentTree();
        List<Integer> queries = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        PrintWriter out = new PrintWriter(System.out);
        for(Integer query : queries){
            int room = 0;
            if(segmentTree.tree[1] >= query){
                room = segmentTree.getRoom(1, query, 0,  n - 1);
                segmentTree.update(room, query);
                room = room + 1 - segmentTree.N;
            }
            out.print(room + "\n");
        }
        out.flush();
    }

    private void update(int room, Integer query) {
        tree[room] = tree[room] - query;
//        System.out.println("room: " + room +"  rooms: " + tree[room]);
        while(room > 1){
            room = room / 2;
            tree[room] = Math.max(tree[room * 2], tree[room * 2 + 1]);
        }
    }
}
