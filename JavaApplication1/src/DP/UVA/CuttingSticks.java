/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author rohan_000
 */
class CuttingSticks {
    static HashMap costMap = new HashMap();
    static int[] inputArr;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int n = scan.nextInt();
        inputArr = new int[n]; 
        for(int i = 0; i < n ; i++){
            inputArr[i] = scan.nextInt()-1;
        }
        int cost = cost(0, len - 1);
        
        System.out.println(cost);
    }
    
    static int cost(int startInd, int endInd){
        if(startInd >= endInd){
            return 0;
        }
        int retValue = Integer.MAX_VALUE;
        if(costMap.containsKey(startInd+"_"+endInd)){
            return (Integer)costMap.get(startInd+"_"+endInd);
        }
        
        for(int i = 0; i < inputArr.length; i++){
            if(inputArr[i] > startInd && inputArr[i] < endInd){
                int s1 = cost(startInd, inputArr[i]);
                int s2 = cost(inputArr[i]+1, endInd);
                //if(s1 == Integer.MAX_VALUE && s2 == Integer.MAX_VALUE){
                    retValue = Math.min(retValue, (endInd-startInd+1)+s1+s2); 
                //}
            }
        }
        if(Math.abs(retValue) == Integer.MAX_VALUE){
            retValue = 0;
        }
        costMap.put(startInd+"_"+endInd, Math.abs(retValue));
        System.out.println(startInd+"_"+endInd+":"+retValue);
        return (Integer)costMap.get(startInd+"_"+endInd);
    }
}
