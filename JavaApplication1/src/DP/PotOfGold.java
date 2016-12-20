/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class PotOfGold {
    static int[] arr;
    static int playerInd = 0;
    public static void main(String args[]){
        arr = new int[]{3, 4, 5, 7, 12, 13, 6, 1};
        int len = arr.length;
        Strategy strategy = maxGold(0, len-1);
        System.out.println(strategy.sum);
        System.out.println(strategy.moves);
    }
    static Map<String, Strategy> map = new HashMap();
    private static Strategy maxGold(int start, int end) {
        //System.out.println(start+" "+end);
        Strategy strategy;
        if(start > end){
            strategy = new Strategy();
            strategy.sum = 0;
            strategy.moves = "";
            return strategy;
        }
        String key = start+"-"+end;
        if(map.containsKey(key)){
            return map.get(key);
        }
        Strategy strategy1 = new Strategy(min(maxGold(start+2, end), maxGold(start+1, end-1)), arr[start]);
        Strategy strategy2 = new Strategy(min(maxGold(start+1, end-1), maxGold(start, end-2)), arr[end]);;
        strategy = max(strategy1, strategy2);
        map.put(key, strategy);
        return strategy;
    }
    
    public static Strategy min(Strategy strategy1, Strategy strategy2){
        if(strategy1.compareTo(strategy2) < 0){
            return strategy1;
        }
        return strategy2;
    }
    
    public static Strategy max(Strategy strategy1, Strategy strategy2){
        if(strategy1.compareTo(strategy2) >= 0){
            return strategy1;
        }
        return strategy2;
    }
}
class Strategy implements Comparable{
    int sum;
    String moves;
    
    Strategy(){
        
    }
    
    Strategy(Strategy strategy1, int val){
        sum = val+strategy1.sum;
        moves = val+" "+strategy1.moves;
    }

    @Override
    public int compareTo(Object o) {
        Strategy strategy1 = (Strategy)o;
        return this.sum - strategy1.sum;
    }
}


