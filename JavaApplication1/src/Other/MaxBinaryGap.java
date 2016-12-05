/*
 * Twitter Codility Problem – Max Binary Gap 
Problem: Get maximum binary Gap.
For example, 9's binary form is 1001, the gap is 2.
 */
package Other;

/**
 *
 * @author rohan_000
 */
public class MaxBinaryGap {
    public static void main(String args[]){
        int n = 9;
        String binVal = Integer.toBinaryString(n);
        int max = 0;
        int startInd = binVal.indexOf("0");
        while(startInd > -1){
            int endInd = binVal.indexOf("1", startInd);
            max = Math.max(max, endInd-startInd);
            startInd = binVal.indexOf("0", endInd);
        }
        System.out.println(max);
                
    }
}
