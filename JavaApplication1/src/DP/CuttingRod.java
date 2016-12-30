/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class CuttingRod{
	public static void main(String[] args){
		int n = 8;
		int[] priceArr = {3, 5, 8, 9, 10, 17, 17, 20};
		
		int[] costArr = new int[n];
                Arrays.fill(costArr, -1);
                for(int i = 0; i < n && i < priceArr.length; i++){
                    costArr[i] = priceArr[i];
                }
		
		for(int i = 1; i < n; ++i){
			for(int j = 0; j <= i/2; ++j){
				costArr[i] = Math.max(costArr[i], costArr[j]+costArr[i-j-1]);
			}
		}
		System.out.println(costArr[n-1]);
	}
}
