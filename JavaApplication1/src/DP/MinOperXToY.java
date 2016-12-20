/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class MinOperXToY {
    public static void main(String args[]){
        int x = 2;
        int y = 5;
        minOps = new int[2*y+1];
        minOps[y] = 0;
        Arrays.fill(minOps, Integer.MAX_VALUE);
        System.out.println(minOps(x, y));
        System.out.println(Arrays.toString(minOps));
    }
    
    static int[] minOps;
    public static int minOps(int x, int y){
        if(x <= 0){
            return Integer.MAX_VALUE;
        }
        if(x >= y){
            return x-y;
        }
        if(minOps[x] > -1 && minOps[x] < Integer.MAX_VALUE){
            return minOps[x];
        }
        minOps[x] = Integer.MAX_VALUE-1;
        int min = Math.min(minOps(x-1, y), minOps(2*x, y));
        if(min < Integer.MAX_VALUE && min > -1){
            min = min+1;
        }
        else{
            min = Integer.MAX_VALUE-1;
        }
        minOps[x] = min;
        return min;
    }
}
