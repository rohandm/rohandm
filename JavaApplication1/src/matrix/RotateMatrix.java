/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Arrays;

/**
 * In place rotation
 * @author rohan_000
 */
public class RotateMatrix {
    public static void main(String args[]){
        int m = 5;
        int n = 5;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = (int)Math.round(5*Math.random());
            }
        }
        displayMatrix(matrix);
        System.out.println();
        rotateMatrix(matrix);
        displayMatrix(matrix);
    }
    
    public static void displayMatrix(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    private static void rotateMatrix(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len/2; i++){
            for(int j = i; j < len-1-i; j++){
                //System.out.println(matrix[len-1-j][i]+" "+matrix[len-1-i][len-1-j]+" "+matrix[j][len-1-i]+" "+matrix[i][j]);
                int temp = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = matrix[i][j];
                matrix[i][j] = temp;
                //System.out.println("to "+i+" "+j);
                //System.out.println(matrix[len-1-j][i]+" "+matrix[len-1-i][len-1-j]+" "+matrix[j][len-1-i]+" "+matrix[i][j]);
            }
        }
    }
}
