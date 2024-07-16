package AdvancedDataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Given an array of n integers, your task is to process q queries of the form: what is the minimum value in range [a,b]?
Input
The first input line has two integers n and q: the number of values and queries.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Finally, there are q lines describing the queries. Each line has two integers a and b: what is the minimum value in range [a,b]?
Output
Print the result of each query.
Constraints

1 \le n,q \le 2 \cdot 10^5
1 \le x_i \le 10^9
1 \le a \le b \le n

Example
Input:
8 4
3 2 4 5 1 1 5 3
2 4
5 6
1 8
3 3

Output:
2
1
1
4
 */

public class SparseTable {
    private static int MAX_SIZE = (int) (2 * 1e5);
    private static int LOG = 18;
    private static int[] bin_log = new int[MAX_SIZE];
    private static int[][] sparseTable = new int[MAX_SIZE][LOG + 1];

    static {
        bin_log[1] = 0;
        for(int i = 2; i < MAX_SIZE; i++){
            bin_log[i] = bin_log[i / 2] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.valueOf(input[0]);
        int q = Integer.valueOf(input[1]);
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
            sparseTable[i][0] = arr[i];
        }

//        Arrays.stream(arr).forEach(System.out::println);

        preprocess(n);

        int l, r;
        for(int i = 0; i < q; i++){
            input = br.readLine().split(" ");
            l = Integer.valueOf(input[0]);
            r = Integer.valueOf(input[1]);
//            System.out.println(l + " " + r);
            processQuery(l - 1, r - 1);
        }
        br.close();
    }

    private static void processQuery(int l, int r) {
        int length = r - l + 1;
        int log = bin_log[length];
//        int left = r - (1<<log) + 1;
//        System.out.println(log + " " + left);
        int min = Math.min(sparseTable[l][log], sparseTable[r - (1<<log) + 1][log]);
        Arrays.sort(sparseTable[1]);
        System.out.println(min);
    }

    private static void preprocess(int n) {
//        System.out.println();
        for(int j = 1; j <= LOG; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }

//        for(int j = 0; j < LOG; j++) {
//             for(int i = 0; i < n; i++){
//                System.out.print(sparseTable[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }
}
