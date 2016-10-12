/*

 History Grading 

Background

Many problems in Computer Science involve maximizing some measure according to constraints.

Consider a history exam in which students are asked to put several historical events into chronological order. Students who order all the events correctly will receive full credit, but how should partial credit be awarded to students who incorrectly rank one or more of the historical events?

Some possibilities for partial credit include:

1 point for each event whose rank matches its correct rank
1 point for each event in the longest (not necessarily contiguous) sequence of events which are in the correct order relative to each other.
For example, if four events are correctly ordered 1 2 3 4 then the order 1 3 2 4 would receive a score of 2 using the first method (events 1 and 4 are correctly ranked) and a score of 3 using the second method (event sequences 1 2 4 and 1 3 4 are both in the correct order relative to each other).

In this problem you are asked to write a program to score such questions using the second method.

The Problem

Given the correct chronological order of n events  tex2html_wrap_inline34 as  tex2html_wrap_inline36 where  tex2html_wrap_inline38 denotes the ranking of event i in the correct chronological order and a sequence of student responses  tex2html_wrap_inline42 where  tex2html_wrap_inline44 denotes the chronological rank given by the student to event i; determine the length of the longest (not necessarily contiguous) sequence of events in the student responses that are in the correct chronological order relative to each other.

The Input

The first line of the input will consist of one integer n indicating the number of events with  tex2html_wrap_inline50 . The second line will contain n integers, indicating the correct chronological order of n events. The remaining lines will each consist of n integers with each line representing a student's chronological ordering of the n events. All lines will contain n numbers in the range  tex2html_wrap_inline60 , with each number appearing exactly once per line, and with each number separated from other numbers on the same line by one or more spaces.

The Output

For each student ranking of events your program should print the score for that ranking. There should be one line of output for each student ranking.

Sample Input 1

4
4 2 3 1
1 3 2 4
3 2 1 4
2 3 4 1
Sample Output 1

1
2
3
Sample Input 2

10
3 1 2 4 9 5 10 6 8 7
1 2 3 4 5 6 7 8 9 10
4 7 2 3 10 6 9 1 5 8
3 1 2 4 9 5 10 6 8 7
2 10 1 3 8 4 9 5 7 6
Sample Output 2

6
5
10
9
 */
package DP.UVA;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
public class HistoryGrading {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] correctArr = new int[n];
        for(int i = 0; i < n; i++){
            correctArr[scanner.nextInt()-1] = i;
        }
        int input = 0;
        
        while(input > -1){
            int[] studArr = new int[n];
            for(int i = 0; i < n; i++){
                input = scanner.nextInt();
                studArr[i] = input;
            }
            int[] maxSeq = new int[n];
            Arrays.fill(maxSeq, 1);
            int max = 1;
            
            for(int i = 1; i < n; i ++){
                for(int j = 0; j < i; j++){
                    if(correctArr[studArr[i]-1] > correctArr[studArr[j]-1]){
                        maxSeq[i] = Math.max(maxSeq[i], maxSeq[j]+1);
                        max = Math.max(maxSeq[i], max);
                    }
                }
            }
            System.out.println(max);
        }
        
    }
}
