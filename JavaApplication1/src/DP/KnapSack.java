/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class KnapSack{
	public static void main(String args[]){
		int[] weights = {2, 3, 6, 7};
		int n = 10;
		int[] numItems = new int[n+1];
		Arrays.fill(numItems, 0);
		for(int i = 0; i < weights.length; ++i){
			if(weights[i] <= n){
				++numItems[weights[i]];
			}
			
		}
		int maxWt = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j < i; j++){
				if(numItems[j] > 0 && numItems[i-j] > 0){
					numItems[i] = Math.max(numItems[i], numItems[j] + numItems[i-j]);
				}
			}
			if(numItems[i] > 0){
				maxWt = i;
			}
		}
		
		System.out.println(maxWt);
                System.out.println(numItems[maxWt]);
	}
}
