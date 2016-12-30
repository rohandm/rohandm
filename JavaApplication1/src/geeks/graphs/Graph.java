/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.graphs;

import java.util.*;
/**
 *
 * @author rohan_000
 */
class Vertex {

    String name;
    String color;

    Vertex(String nm) {
        name = nm;
    }

    public String toString() {
        return "name:" + name + " color: " + color;
    }
}

public class Graph {

    Map<Vertex, List<Edge>> map = new HashMap();
    Map<String, Vertex> vertexMap = new HashMap();

    public void addEdge(String src, String dst, int wt, int cp, boolean directed) {
        Vertex source = vertexMap.get(src);
        if(source == null){
            source = new Vertex(src);
            vertexMap.put(src, source);
        }
        Vertex dest = vertexMap.get(dst);
        if(dest == null){
            dest = new Vertex(dst);
            vertexMap.put(dst, dest);
        }
        Edge e = new Edge(source, dest, wt, cp);
        List<Edge> list = map.get(source);
        if (list == null) {
            list = new ArrayList();
            map.put(source, list);
        }
        list.add(e);
        if(!directed){
            List<Edge> list1 = map.get(dest);
            if (list1 == null) {
                list1 = new ArrayList();
                map.put(dest, list1);
            }
            list1.add(e.reverse());
        }
    }
    
    public void bfs(Vertex v, List<Vertex> visited){
        if(v == null || visited == null){
            return;
        }
        Queue<Vertex> queue = new LinkedList();
        queue.add(v);
        visited.add(v);
        while(!queue.isEmpty()){
            Vertex currentV = queue.poll();
            if(currentV != null){
                List<Edge> edgeList = map.get(currentV);
                for(Edge edge: edgeList){
                    if(!visited.contains(edge.dest)){
                        queue.add(edge.dest);
                        visited.add(edge.dest);
                    }
                }
            }
        }
    }
    
    public void dfs(Vertex v, List<Vertex> visited){
        if(v == null || visited == null){
            return;
        }
        Deque<Vertex> stack = new LinkedList();
        stack.push(v);
        visited.add(v);
        while(!stack.isEmpty()){
            Vertex currentV = stack.pop();
            if(currentV != null){
                List<Edge> edgeList = map.get(currentV);
                for(Edge e: edgeList){
                    if(!visited.contains(e.dest)){
                        stack.push(e.dest);
                        visited.add(e.dest);
                    }
                }
            }
        }
    }

    public String toString() {
        //System.out.println(map);
        Iterator<Vertex> itr = map.keySet().iterator();
        String toString = "";
        while (itr.hasNext()) {
            Vertex v = itr.next();
            List<Edge> list = map.get(v);
            toString += list.toString().replaceAll(",", "\n") + "\n";
        }
        return toString;
    }
}

class Edge {

    Vertex source;
    Vertex dest;
    int weight;
    int capacity;

    Edge(Vertex src, Vertex dst, int wt, int cp) {
        source = src;
        dest = dst;
        weight = wt;
        capacity = cp;
    }

    public String toString() {
        return "source: "+source +" dest: " + dest + " weight: " + weight + " capacity: " + capacity;
    }

    Edge reverse() {
        return new Edge(this.dest, this.source, weight, capacity);
    }
}