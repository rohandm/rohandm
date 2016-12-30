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
public class Graph {
    Map<String, Vertex> vertexMap = new HashMap();
    List<Edge> edgeList = new ArrayList();
    Map<Vertex, Vertex> parentMap = new HashMap();
    
    
    public static void main(String args[]){
        //Graph graph = GraphUtil.generateGraph(20, true);
        //List<String> list = new ArrayList(graph.vertexMap.keySet());
        //System.out.println(graph.maxFlow(list.get(0), list.get(15)));
        Graph graph = new Graph();
        graph.addEdge("S", "V1", 0, 13, true);
        graph.addEdge("V1", "V2", 0, 5, true);
        graph.addEdge("V2", "D", 0, 3, true);
        graph.addEdge("S", "V3", 0, 10, true);
        graph.addEdge("V3", "V4", 0, 35, true);
        graph.addEdge("V4", "D", 0, 20, true);
        graph.addEdge("V2", "V3", 0, 50, true);
        System.out.println(graph.vertexMap);
        System.out.println(graph.maxFlow("S", "D"));
    }
    
    Graph(Graph origGraph){
        for(Edge e: origGraph.edgeList){
            this.addEdge(new Edge(e));
        }
    }

    Graph() {
    }
    
    public void addEdge(String source, String dest, int weight1, int capacity1, boolean directed1){
        Vertex source1 = vertexMap.get(source);
        if(source1 == null){
            source1 = new Vertex(source);
            vertexMap.put(source, source1);
        }
        Vertex dest1 = vertexMap.get(dest);
        if(dest1 == null){
            dest1 = new Vertex(dest);
            vertexMap.put(dest, dest1);
        }
        Edge e = new Edge(source1, dest1, weight1, capacity1, directed1);
        edgeList.add(e);
    }

    public int maxFlow(String source, String sink) {
        Graph residualGraph = new Graph(this);
        Vertex src = vertexMap.get(source);
        Vertex snk = vertexMap.get(sink);
        int maxFlow = 0;
        while(residualGraph.bfs(source, sink)){
            int pathFlow = Integer.MAX_VALUE;
            Vertex v1 = residualGraph.vertexMap.get(sink);
            Vertex v = residualGraph.parentMap.get(v1);
            Vertex rSrc = residualGraph.vertexMap.get(source);
            System.out.println(residualGraph.parentMap);
            while(!Objects.equals(v1, rSrc)){
                 System.out.println(v +" "+v1);
                int capacity = v1.getIncomingEdges().get(v).getCapacity();
                pathFlow = Math.min(capacity, pathFlow);
                v1 = v;
                v = residualGraph.parentMap.get(v1);
            }
            
            v = parentMap.get(snk);
            v1 = snk;
            while(!Objects.equals(v1, rSrc)){
                System.out.println(v1.getIncomingEdges());
                int capacity = v1.getIncomingEdges().get(v).getCapacity();
                if(capacity == pathFlow){
                    residualGraph.removeEdge(v1.getIncomingEdges().get(v));
                }
                else{
                    v1.getIncomingEdges().get(v).setCapacity(capacity-pathFlow);
                }
                v1 = v;
                v = residualGraph.parentMap.get(v1);
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }
    
    public boolean bfs(String src, String dest){
        parentMap.clear();
        Vertex source = vertexMap.get(src);
        List<String> visited = new ArrayList();
        Queue<Vertex> queue = new LinkedList();
        queue.add(source);
        parentMap.put(source, null);
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            visited.add(v.getValue());
            v.getOutgoingEdges().keySet().forEach(v1 -> {
                if(!visited.contains(v1.getValue())){
                    queue.add(v1);
                    parentMap.put(v1, v);
                }
            });
        }
        //System.out.println(visited);
        //System.out.println(parentMap);
        if(visited.contains(dest)){
            return true;
        }
        return false;
    }

    private void addEdge(Edge edge) {
        addEdge(edge.getSource().getValue(), edge.getDest().getValue(), edge.getWeight(), edge.getCapacity(), edge.isDirected());
    }
}
