/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * @author rohan_000
 */
public class Graph1 {
    int[][] matrix;
    int[] parent;
    boolean[] visited;
    int[] dist;
    static final int N = Integer.MIN_VALUE;
    
    public static void main(String args[]){
        int min = Integer.MIN_VALUE;
        int n = 5;
        int[][] arr = {{N, 4, N, N, N, N, N, 8, N},
                      {4, N, 8, N, N, N, N, 11, N},
                      {N, 8, N, 7, N, 4, N, N, 2},
                      {N, N, 7, N, 9, 14, N, N, N},
                      {N, N, N, 9, N, 10, N, N, N},
                      {N, N, 4, 14, 10, N, 2, N, N},
                      {N, N, N, N, N, 2, N, 1, 6},
                      {8, 11, N, N, N, N, 1, N, 7},
                      {N, N, 2, N, N, N, 6, 7, N}
                     };
        Graph1 graph = new Graph1(arr);
        int[][] residualMatrix = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            residualMatrix[i] = Arrays.copyOf(arr[i], arr.length);
        }
        Graph1 residualGraph = new Graph1(residualMatrix);
        //System.out.println(graph.maxFlow(0, 5, residualGraph));
        for(int[] row:arr){
            System.out.println(Arrays.toString(row));
        }
        //graph.minCut(0, 5, residualGraph);
        //int[][] dist1 = graph.floydWarshall();
        graph.bellmanFord(0);
        System.out.println();
        //System.out.println(Arrays.toString(dist1[0]));
        System.out.println(Arrays.toString(graph.parent));
        System.out.println(Arrays.toString(graph.dist));
    }
    
    Graph1(int[][] arr){
        matrix = arr;
        parent = new int[arr.length];
        visited = new boolean[arr.length];
        dist = new int[matrix.length];
    }

    public int maxFlow(int src, int sink, Graph1 residualGraph) {
        
        int maxFlow = 0;
        residualGraph.bfs(src);
        while(residualGraph.visited[sink]){
            int pathFlow = Integer.MAX_VALUE;
            for(int v = sink; v != src; v=residualGraph.parent[v]){
                int u = residualGraph.parent[v];
                pathFlow = Math.min(pathFlow, residualGraph.matrix[u][v]);
            }
            for(int v = sink; v != src; v=residualGraph.parent[v]){
                int u = residualGraph.parent[v];
                residualGraph.matrix[u][v] -= pathFlow;
                residualGraph.matrix[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
            residualGraph.bfs(src);
        }
        return maxFlow;
    }
    
    public void bfs(int src){
        Queue<Integer> queue = new LinkedList();
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        queue.add(src);
        visited[src] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i = 0; i < matrix[v].length; i++){
                if(!visited[i] && matrix[v][i] > N){
                    queue.add(i);
                    parent[i] = v;
                    visited[i] = true;
                }
            }
        }
    }

    private void minCut(int src, int sink, Graph1 residualGraph) {
        maxFlow(src, sink, residualGraph);
        residualGraph.dfs(src);
        for(int i = 0; i < residualGraph.matrix.length; i++){
            for(int j = 0; j < residualGraph.matrix.length; j++){
                if(visited[i] && !visited[j] && matrix[i][j] > N){
                    System.out.println(i+" --"+matrix[i][j]+"-> "+j);
                }
            }
        }
    }

    private void dfs(int src) {
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack();
        stack.push(src);
        visited[src] = true;
        while(!stack.isEmpty()){
            int v = stack.pop();
            for(int i = 0; i < matrix[v].length; i++){
                if(!visited[i] && matrix[v][i] > N){
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
    
    public void dijkstra(int src){
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        List<Integer> list = new ArrayList();
        list.add(src);
        while(!list.isEmpty()){
            int v = list.remove(0);
            visited[v] = true;
            for(int i = 0; i < matrix.length; i++){
                if(!visited[i] && matrix[v][i] > N && dist[i] > dist[v]+matrix[v][i]){
                    dist[i] = dist[v]+matrix[v][i];
                    parent[i] = v;
                    list.add(i);
                }
            }
            list.sort((t1, t2) -> dist[t1]-dist[t2]);
        }
   }
    
    public void bellmanFord(int src){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        //Arrays.fill(visited, false);
        dist[src] = 0;
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = 0; j < matrix.length; j++){
                for(int k = 0; k < matrix.length; k++){
                    if(matrix[j][k] > N && dist[k] > dist[j]+matrix[j][k]){
                        dist[k] = dist[j] + matrix[j][k];
                        parent[k] = j;
                    }
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] > Integer.MIN_VALUE && dist[j] > dist[i]+matrix[i][j]){
                    System.out.println("Negative cycle detected");
                }
            }
        }
    }
    
    public int[][] floydWarshall(){
        Arrays.fill(parent, -1);
        int[][] dist1 = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i == j){
                    dist1[i][j] = 0;
                }
                else if(matrix[i][j] == N){
                    dist1[i][j] = Integer.MAX_VALUE;
                }
                else{
                    dist1[i][j] = matrix[i][j];
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                for(int k = 0; k < matrix.length; k++){
                    if(dist1[j][i] == Integer.MAX_VALUE || dist1[k][i] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(dist1[j][k] > dist1[j][i] + dist1[k][i]){
                        dist1[j][k] = dist1[j][i] + dist1[k][i];
                    }
                }
            }
        }
        return dist1;
    }
}
