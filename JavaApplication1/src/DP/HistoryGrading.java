package DP;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
Many problems in Computer Science involve maximizing some measure according to constraints.

Consider a history exam in which students are asked to put several historical events into chronological order. Students who order all the events correctly will receive full credit, but how should partial credit be awarded to students who incorrectly rank one or more of the historical events?

Some possibilities for partial credit include:

1 point for each event whose rank matches its correct rank
1 point for each event in the longest (not necessarily contiguous) sequence of events which are in the correct order relative to each other.
For example, if four events are correctly ordered 1 2 3 4 then the order 1 3 2 4 would receive a score of 2 using the first method (events 1 and 4 are correctly ranked) and a score of 3 using the second method (event sequences 1 2 4 and 1 3 4 are both in the correct order relative to each other).

In this problem you are asked to write a program to score such questions using the second method.
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
