/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class Graph {

    private void clear() {
        for(Vertex v: vertexMap.values()){
            v.clear();
        }
    }
    private Map<String, Vertex> vertexMap;
    
    public Graph(){
        vertexMap = new HashMap();
    }
    
    public void addEdge(String src, String dest, int weight, boolean directed){
        Vertex srcV = vertexMap.get(src);
        if(srcV == null){
             srcV = new Vertex(src);
             vertexMap.put(src, srcV);
        }
        Vertex destV = vertexMap.get(dest);
        if(destV == null){
            destV = new Vertex(dest);
            vertexMap.put(dest, destV);
        }
        
        
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
        System.out.println("BFS:");
        //graph.bfs(graph.vertexMap.get("1"));
    }
    
    public void dfs(Vertex s){
        LinkedList<Vertex> stack = new LinkedList();
        HashSet<Vertex> visitedMap = new HashSet();
        //visitedMap.add(s);
        
        stack.push(s);
        
        while(!stack.isEmpty()){
            
            Vertex curr = stack.pop();
            //System.out.println(Arrays.toString(curr.getOutgoing().keySet().toArray()));
            if(!visitedMap.contains(curr)){
                visitedMap.add(curr);
                System.out.println(curr.getName());
                Iterator<Vertex> itr = curr.getOutgoing().keySet().iterator();
                while(itr.hasNext()){
                    stack.push(itr.next());
                } 
            }

        }
    }
    
    public void bfs(String s){
        clear();
        Vertex source = vertexMap.get(s);
        Queue<Vertex> queue = new LinkedList();
        queue.add(source);
        source.setDist(0);
        while(!queue.isEmpty()){
            Vertex curr = queue.poll();
            if(!curr.isVisited()){
                curr.setVisited(true);
                System.out.println(curr.getName());
                for(Vertex v: curr.getOutgoing().keySet()){
                    int newDist = curr.getDist() + 1;
                    if(v.getDist() > newDist){
                        v.setDist(newDist);
                        v.setVisitedVertices(curr.getVisitedVertices()+" "+curr.getName());
                        queue.add(v);
                    }
                }
            }
        }
    }
    
    public int shortestDistance(String s, String d){
        bfs(s);
        Vertex dest = vertexMap.get(d);
        for(Vertex v: vertexMap.values()){
            System.out.println(v);
        }
        System.out.println(dest.getDist()+" "+dest.getVisitedVertices());
        return dest.getDist();
    }
        
    public int shortestWtDistance(String s, String d){
        dijkstra(s);
        int dist = vertexMap.get(s).getDist();
        clear();
        return dist;
    }

    private void dijkstra(String s) {
        clear();
        Vertex source = vertexMap.get(s);
        if(source == null){
            return;
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>((a,b) -> a.getDist()-b.getDist());
        source.setDist(0);
        pq.add(source);
        while(!pq.isEmpty()){
            Vertex curr = pq.poll();
            for(Vertex adjV: curr.getOutgoing().keySet()){
                if(adjV.isVisited()){
                    continue;
                }
                adjV.setVisited(true);
                int newDist = curr.getDist() + curr.getOutgoingEdge(adjV).getWeight();
                if(adjV.getDist() > newDist){
                    adjV.setDist(newDist);
                    adjV.setVisitedVertices(curr.getVisitedVertices()+" "+curr.getName());
                    pq.add(adjV);
                }
            }
        }
    }
    
    public boolean isCyclePresent(){
        List<Vertex> markedList = new ArrayList();
        Vertex v = (Vertex)vertexMap.values().toArray()[0];
        LinkedList<Vertex> stack = new LinkedList();
        stack.push(v);
        markedList.add(v);
        while(!stack.isEmpty()){
            Vertex v1 = stack.pop();
            Set<Vertex> vertexList = v1.getOutgoing().keySet();
            for(Vertex v2: vertexList){
                if(markedList.contains(v2)){
                    return true;
                }
                stack.push(v2);
                markedList.add(v2);
            }
        }
        return false;
        
    }
}
