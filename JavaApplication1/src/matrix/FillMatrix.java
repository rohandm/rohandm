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
public class FillMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,0},{0, 1, 0},{0, 0, 1}};
    }
    
    public static void fillMatrix(int[][] matrix){
        int len = matrix.length;

    }
    
    public static void gaussianElimination(int[][] arr){
        int len = arr.length;
        int[][] matrix = new int[2*len][len];
        int rowInd = 0;
        for(int[] row: arr){
            matrix[rowInd] = row;
            rowInd++;
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                matrix[i+rowInd][j] = arr[j][i];
            }
        }
        int len1 = 2*len;
        int[] A = new int[len];
        Arrays.fill(A, 1);
        
        for(int piv = 0; piv < len; piv++){
            int max = piv;
            for(int row = piv+1; row < len; row++){
                if(matrix[row][piv] > max){
                    max = row;
                }
            }
            
            int temp = matrix[piv][piv];
            matrix[piv][piv] = matrix[max][piv];
            matrix[max][piv] = temp;
        }
    }
}
