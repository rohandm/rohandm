/*
Given a sequence, find the length of the longest palindromic subsequence in it.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class LongestPalindromicSequence{
	public static void main(String[] args){
		String str = "andjfdjjdfhjhja";
		
		char[] chArr = str.toCharArray();

		
		System.out.println(maxPalindromicSeq(chArr, 0, chArr.length-1));
	}
        static Map<String, Integer> map = new HashMap();
        public static int maxPalindromicSeq(char[] chArr, int startInd, int endInd){
            	if(startInd > endInd){
                    return 0;
                }
                if(startInd == endInd){
                    return 1;
                }
                String key = startInd+"_"+endInd;
                Integer value = map.get(key);
                if(value != null){
                    return value;
                }
                if(chArr[startInd] == chArr[endInd]){
                    return 2+maxPalindromicSeq(chArr, startInd+1, endInd-1);
                }
                else{
                    return Math.max(maxPalindromicSeq(chArr, startInd+1, endInd),       
                    maxPalindromicSeq(chArr, startInd, endInd-1));
                }
        }
}
