/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author ROHANME
 */
public class LargestPalindromeSubSeq {
    private static int[][] cache;
    public static void main(String args[]){
        String inputStr = "turboventilator";
        cache = new int[inputStr.length()][inputStr.length()];
        for(int[] el: cache){
            Arrays.fill(el, -1);
        }
        System.out.println(largestPalindromeSubSeq(inputStr.toLowerCase().toCharArray(), 0, inputStr.length()-1));
    }
    
    public static int largestPalindromeSubSeq(char[] arr, int i, int j){
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if(i > j || i >= arr.length || j < 0){
            
            return 0;
        }
        if(i == j){
            cache[i][j]=1;
            return cache[i][j];
        }
        if(arr[i] == arr[j]){
            cache[i][j] = 2 + largestPalindromeSubSeq(arr, i+1, j-1);
            return cache[i][j];
        }
        else{
            cache[i][j] = Math.max(largestPalindromeSubSeq(arr, i+1, j),
                    largestPalindromeSubSeq(arr, i, j-1));
            return cache[i][j];
        }
    }
}
