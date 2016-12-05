/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class RotateArray {
    public static void main(String args[]){
        int k = 4;
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        
        int len = arr.length;
        
        int[] newArr = Arrays.copyOf(arr, len);
        System.arraycopy(arr, k, newArr, 0, len-k);
        System.arraycopy(arr, 0, newArr, len-k, k);
        
        System.out.println(Arrays.toString(newArr));
    }
}
