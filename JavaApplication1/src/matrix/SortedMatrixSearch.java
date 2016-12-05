/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author rohan_000
 */
public class SortedMatrixSearch {
    public static void main(String args[]){
        int[][] matrix = {{15, 29, 30, 40},{20, 35, 55, 80},{70, 80, 95, 100},{85, 95, 105, 12}};
        System.out.println(search(matrix, 35, 0, matrix.length-1, 0, matrix.length-1));
    }
    
    public static String search(int[][] matrix, int element, int startRow, int endRow, int startCol, int endCol){
        int midRow = (startRow+endRow)/2;
        int midCol = (startCol+endCol)/2;
        if(element == matrix[midRow][midCol]){
            return midRow+" "+midCol;
        }
        else if(element > matrix[midRow][midCol]){
            String str1 = search(matrix, element, midRow+1, endRow, 0, midCol);
            if(str1 == null){
                str1 = search(matrix, element,0, midRow, midCol+1, endCol);
            }
            if(str1 == null){
                str1 = search(matrix, element, midRow+1, endRow, midCol+1, endCol);
            }
            return str1;
        }
        else{
            return search(matrix, element, 0, midRow, 0, endRow);
        }
    }
}
