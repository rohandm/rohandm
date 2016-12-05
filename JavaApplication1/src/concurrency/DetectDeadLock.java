/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import graphs.Graph;

/**
 *
 * @author rohan_000
 */
public class DetectDeadLock {
    public static void main(String args[]){
        int[] A = new int[]{1, 4, 5};
        int[] B = new int[]{3, 4, 6};
        int[] C = new int[]{2, 5, 1};
        Graph graph = new Graph();
        for(int i = 0; i < A.length-1; i++){
            graph.addEdge(""+A[i], ""+A[i+1], 0, true);
        }
        for(int i = 0; i < B.length-1; i++){
            graph.addEdge(""+B[i], ""+B[i+1], 0, true);
        }
        for(int i = 0; i < C.length-1; i++){
            graph.addEdge(""+C[i], ""+C[i+1], 0, true);
        }
        System.out.println(graph.isCyclePresent());
    }
}
