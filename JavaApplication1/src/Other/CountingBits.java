/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:

For num = 5 you should return [0,1,1,2,1,2].
 */
package Other;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class CountingBits {
    public static void main(String args[]){
        int n = 5;
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(powOf2(i)){
                arr[i] = 1;
            }
            else if(n%2 == 1){
                arr[i] = arr[i-1]+1;
            }
            else{
                arr[i] = arr[i-1];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static boolean powOf2(int n) {
        if(n > 0 && (n&(n-1)) == 0){
            return true;
        }
        return false;
    }
}
