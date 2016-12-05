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
 * @author rohan_000
 */
public class UnidirectionalTSP {
    static int[][] arr;
    static int[][] inputArr;
    static String[][] path;
    static int rows = 0;
    static int cols = 0;
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        rows = scan.nextInt();
        cols = scan.nextInt();
        arr = new int[rows][cols];
        inputArr = new int[rows][cols];
        path = new String[rows][cols];
        
        for(int i = 0; i < rows; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            for(int j = 0; j < cols; j++){
                inputArr[i][j] = scan.nextInt();
            }
        }
        int minPath = Integer.MAX_VALUE;
        int oldMin = minPath;
        String pathStr = "";
        for(int i = 0; i < rows; i++){
            oldMin = minPath;
            minPath = Math.min( minPath(i, 0), minPath);
            if(oldMin != minPath){
                pathStr = path[i][0];
            }
        }
        System.out.println(minPath+" "+pathStr);
        
        for(int[] cols: arr){
            System.out.println(Arrays.toString(cols));
        }
    }

    private static int minPath(int startRow, int colInd) {
        int retValue = Integer.MAX_VALUE;
        if(colInd > cols){
            return retValue;
        }
        if(colInd == cols-1){
            arr[startRow][colInd] = inputArr[startRow][colInd];
            path[startRow][colInd] = ""+(startRow+1);
            return inputArr[startRow][colInd];
        }
        if(arr[startRow][colInd] < Integer.MAX_VALUE){
            return arr[startRow][colInd];
        }
        int val = minPath(startRow, colInd+1);
        int oldVal = retValue;
        retValue = Math.min(retValue, val+inputArr[startRow][colInd]);
        if(retValue != oldVal){
            path[startRow][colInd] = (startRow+1)+" "+path[startRow][colInd+1];
        }
        if(startRow == 0){
            val = minPath(rows-1, colInd+1);
            oldVal = retValue;
            retValue = Math.min(retValue, val+inputArr[startRow][colInd]);
            if(retValue != oldVal){
                path[startRow][colInd] = (startRow+1)+" "+path[rows-1][colInd+1];
            }
        }
        if(startRow > 0){
            val = minPath(startRow-1, colInd+1);
            oldVal = retValue;
            retValue = Math.min(retValue, val+inputArr[startRow][colInd]);
            if(retValue != oldVal){
                path[startRow][colInd] = (startRow+1)+" "+path[startRow-1][colInd+1];
            }
        }
        if(startRow < rows-1){
            val = minPath(startRow+1, colInd+1);
            oldVal = retValue;
            retValue = Math.min(retValue, val+inputArr[startRow][colInd]);
            if(retValue != oldVal){
                path[startRow][colInd] = (startRow+1)+" "+path[startRow+1][colInd+1];
            }
        }
        if(startRow == rows-1){
            val = minPath(0, colInd+1);
            oldVal = retValue;
            retValue = Math.min(retValue, val+inputArr[startRow][colInd]);
            if(retValue != oldVal){
                path[startRow][colInd] = (startRow+1)+" "+path[0][colInd+1];
            }
        }
        arr[startRow][colInd] = retValue;
        //System.out.println(startRow+","+colInd+":"+retValue);
        return retValue;
    }
}
