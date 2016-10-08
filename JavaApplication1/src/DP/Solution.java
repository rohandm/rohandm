package DP;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        String[] opStr = new String[t];
        for(int i = 0; i < t; i++){
            scan.nextLine();
            int m = scan.nextInt();
            scan.nextLine();
            int n = scan.nextInt();
            scan.nextLine();
            List list = new ArrayList();
            //System.out.println(m+" x "+n);
            int[] costArr = new int[n];
            for(int j = 0; j < n; j++){
                //System.out.println(i + " " + j+" "+costArr[j]);
                costArr[j] = scan.nextInt();
                if(list.contains(costArr[j])){
                    //System.out.println("He");
                    //if(costArr[j] <= m/2){
                    /*    opStr[i] = (j+1)+" "+(list.indexOf(costArr[j])+1);
                    }
                    else{
                        //System.out.println("Ho");*/
                        
                        opStr[i] = (list.indexOf(costArr[j])+1)+" "+(j+1);
                    //}
                    break;                    
                }
                list.add(m - costArr[j]);
            }
        }
        System.out.println(Arrays.toString(opStr));
    }
}