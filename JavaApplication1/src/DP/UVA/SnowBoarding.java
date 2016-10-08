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
 * @author ROHANME
 */
class SnowBoarding {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            String name = scan.next();
            int rows = scan.nextInt();
            int cols = scan.nextInt();
            int[][] heightArr = new int[rows][cols];
            int[][] longestRun = new int[rows][cols];
            for(int j = 0; j < rows; j++){
                for(int k = 0; k < cols; k++){
                    heightArr[j][k] = scan.nextInt();
                }
            }
            for(int j = 0; j < rows; j ++){
                Arrays.fill(longestRun[j], 1);
            }
            boolean changed = true;
            int max = 1;
            while(changed){
                changed = false;
                //System.out.println("\n\n");
                for(int j = 0; j < rows; j++){
                    
                    for(int k = 0; k < cols; k++){
                        int longest = longestRun[j][k];
                        if(j > 0 && heightArr[j][k] > heightArr[j-1][k]){
                            longest = Math.max(longest, longestRun[j-1][k]+1);
                        }
                        if(k > 0 && heightArr[j][k] > heightArr[j][k-1]){
                            longest = Math.max(longest, longestRun[j][k-1]+1);
                        }
                        if(j < rows - 1 && heightArr[j][k] > heightArr[j+1][k]){
                            longest = Math.max(longest, longestRun[j+1][k]+1);
                        }
                        if(k < cols - 1 && heightArr[j][k] > heightArr[j][k+1]){
                            longest = Math.max(longest, longestRun[j][k+1]+1);
                        }

                        if(longestRun[j][k] < longest){
                            changed = true;
                            longestRun[j][k] = longest;
                        }

                        
                        if(max < longest){
                            max = longest;
                        }
                    }
                    //System.out.println(Arrays.toString(longestRun[j]));
                }
            }
            System.out.println(name+": "+max);
        }
    }
}
