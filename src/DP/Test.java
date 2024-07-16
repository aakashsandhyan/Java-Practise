package DP;


import java.util.*;
import java.lang.*;

public class Test
{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner scanner = new Scanner(System.in);
        int t, n, c;
        t = scanner.nextInt();
        int[] stalls = new int[100000];
        for(int i = 0; i < t; i++){
            n = scanner.nextInt();
            c = scanner.nextInt();
            for(int j = 0; j < n; j++){
                stalls[j] = scanner.nextInt();
            }
            Arrays.sort(stalls, 0, n);
            System.out.println(solve(stalls, n, c));
        }
    }

    private static int solve(int[] stalls, int n, int c) {
        if(c > n){
            return -1;
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            minDistance = Math.min(minDistance, stalls[i] - stalls[i - 1]);
        }
        int maxDistance = stalls[n - 1] - stalls[0];
        int low = minDistance;
        int high = maxDistance;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            int cowsAllocated = placeCows(stalls, n, mid);
            if(cowsAllocated >= c){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int placeCows(int[] stalls, int n, int mid) {

        int allocatedCows = 0;
        int lastAllocated = stalls[0];
        for(int i = 0; i < n; i++){
            if(stalls[i] - lastAllocated > mid){
                lastAllocated = stalls[i];
                allocatedCows++;
            }
        }

        return allocatedCows + 1;
    }
}