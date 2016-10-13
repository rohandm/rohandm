/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
class CoinChange {
    static Map<Integer, Integer> cntList = new HashMap();
    static int[] denominations = new int[]{1, 5, 10, 25, 50};
    HashSet<String> combinationSet = new HashSet();
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int arr[] = new int[5];
        System.out.println(combinations(n, arr));
       
    }

    private static int combinations(int n, int[]  arr) {
        if(cntList.containsKey(n)){
            return cntList.get(n);
        }
        if(n < 1){
            return 0;
        }
        int ret = 0;
        
        for(int i = 0; i < denominations.length; i++){
            if(n == denominations[i]){
                ret += 1;
            }
            else{
                arr[i]++;
                ret += combinations(n-denominations[i], arr);
            }
        }
        return ret;
    }
}
