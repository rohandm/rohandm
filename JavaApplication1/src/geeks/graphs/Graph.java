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
class Vertex implements Comparable{

    int name;
    String color;
    int dist = Integer.MAX_VALUE;
    Vertex parent;

    Vertex(int nm) {
        name = nm;
    }

    public String toString() {
        return "name:" + name + " color: " + color;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null || o.getClass() != this.getClass()){
            return -1;
        }
        Vertex v = (Vertex)o;
        return this.dist - v.dist;
    }
}

public class Graph {

    Map<Vertex, List<Edge>> map = new HashMap();
    Map<Integer, Vertex> vertexMap = new HashMap();

    public void addEdge(int src, int dst, int wt, int cp, boolean directed) {
        Vertex source = vertexMap.get(src);
        if(source == null){
            source = new Vertex(src);
            map.put(source, new ArrayList());
            vertexMap.put(src, source);
        }
        Vertex dest = vertexMap.get(dst);
        if(dest == null){
            dest = new Vertex(dst);
            map.put(dest, new ArrayList());
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
    
    public void bfs(int src, List<Vertex> visited){
        Vertex v = vertexMap.get(src);
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
    
    public void dfs(int src, List<Vertex> visited){
        Vertex v = vertexMap.get(src);
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
                        e.dest.parent = currentV;
                        stack.push(e.dest);
                        visited.add(e.dest);
                    }
                }
            }
        }
    }
    
    public List<Vertex> dijkstra(int src){
        Vertex source = vertexMap.get(src);
        List<Vertex> visited = new ArrayList();
        if(source == null){
            return visited;
        }
        for(Vertex v: this.vertexMap.values()){
            v.dist = Integer.MAX_VALUE;
        }
        source.dist = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue();
        while(!pq.isEmpty()){
            Vertex v = pq.poll();
            visited.add(v);
            if(v == null || visited.contains(v)){
                continue;
            }
            List<Edge> edgeList = this.map.get(v);
            for(Edge e: edgeList){
                if(!visited.contains(e.dest)){
                    if(e.dest.dist > v.dist+e.weight){
                        e.dest.dist = v.dist+e.weight;
                    }
                    pq.offer(e.dest);
                }
            }
        }
        return visited;
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