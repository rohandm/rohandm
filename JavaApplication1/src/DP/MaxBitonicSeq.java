/*
Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class MaxBitonicSeq{
	public static void main(String[] args){
		int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		
		int[] maxIncSeqLeft = new int[arr.length];
		int[] maxDecSeqLeft = new int[arr.length];
                int[] maxIncSeqRight = new int[arr.length];
		int[] maxDecSeqRight = new int[arr.length];
		Arrays.fill(maxIncSeqLeft, 1);
		Arrays.fill(maxDecSeqLeft, 1);
                Arrays.fill(maxIncSeqRight, 1);
                Arrays.fill(maxDecSeqRight, 1);
		int max = 0;
		for(int i = 0; i < arr.length; ++i){
			for(int j = 0; j < i; ++j){
				if(arr[i] > arr[j]){
                                    maxIncSeqLeft[i] = Math.max(maxIncSeqLeft[i], maxIncSeqLeft[j]+1);
				}
                                if(arr[i] < arr[j]){
                                    maxDecSeqLeft[i] = Math.max(maxDecSeqLeft[i], maxDecSeqLeft[j]+1);
                                }
			}
                }
                
                for(int i = arr.length-1; i >= 0; --i){
                        for(int j = arr.length-1; j > i; --j){
                            	if(arr[i] > arr[j]){
					maxDecSeqRight[i] = Math.max(maxDecSeqRight[i], maxDecSeqRight[j]+1);
				}
                                if(arr[i] < arr[j]){
					maxIncSeqRight[i] = Math.max(maxIncSeqRight[i], maxIncSeqRight[j]+1);
				}
                        }
		}
                for(int i = 0; i < arr.length; ++i){
                    	max = Math.max(max, maxIncSeqLeft[i]+maxDecSeqRight[i]-1);
                        max = Math.max(max, maxIncSeqRight[i]+maxDecSeqLeft[i]-1);
                }
                System.out.println(Arrays.toString(maxIncSeqLeft));
                System.out.println(Arrays.toString(maxDecSeqLeft));
                System.out.println(Arrays.toString(maxDecSeqRight));
                System.out.println(Arrays.toString(maxIncSeqRight));
                
		System.out.println(max);
	}
}
