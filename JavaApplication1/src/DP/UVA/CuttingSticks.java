/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rohan_000
 */
class CuttingSticks {
    static int[][] arr;
    static int[] inputArr;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int n = scan.nextInt();
        inputArr = new int[n];
        for(int i = 0; i < n ; i++){
            inputArr[i] = scan.nextInt();
        }
        
        arr = new int[len][n];
        for(int[] subArr: arr){
            Arrays.fill(subArr, Integer.MAX_VALUE);
        }
        int cost = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            cost = Math.min(cost, cost(len, i));
        }
        System.out.println(cost);
    }
    
    static int cost(int len, int ind){
        if(arr[len-1][ind] < Integer.MAX_VALUE){
            return arr[len-1][ind];
        }
        
        if(len == inputArr[ind]){
            arr[len-1][ind] = len;
            return len;
        }
        
        int cost = Integer.MAX_VALUE;
        
        for(int i = 0; i < ind; i++){
            cost = Math.min(cost, cost(len, i));
        }
        if(cost < Integer.MAX_VALUE){
            arr[len-1][ind] = len+cost;
        }
        return arr[len-1][ind];
    }
}
