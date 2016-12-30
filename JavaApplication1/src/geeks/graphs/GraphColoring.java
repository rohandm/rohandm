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
public class GraphColoring {

    public static void main(String[] args) {
        //Graph graph = GraphUtils.generateGraph(10);
        /*Graph graph = new Graph();
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Edge e12 = new Edge(v1, v2, 1, 1);
        Edge e13 = new Edge(v1, v3, 1, 1);
        Edge e24 = new Edge(v2, v4, 1, 1);
        Edge e34 = new Edge(v3, v4, 1, 1);
        graph.addEdge(v1, v2, e12, false);
        graph.addEdge(v1, v3, e13, false);
        graph.addEdge(v2, v4, e24, false);
        graph.addEdge(v3, v4, e34, false);
        System.out.println(bfsColoring(graph));*/
        Graph graph = new Graph();
        graph.addEdge("1", "2", 1, 1, false);
        graph.addEdge("1", "3", 1, 1, false);
        graph.addEdge("2", "3", 1, 1, false);
        graph.addEdge("2", "4", 1, 1, false);
        graph.addEdge("3", "4", 1, 1, false);
        graph.addEdge("4", "5", 1, 1, false);
        Graph graph1 = GraphUtils.complementGraph(graph);
        System.out.println(checkIfBipartite(graph1));
        System.out.println(graph1);
    }

    public static boolean checkIfBipartite(Graph graph){
        return bfsColoring(graph);
    }
    //2 color
    public static boolean bfsColoring(Graph graph) {
        Set<Vertex> vertexSet = graph.map.keySet();
        if (vertexSet.size() <= 0) {
            return false;
        }
        Vertex v = (Vertex) vertexSet.toArray()[0];
        Queue<Vertex> queue = new LinkedList();
        List<Vertex> visited = new ArrayList();
        queue.offer(v);
        String[] color = {"Red", "Green"};
        int parentColorInd = 0;
        v.color = color[1-parentColorInd];
        Map<Vertex, Integer> parentMap = new HashMap();
        while (!queue.isEmpty()) {
            v = queue.poll();
            if(v == null){
                continue;
            }
            Integer parentColorIndWrapper = parentMap.get(v);
            if (parentColorIndWrapper != null) {
                parentColorInd = parentColorIndWrapper;
                if (v.color == color[parentColorIndWrapper]) {
                    return false;
                }
            }
            v.color =  color[1-parentColorInd];
            List<Edge> list = graph.map.get(v);
            if(list != null){
                Iterator<Edge> itr = list.iterator();
                while (itr.hasNext()) {
                    Vertex neighbour = itr.next().dest;
                    if(neighbour != null && !visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                        parentMap.put(neighbour, 1-parentColorInd);
                    }
                }
            }
        }
        return true;
    }
    
    //more than 2 color, NP-Complete, approximation, greedy algo, doesn't give min colors
    public static void greedyColoring(Graph graph){
        String[] colors = {"Red", "Green", "Blue", "Black", "Grey", "Yellow", "Purple", "Brown", "White"};
        Set<Vertex> vertexSet = graph.map.keySet();
        if(vertexSet.size() <= 0){
            return;
        }
        Vertex v = (Vertex)vertexSet.toArray()[0];
        v.color = colors[0];
        Queue<Vertex> queue = new LinkedList();
        queue.offer(v);
        List<String> list;
        List<Vertex> visited = new ArrayList();
        while(!queue.isEmpty()){
            v = queue.poll();
            visited.add(v);
            List<Edge> edgeList = graph.map.get(v);
            if(v.color == null || v.color.length() == 0){
                list = new ArrayList(Arrays.asList((colors)));
                for(Edge e: edgeList){
                    list.remove(e.dest.color);
                }
                if(!list.isEmpty()){
                    v.color = list.remove(0);
                }
            }
             for(Edge e: edgeList){
                if(!visited.contains(e.dest)){
                    queue.offer(e.dest);
                }
            }
        }
    }
}
