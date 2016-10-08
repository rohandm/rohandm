package DP;

import java.util.Arrays;
public class ZigZag{
    public static int longestZigZag(int[] sequence){
       int max = 0;
        if(sequence.length == 1){
            return 1;
        }
        int[] seqLen = new int[sequence.length];
        int[] lastDiff = new int[sequence.length];
        Arrays.fill(seqLen, 1);
        for(int i = 0; i < seqLen.length; i++){
            for(int j = 0; j < i; j++){
                if(sequence[i] != sequence[j] && (lastDiff[j] == 0 || lastDiff[j]*(sequence[i] - sequence[j]) < 0)){
                    seqLen[i] = Math.max(seqLen[i], seqLen[j]+1);
                    lastDiff[i] = sequence[i]-sequence[j];
                }    
            }
            max = Math.max(seqLen[i], max);
        }
        return max;
    }
    
    public static void main(String args[]){
        System.out.println(longestZigZag(new int[]{1, 7, 4, 9, 2, 5}));
    }
}