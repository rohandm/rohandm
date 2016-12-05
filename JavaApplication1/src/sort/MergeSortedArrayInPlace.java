/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class MergeSortedArrayInPlace {
    public static void main(String args[]){
        int[] A = {2, 3, 5, 8, 11, 13, 0, 0, 0, 0, 0, 0};
        int[] B = {1, 4, 9, 12, 14};
        int aSize = 6;
        int bSize = 5;
        mergeSortedArrayInPlace(A, B, aSize, bSize);
        System.out.println(Arrays.toString(A));
    }

    private static void mergeSortedArrayInPlace(int[] A, int[] B, int aSize, int bSize) {
        int indA = aSize - 1;
        int indB = bSize - 1;
        int mergedInd = aSize+bSize-1;
        while(indA >= 0){
            if(A[indA] > B[indB]){
                A[mergedInd--] = A[indA--];
            }
            else{
                A[mergedInd--] = B[indB--];
            }
        }
        while(indB >= 0){
            A[mergedInd--] = B[indB--];
        }
    }
}
