package micellaneous;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.io.*;
import java.util.Scanner;

public class SegmentTree {
    public static void main(String[] args) throws IOException {
        int numOfValues, queries;
        File file = new File("testCases.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new FileInputStream(file));
        String input;
        input = br.readLine();
        String arr[] = input.split(" ");
        numOfValues = Integer.valueOf(arr[0]);
        queries = Integer.valueOf(arr[1]);
        // looping till n becomes power of two.
        int n = numOfValues;
        while ((numOfValues & (numOfValues - 1)) != 0)
            numOfValues++;
        int values[] = new int[numOfValues];
        input = br.readLine();
        arr = input.split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.valueOf(arr[i]);
        }
        long [] segmentTree = new long[2*numOfValues - 1];
        buildSegmentTree(segmentTree, values);

        //running the queries
        for(int i = 0; i < queries; i++)
        {
            input = br.readLine();
            arr = input.split(" ");
            int queryLow = Integer.valueOf(arr[0]) - 1;
            int queryHigh = Integer.valueOf(arr[1]) - 1;
            System.out.println(getSum(segmentTree, 0, 0 , numOfValues - 1, queryLow, queryHigh));
        }
    }

    private static long getSum(long[] segmentTree, int i, int segmentLow, int segmentHigh, int queryLow, int queryHigh) {
        if(queryLow <= segmentLow && queryHigh >= segmentHigh){
            return segmentTree[i];
        }
        if(queryLow > segmentHigh || queryHigh < segmentLow){
            return (long)0;
        }
        int lastOfLeftSegment = (segmentHigh + segmentLow) / 2;
        long leftSum = getSum(segmentTree, 2 * i + 1, segmentLow, lastOfLeftSegment, queryLow, queryHigh);
        long rightSum = getSum(segmentTree, 2 * i + 2, lastOfLeftSegment + 1, segmentHigh, queryLow, queryHigh);
        return leftSum + rightSum;
    }

    private static void buildSegmentTree(long[] segmentTree, int[] values) {
        for(int i = 0; i < values.length; i++){
           segmentTree[values.length-1+i] = Long.valueOf(values[i]);
        }
        for(int  i = values.length - 2; i >= 0; i--) {
            segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
        }
    }
}