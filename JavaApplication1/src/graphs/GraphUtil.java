/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author rohan_000
 */
public class GraphUtil {
    public static Graph generateGraph(int n, boolean directed){
        Graph graph = new Graph();
        int maxWeight = 10;
        int maxCapacity = 10;
        for(int i = 0; i < n; i++){
            String src = ""+(char)('A' + (int)(26*Math.random()));
            String dest = ""+(char)('A' + (int)(26*Math.random()));
            int weight = (int)(maxWeight*Math.random());
            int capacity = (int)(maxCapacity*Math.random());
            graph.addEdge(src, dest, weight, capacity, directed);
        }
        return graph;
    }
}
