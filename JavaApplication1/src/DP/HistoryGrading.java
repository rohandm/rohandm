package DP;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan_000
 */
public class HistoryGrading {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        
        //int[] origSeq = new int[n];
        int[] origSeq = new int[n];
        for(int i = 0; i < n; i++){
            origSeq[scan.nextInt()-1] = i;
        }
        
        while(scan.hasNextInt()){
            int[] studSeq = new int[n];
            for(int i = 0; i < n; i++){
                studSeq[i] = origSeq[scan.nextInt()-1];
            }
            
            int[] maxScore = new int[n];
            //System.out.println(origSeq.toString());
            //System.out.println(Arrays.toString(studSeq));
            Arrays.fill(maxScore, 1);
            int max = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < j; k++){
                    if((studSeq[j]) > studSeq[k]){
                        maxScore[j] = Math.max(maxScore[j], maxScore[k]+1);
                    }
                }
                max = Math.max(max, maxScore[j]);
            }
            System.out.println(max);
        }
    }
}
