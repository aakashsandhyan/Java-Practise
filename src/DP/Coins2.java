package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Coins2 {
    private int[][] combinations = null;
    public int change(int amount, int[] coins) {
        int length = coins.length;
        combinations = new int[amount + 1][length];
        Arrays.sort(coins);
        for(int i = 0 ; i < length; i++){
            combinations[0][i] = 1;
        }
        // dp[A][K] = dp[A - coins[K]][K];
        for(int sum = 1; sum <= amount; sum++){
            Map<Integer, String> a = new HashMap<>();

            for(int j = 0; j < length; j++){
                if(coins[j] > sum)
                    break;

                combinations[sum][j] += combinations[sum - coins[j]][j];
                if(j + 1 < length && coins[j + 1] < sum)
                    combinations[sum][j + 1] = combinations[sum - coins[j + 1]][j];
            }
        }

        return sumArray(combinations[amount]);
    }

    private int sumArray(int[] array){
        int sum = 0;
        for(int x : array){
            sum += x;
        }
        return sum;
    }
}