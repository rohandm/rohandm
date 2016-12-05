/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rohan_000
 */
public class SetMatrixZeros {
    public static void main(String args[]){
        int m = 5;
        int n = 6;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = (int)Math.round(Math.random()+0.4);
            }
        }
        displayMatrix(matrix);
        System.out.println("\n");
        setZeros(matrix, m, n);
        displayMatrix(matrix);
    }

    private static void setZeros(int[][] matrix, int m, int n) {
        List<Integer> skipColList = new ArrayList();
        List<Integer> skipRowList = new ArrayList();
        for(int j = 0; j < m; j++){
            for(int k = 0; k < n; k++){

                if(matrix[j][k] == 0){
                    skipRowList.add(j);
                    skipColList.add(k);
                    break;
                }
            }
        }
        System.out.println(skipRowList);
        System.out.println(skipColList);
        for(int j: skipColList){
            for(int i = 0; i < m; i++){
                matrix[i][j] = 0;
            }
        }
        for(int i: skipRowList){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 0;
            }
        }
    }
    public static void displayMatrix(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
