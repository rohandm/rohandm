/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
public class NumberBST {
    private static HashMap<Integer, Long> cntMap = new HashMap();
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i ++){
            int p = scanner.nextInt();
            System.out.println(numOfBST(p));
            System.out.println(Math.floor(p));
        }
    }
    
    private static long numOfBST(int p){
        if(cntMap.containsKey(p)){
            return cntMap.get(p);
        }
        if(p == 0 || p == 1){
            cntMap.put(p, 1l);
            return 1;
        }
        long retValue = 0;
        for(int i = 1; i <= p; i++){
            retValue += numOfBST(p-i)*numOfBST(i-1);
        }
        cntMap.put(p, retValue);
        return retValue;
    }
}
