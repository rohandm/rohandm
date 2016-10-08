/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rohan_000
 */
public class Graph {
    private Map<String, Vertex> vertexMap;
    
    Graph(){
        vertexMap = new HashMap();
    }
    
    public void addEdge(String src, String dest, int weight, boolean directed){
        Vertex srcV = new Vertex(src);
        vertexMap.put(src, srcV);
        Vertex destV = new Vertex(dest);
        vertexMap.put(dest, destV);
        
        Edge edge = new Edge(srcV, destV, weight, directed);
    }

    /**
     * @return the vertexList
     */
    public Map<String, Vertex> getVertexList() {
        return vertexMap;
    }

    /**
     * @param vertexList the vertexList to set
     */
    public void setVertexList(Map<String, Vertex> vertexList) {
        this.vertexMap = vertexList;
    }
    
    public static void main(String args[]){
        Graph graph = new Graph();
        graph.addEdge("1", "2", 3, false);
        graph.addEdge("2", "3", 2, false);
        graph.addEdge("3", "4", 1, false);
        graph.addEdge("1", "4", 6, false);
        graph.addEdge("3", "5", 4, false);
        graph.addEdge("4", "6", 3, false);
        graph.addEdge("6", "7", 3, false);
        graph.addEdge("5", "8", 2, false);
        graph.dfs(graph.vertexMap.get("1"));
    }
    
    public void dfs(Vertex s){
        LinkedList<Vertex> stack = new LinkedList();
        HashMap<Vertex, Boolean> visitedMap = new HashMap();
        visitedMap.put(s, true);
        
        stack.push(s);
        
        while(!stack.isEmpty()){
            
            Vertex curr = stack.pop();
            if(!visitedMap.get(curr).booleanValue()){
                visitedMap.put(curr, Boolean.TRUE);
                System.out.println(curr.getName());
                Iterator<Vertex> itr = curr.getOutgoing().keySet().iterator();
                while(itr.hasNext()){
                    stack.push(itr.next());
                } 
            }

        }
    }
}
