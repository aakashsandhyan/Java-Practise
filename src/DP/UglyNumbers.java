package DP;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UglyNumbers {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        Map<Integer, Integer> indexes = new HashMap<>();
        int nextMultiple2 = 2, nextMultiple3 = 3, nextMultiple5 = 5;

        indexes.put(2, 0);
        indexes.put(3, 0);
        indexes.put(5, 0);
        int n = 150;
        for(int i = 1; i < n; i++){
            int minOfAboveThree =
                    Math.min(nextMultiple2, Math.min(nextMultiple3, nextMultiple5));
            dp.add(minOfAboveThree);
            if(minOfAboveThree == nextMultiple2){
                indexes.put(2, indexes.get(2) + 1);
                nextMultiple2 = 2 * dp.get(indexes.get(2));
            }
            if(minOfAboveThree == nextMultiple3){
                indexes.put(3, indexes.get(3) + 1);
                nextMultiple3 = 3 * dp.get(indexes.get(3));
            }
            if(minOfAboveThree == nextMultiple5){
                indexes.put(5, indexes.get(5) + 1);
                nextMultiple5 = 5 * dp.get(indexes.get(5));
            }
//            System.out.println(dp.get(i));
        }
        System.out.print(dp.get(n - 1));
    }

    public static Pair<Integer, Integer> min(Pair<Integer, Integer> a, Pair<Integer, Integer> b, Pair<Integer, Integer> c){
        Pair<Integer, Integer> min;
        if(a.getValue() <= b.getValue() ){
            min = a;
        }
        else{
            min = b;
        }

        if(min.getValue() > c.getValue()){
            min = c;
        }

        return min;
    }
}
