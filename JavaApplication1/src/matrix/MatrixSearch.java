/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class MatrixSearch {
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
        searchMatrix(matrix);
        displayMatrix(matrix);
    }
        
    public static void displayMatrix(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    private static void searchMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = 0;
        if(m > 0){
            n = matrix[0].length;
        }
        get()
    }
}
