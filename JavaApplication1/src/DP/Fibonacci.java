/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author ROHANME
 */
public class Fibonacci {
    static long[] fibNums;
    public static void main(String args[]){
        System.out.println(fibonacci(6));
    }
    
    private static long fibonacci(int n){
        fibNums = new long[n];
        
        if(n == 0 || n == 1){
            return 1;
        }
        fibNums[0] = 1;
        fibNums[1] = 1;
         
        for(int i = 2; i < n; i++){
            fibNums[i] = fibNums[i-1] + fibNums[i-2];
        }
        return fibNums[n-1];
    }
}
