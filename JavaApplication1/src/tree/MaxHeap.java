/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class MaxHeap {
    private int size;
    private int[] arr;
    private int lastInd;
    
    public static void main(String args[]){
        int n = 3;
        MaxHeap maxHeap = new MaxHeap(n);
        for(int i = 0; i < maxHeap.size; i++){
            int k = (int)(20*Math.random());
            System.out.print(k+" ");
            maxHeap.add(k);
        }
         System.out.println();
        for(int i = 0; i < maxHeap.size; i++){
            maxHeap.remove();
        }
        System.out.println("\n"+Arrays.toString(maxHeap.arr));
    }
    
    MaxHeap(int num){
        size = (int)Math.pow(2, num)-1;
        arr = new int[size];
        lastInd = 0;
    }
    
    public boolean add(int el){
        if(lastInd >= size-1 && el < arr[lastInd]){
            return false;
        }
        if(lastInd < size-1){
            arr[++lastInd] = el;
        }
        arr[lastInd] = el;
        siftUp();
        System.out.println(Arrays.toString(arr));
        return true;
    }
    
    public int remove(){
        int el = arr[0];
        arr[0] = arr[lastInd];
        arr[lastInd] = 0;
        lastInd--;
        siftDown();
        System.out.println(Arrays.toString(arr));
        return el;
    }

    private void siftUp() {
        int p1 = lastInd;
        int p = (lastInd-1)/2;
        while(p >= 0 && arr[p1] > arr[p]){
            int temp = arr[p1];
            arr[p1] = arr[p];
            arr[p] = temp;
            p1 = p;
            p = (p-1)/2;
        }
    }

    private void siftDown() {
        int i = 0;
        int j = 2*i+2;
        while(j <= lastInd && arr[i] < Math.max(arr[j-1], arr[j])){
            if(arr[j-1] > arr[j]){
                j = j-1;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i = j;
            j = 2*i+2;
        }
    }
}
