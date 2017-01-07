/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author ROHANME
 */
public class MinSubSeq4Consecutive{

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int len = arr.length;
		int[] minSumArr = new int[len];
		int minSum = Integer.MAX_VALUE;
		
		for(int i = 0; i < len; ++i){
			minSumArr[i] = Integer.MAX_VALUE;
			for(int j = Math.max(i-4, 0); j < i; ++j){
                                if(minSumArr[j] == Integer.MAX_VALUE){
                                    minSumArr[i] = Math.min(arr[i]+arr[j], minSumArr[i]);
                                }
                                else{
                                    minSumArr[i] = Math.min(arr[i]+minSumArr[j], minSumArr[i]);
                                }
			}
		}
                for(int i = len-4; i < len; ++i){
                    minSum = Math.min(minSum, minSumArr[i]);
                }
		System.out.println(minSum);
	}
}