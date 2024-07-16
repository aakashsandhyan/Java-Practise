package DP;


import java.util.HashMap;
import java.util.Map;

public class Test2
{
    public static void main (String[] args) throws Exception{
//        Scanner scanner = new Scanner(System.in);


        int[] first = {6, 3, 6, 5, 1};
        int[] second = {1, 4, 5, 9, 2};

        int n = first.length;
        int k = 3;
        System.out.println(solve(first, second, n, k));
    }


    private static int solve(int[] first, int[] second, int n, int k) {
        Map<Integer, Integer> max = new HashMap<>();
        Map<Integer, Integer> min = new HashMap<>();

        max.put(1, first[0]);
        min.put(1, first[0]);

        max.put(0, 0);
        min.put(0, 0);

       int[][][] dp = new int[n + 1][k + 1][50 * 50 + 1];
       dp[1][1][first[0]] = second[0];

       for(int i = 2; i <= n ; i++){
            for(int j = 1; j <= Math.min(i, k); j++){
                max.put(j, Math.max(max.getOrDefault(j, Integer.MIN_VALUE), first[i - 1] + max.get(j - 1)));
                min.put(j, Math.min(min.getOrDefault(j, Integer.MAX_VALUE), first[i - 1] + min.get(j - 1)));
                for(int sum = min.get(j); sum <= max.get(j); sum++){
                    dp[i][j][sum] = dp[i - 1][j][sum];
                    if(sum - first[i - 1] >= 0 && dp[i - 1][j - 1][sum - first[i - 1]] != 0){
                        dp[i][j][sum] = Math.max(dp[i][j][sum], second[i - 1] + dp[i - 1][j - 1][sum - first[i - 1]]);
                    }
                }
            }
       }

       int ans = 0;
       for(int sum = min.get(k); sum <= max.get(k); sum++){
           ans = Math.max(ans, dp[n][k][sum]);
       }

       return ans;
    }


}