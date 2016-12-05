/*
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
package Other;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 *
 * @author rohan_000
 */
public class SingleNumber {
   public static void main(String args[]){
       int[] arr = new int[]{ 3, 5, 1, 7, 3, 1, 7};
       singleNumberInDoubles1(arr);
       singleNumberInDoubles2(arr);  
       int[] arr1 = new int[]{1, 5, 6, 1, 8, 7, 5, 1, 6, 7, 8, 6, 5, 7};
       singleNumberInN(arr1, 3);
   } 
   
    private static int singleNumberInN(int[] arr1, int mod) {
        int INT_SIZE = 32;
        int retVal = 0;
        int bitMask = 0;
        for(int i = 0; i < 32; ++i){
            bitMask = 1 << i;
            int sum = 0;
            for(int j = 0; j < arr1.length; ++j){
                sum += (arr1[j]&bitMask);
            }
            if(sum%mod > 0){
                retVal |= bitMask;
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    private static void singleNumberInDoubles1(int[] arr) {
        System.out.println(Arrays.stream(arr).reduce((a,b) -> a^b).getAsInt());
    }

    private static void singleNumberInDoubles2(int[] arr) {
        int[] newArr = new int[Arrays.stream(arr).max().getAsInt()+1];  
       Arrays.stream(arr).forEach(i -> ++newArr[i]);
       IntPredicate hasValue1 = (i) -> newArr[i] == 1;
       System.out.println(IntStream.range(0, newArr.length).filter(hasValue1).max().getAsInt());
    }

    private static void singleNumberInTriples1(int[] arr) {
        int[] newArr = new int[Arrays.stream(arr).max().getAsInt()+1];
        Arrays.stream(arr).forEach(i -> newArr[i]++);
        IntPredicate lessThan3 = n -> newArr[n] < 3;
        System.out.println(IntStream.range(0, newArr.length).filter(lessThan3).max().getAsInt());
    }


}
