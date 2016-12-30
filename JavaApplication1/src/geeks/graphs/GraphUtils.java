/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ROHANME
 */
public class GraphUtils {

    public static Graph generateGraph(int n) {
        Graph graph = new Graph();
        Vertex[] vertexArr = new Vertex[n];
        /*for (int i = 0; i < n; i++) {
            vertexArr[i] = new Vertex("" + i);
        }*/
        char[][] arr = new char[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                arr[i][j] = ' ';
                if (i != j) {
                    int temp = rand.nextInt(n) - 8;
                    if (temp > 0) {
                        int temp1 = rand.nextInt(n / 2);
                        //Edge e = new Edge(vertexArr[i], vertexArr[j], temp, temp1);
                        //System.out.println(i+" "+j);
                        graph.addEdge(""+i, ""+j, temp, temp1, false);
                        arr[i][j] = 'E';
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arr).replaceAll("],", "]\n"));
        return graph;
    }
    
    public static Graph complementGraph(Graph graph){
        System.out.println("ComplementGraph start");
        Graph complementGraph = new Graph();
        List<String> vertexMappings = new ArrayList();
        for(List<Edge> edgeList: graph.map.values()){
            for(Edge edge: edgeList){
                vertexMappings.add(edge.source.name+"_"+edge.dest.name);
            }
        }
        for(Vertex v: graph.vertexMap.values()){
            for(Vertex v1: graph.vertexMap.values()){
                if(v != null && v1 != null && v1 != v && !vertexMappings.contains(v.name+"_"+v1.name)){
                    complementGraph.addEdge(v.name, v1.name, 1, 1, false);
                }
            }
        }
        System.out.println("ComplementGraph end");
        return complementGraph;
    }
}


