/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class MinCost {
    public static void main(String args[]){
		matrix = new int[][]{{1,2,3},{4,8,2},{1,5,3}};
		cache = new int[matrix.length][matrix.length];
		for(int[] row: cache){
			Arrays.fill(row, Integer.MAX_VALUE);
		}
                for(int[] row: matrix){
                    System.out.println(Arrays.toString(row));
                }
		System.out.println(findMinCost(0, 0, 2, 1));
	}
	static int[][] matrix;
	static int[][] cache;
	public static int findMinCost(int x1, int y1, int x2, int y2){
		int len = matrix.length;
                if(x1 == x2 && y1 == y2){
                    return matrix[x2][y2];
                }
		if(x1 >= len || y1 >= len || x2 >= len || y2 >= len
			|| x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0){
			return Integer.MAX_VALUE;
		}

		if(cache[x1][y1] < Integer.MAX_VALUE && cache[x1][y1] >= 0){
			return cache[x1][y1];
		}
		int val = matrix[x1][y1]+Math.min(Math.min(findMinCost(x1+1, y1, x2, y2), findMinCost(x1, y1+1, x2, y2)), findMinCost(x1+1, y1+1, x2, y2));
                if(val >= 0 && val < Integer.MAX_VALUE){
                   cache[x1][y1] = val; 
                }
                return cache[x1][y1];
	}
}

