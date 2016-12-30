/*
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the intgers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class MaxSumIncSeq{
	public static void main(String[] args){
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		
		int[] maxSeqSum = new int[arr.length];
		Arrays.fill(maxSeqSum, 1);
		int max = 0;
		for(int i = 0; i < arr.length; ++i){
			for(int j = 0; j < i; ++j){
				if(arr[i] > arr[j]&& maxSeqSum[i] < maxSeqSum[j]+arr[i]){
					maxSeqSum[i] = maxSeqSum[j]+arr[i];
				}
			}
			max = Math.max(max, maxSeqSum[i]);
		}
		System.out.println(max);
	}
}
