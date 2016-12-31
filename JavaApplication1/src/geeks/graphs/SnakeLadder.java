/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ROHANME
 */
public class SnakeLadder {
    public static void main(String[] args){
        Graph graph = new Graph();
        for(int i = 0; i < 24; i++){
            for(int j = 1; i+j <= 24 && j <= 6; j++){
                graph.addEdge(i, i+j, 1, 0, true);
            }
        }
        graph.addEdge(5, 8, 1, 0, true);
        graph.addEdge(20, 29, 1, 0, true);
        graph.addEdge(3, 22, 1, 0, true);
        graph.addEdge(11, 26, 1, 0, true);
        graph.addEdge(27, 1, 1, 0, true);
        graph.addEdge(21, 9, 1, 0, true);
        graph.addEdge(19, 7, 1, 0, true);
        graph.addEdge(17, 4, 1, 0, true);
        List<Vertex> visited = new ArrayList();
        graph.dfs(0, visited);
        Vertex dest = graph.vertexMap.get(24);
        Vertex v = dest;
        StringBuffer strBuff = new StringBuffer(v.name+" ");
        while(v.parent != null){
            v = v.parent;
            strBuff.append(v.name+" ");
        }
        System.out.println(strBuff.reverse().toString());
    }
}
