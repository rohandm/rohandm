/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.graphs;

import java.util.*;

/**
 *
 * @author ROHANME
 */
public class TopologicalSort {
    
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addEdge(5, 0, 0, 0, true);
        graph.addEdge(4, 0, 0, 0, true);
        graph.addEdge(4, 1, 0, 0, true);
        graph.addEdge(5, 2, 0, 0, true);
        graph.addEdge(2, 3, 0, 0, true);
        graph.addEdge(3, 1, 0, 0, true);
        Deque<Vertex> visited = new LinkedList();
        topologicalSort(graph, visited);
        System.out.println(visited);
    }
    public static void topologicalSort(Graph graph, Deque<Vertex> visited){
        Queue<Vertex> vList = new LinkedList(graph.map.keySet());
        if(vList.size() == 0){
            return;
        }
        
        Deque<Vertex> stack = new LinkedList();
        while(!vList.isEmpty()){
            Vertex v = vList.peek();
            if(visited.contains(v)){
                visited.remove(v);
                continue;
            }
            stack.push(v);
            while(!stack.isEmpty()){
                Vertex v1 = stack.peek();
                List<Edge> edgeList = graph.map.get(v1);
                boolean flag = true;
                if(edgeList != null){
                    for(Edge e: edgeList){
                        if(stack.contains(e.dest)){
                            System.out.println("Not a DAG");
                            return;
                        }
                        if(!visited.contains(e.dest)){
                            flag = false;
                            stack.push(e.dest);
                        }
                    }
                }
                if(flag){
                    stack.pop();
                    visited.offerFirst(v1);
                    vList.remove(v1);
                }
            }
        }
    }
}
