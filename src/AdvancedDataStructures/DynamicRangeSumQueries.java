package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicRangeSumQueries {
    private int size;
    long[] tree;
    int N;

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    private DynamicRangeSumQueries(String[] arr, int n){

        while(!isPowerOfTwo(n)){
            n++;
        }

        N = n;
        this.size = n * 2;
        this.tree = new long[size];
        //buidling tree
        for(int i = 0; i < arr.length; i++){
            tree[n + i] = Integer.valueOf(arr[i]);
        }

        for(int i = n - 1; i >= 1; i--){
            tree[i] = tree[2 * i] + tree[(2 * i) + 1];
        }

//        System.out.println();
//        Arrays.stream(tree).forEach(x -> System.out.print(x + "\t"));
//        System.out.println();
    }

    private void update(int k, int val){
        long diff = val - tree[N + k - 1];
        int pos = N + k - 1;
        while(pos != 0){
            tree[pos] = tree[pos] + diff;
            pos = pos / 2;
        }
    }

    private long getRangeSum(int node, int left, int right, int node_low, int node_high){
        if(left <= node_low && right >= node_high){
            return tree[node];
        }

        if(right < node_low || left > node_high ){
            return 0;
        }

        int mid = (node_low + node_high) / 2;
        return getRangeSum(2 * node, left, right, node_low, mid)
                + getRangeSum(2 * node + 1, left, right, mid + 1, node_high);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        int n = input.get(0);
        int q = input.get(1);

        String[] arr = br.readLine().split(" ");
        DynamicRangeSumQueries segmentTree = new DynamicRangeSumQueries(arr, n);
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 0; i < q; i++) {
            arr = br.readLine().split(" ");
            int type = Integer.valueOf(arr[0]);
            int left = Integer.valueOf(arr[1]);
            int right = Integer.valueOf(arr[2]);
            if(type == 2){
                out.print(segmentTree.getRangeSum(1, left - 1, right - 1, 0, n - 1) + "\n");
            }
            else{
                segmentTree.update(left, right);
            }
        }
        out.flush();

    }
}
