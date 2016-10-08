package DP;


import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan_000
 */
public class MaxContSeq {
    public static void main(String args[]){
        int[] arr = new int[]{7, 4, 0, 6, 5, 9, 3};
        System.out.println(Arrays.toString(maxContSeq(arr, 4)));
    }
    
    private static int[] maxContSeq(int[] arr, int cnt){
        if(arr == null || arr.length == 0){
            return arr;
        }
        return arr;
    }
    
    private static int[]  mergeSort(int[] arr){
        if(arr == null){
            return arr;
        }
        int n = arr.length;
        if(n <= 1){
            return arr;
        }
        int med = n/2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, n/2);
        int[] arr2 = Arrays.copyOfRange(arr, n/2, n);
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        arr = merge(arr1, arr2);
        return arr;
    }
    
    private static int[] merge(int[] arr1, int[] arr2){
        if(arr1 == null || arr1.length == 0){
            return arr2;
        }
        if(arr2 == null || arr2.length == 0){
            return arr1;
        }
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                arr[k++] = arr1[i++];  
            }
            else{
                arr[k++] = arr2[j++];
            }
        }
        while(i < n1){
            arr[k++] = arr1[i++];  
        }
        while(j < n2){
            arr[k++] = arr2[j++];
        }

        
        return arr;
    }
}
