/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class MatrixMultiplicationCost {
    public static void main(String[] args){
        int[] A = {10, 30};
        int[] B = {30, 5};
        int[] C = {5, 10};
        int[] D = {10, 25};
        
        int[][] mMatrix = {A, B, C, D};
        System.out.println(findEfficientOrder(mMatrix, 0, mMatrix.length-1, ""));
    }
    static Map<String, Integer> map = new HashMap();
    private static int findEfficientOrder(int[][] p, int start, int end, String string) {
        if(start > end){
            return Integer.MAX_VALUE;
        }
        if(start == end){
            return 0;
        }
        String key = start+"_"+end;
        Integer minVal = map.get(key);
        if(minVal != null){
            return minVal;
        }
        int min = Integer.MAX_VALUE;
        for(int i = start; i < end-1; i++){
            int tempVal = 2*p[i][0]*p[i][1]*p[i+1][1] + findEfficientOrder(p, start, i, string)+
                    findEfficientOrder(p, i+1, end, string);
            if(tempVal < Integer.MAX_VALUE && tempVal > 0){
                min = Math.min(min, tempVal);
            }
        }
        map.put(key, min);
        return min;
    }
}
