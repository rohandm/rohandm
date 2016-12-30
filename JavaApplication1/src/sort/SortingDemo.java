/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author rohan_000
 */
public class SortingDemo {

    public static void main(String args[]) {
        int n = 25;
        int[] arr = new int[n];
        IntStream.range(0, n - 1).forEach(i -> arr[i] = (int) ((10000) * Math.random()));
        System.out.println(Arrays.toString(arr));
        sort("bubbleSort", Arrays.copyOf(arr, arr.length));
        sort("selectionSort", Arrays.copyOf(arr, arr.length));
        sort("insertionSort", Arrays.copyOf(arr, arr.length));
        sort("mergeSort", Arrays.copyOf(arr, arr.length));
        sort("bucketSort", Arrays.copyOf(arr, arr.length));
        sort("quickSort", Arrays.copyOf(arr, arr.length));
    }

    public static int[] bubbleSort(int[] input) {
        int[] output = Arrays.copyOf(input, input.length);
        IntStream.range(0, output.length).forEach(i
                -> IntStream.range(1, -i + output.length).forEach(j -> {
            if (output[j - 1] > output[j]) {
                int temp = output[j - 1];
                output[j - 1] = output[j];
                output[j] = temp;
            }
        })
        );
        return output;
    }

    public static int[] selectionSort(int[] input) {
        int[] output = Arrays.copyOf(input, input.length);
        IntStream.range(0, output.length).forEach(i
            -> IntStream.range(i + 1, output.length).forEach(j -> {
            if (output[i] > output[j]) {
                int temp = output[i];
                output[i] = output[j];
                output[j] = temp;
            }
        })
        );
        return output;
    }

    public static int[] insertionSort(int[] input) {
        int[] output = Arrays.copyOf(input, input.length);
        IntStream.range(1, output.length).forEach(i -> {
            for (int j = i-1; j >= 0; --j) {
                if (output[j+1] < output[j]) {
                    int temp = output[j+1];
                    output[j+1] = output[j];
                    output[j] = temp;
                }
                else{
                    break;
                }
            }
        });
        return output;
    }
    
    public static int[] mergeSort(int[] input){
        return mergeSort(input, 0, input.length-1);
    }
    public static int[] mergeSort(int[] input, int startInd, int endInd){
        //System.out.println(startInd+" "+ endInd);
        if(startInd > endInd){
            return new int[]{};
        }
        if(startInd == endInd){
            return new int[]{input[startInd]};
        }
        int mid = (endInd+startInd)/2;
        int[] output = merge(mergeSort(input, startInd, mid), mergeSort(input, mid+1, endInd));
        return output;
    }
    
    public static int[] merge(int[] input1, int[] input2){
        int len1 = input1.length;
        int len2 = input2.length;
        int i = 0; int j = 0;
        int[] output = new int[len1+len2];
        int k = 0;
        while(i < len1 && j < len2){
            if(input1[i] <= input2[j]){
                output[k++] = input1[i++];
            }
            else{
                output[k++] = input2[j++];
            }
        }
        while(i < len1){
            output[k++] = input1[i++];
        }
        while(j < len2){
            output[k++] = input2[j++];
        }
        return output;
    }

    private static void sort(String funct, int[] arr) {
        long startTime = System.nanoTime();
        Method method = null;
        try {
            method = SortingDemo.class.getDeclaredMethod(funct, arr.getClass());
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SortingDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(SortingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] output = null;
        try {
            output = (int[]) method.invoke(SortingDemo.class, arr);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SortingDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SortingDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SortingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        long endTime = System.nanoTime();
        System.out.println(funct + " time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println(Arrays.toString(output));
    }
    
    public static int[] bucketSort(int[] arr){
        int max = findMax(arr);
        int k = (int)Math.log10(max)+1;
        int b = 10;
        int[] bucket = new int[b];
        int[] output = new int[arr.length];
        int n = arr.length;
        System.out.println(max+" "+k);
        for(int j = 0; j < k; j++){
            Arrays.fill(bucket, 0);
            int digit = (int)Math.pow(10, j);
            for(int i = 0; i < n; i++){
                bucket[((arr[i]/digit)%b)]++;
            }
            for(int i = 1; i < b; i++){
                bucket[i] = bucket[i]+bucket[i-1];
            }
            System.out.println(Arrays.toString(bucket));
            for(int i = n-1; i >= 0; i--){
                output[--bucket[((arr[i]/digit)%b)]] = arr[i];
            }
            for(int i = 0; i < n; i++){
                arr[i] = output[i];
            }
        }
        return output;
    }
    
    public static int[] quickSort(int[] arr){
        partition(arr, 0, arr.length-1);
        return arr;
    }
    
    private static void partition(int[] arr, int startInd, int endInd) {
        int pivot = startInd+(int)((endInd-startInd)*Math.random());
        //System.out.println(startInd+" "+pivot+" "+endInd);
        int i = startInd;
        int j = endInd;
        if(i >= j){
            return;
        }
        while(i <= pivot && pivot <= j){
            while(arr[i] < arr[pivot]){
                i++;
                //System.out.println((i-1)+" "+arr[i-1]+" "+pivot+" "+arr[pivot]);
            }
            while(arr[j] > arr[pivot]){
                j--;
                //System.out.println((j+1)+" "+arr[i+1]+" "+pivot+" "+arr[pivot]);
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        partition(arr, startInd, j);
        partition(arr, i, endInd);
    }
    
    
    public static int findMax(int[] arr){
        int max = -1;
        if(arr == null){
            return max;
        }
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }



}
