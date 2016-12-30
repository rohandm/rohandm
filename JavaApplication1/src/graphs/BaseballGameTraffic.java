/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class BaseballGameTraffic {
    static int N = Integer.MIN_VALUE;
    public static void main(String args[]){
        int[][] arr = {{0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 0}
                     };
        int[] cityPop = new int[arr.length];
        cityPop[0] = 1; cityPop[1] = 2; cityPop[2] = 3; cityPop[3] = 4; cityPop[4] = 5;
        System.out.println(Arrays.toString(bfs(arr, cityPop, 0)));
    }
    
    public static int[] bfs(int[][] arr, int[] cityPop, int dest){
        int[] traffic = new int[arr.length];
        int[] neighbour = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList();
        queue.add(dest);
        visited[dest] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i = 0; i < arr.length; i++){
                if(!visited[i] && arr[i][v] > 0){
                    queue.add(i);
                    if(v == dest){
                        neighbour[i] = i;
                    }
                    else{
                        neighbour[i] = neighbour[v];
                    }
                    visited[i] = true;
                    traffic[neighbour[i]] += cityPop[i];
                }
            }
        }
        return traffic;
    }
}
