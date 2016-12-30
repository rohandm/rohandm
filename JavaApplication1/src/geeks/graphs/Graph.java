/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public void addEdge(Vertex v, Vertex v1, Edge e, boolean directed) {
        List<Edge> list = map.get(v);
        if (list == null) {
            list = new ArrayList();
            map.put(v, list);
        }
        list.add(e);
        if(!directed){
            List<Edge> list1 = map.get(v1);
            if (list1 == null) {
                list1 = new ArrayList();
                map.put(v1, list1);
            }
            list1.add(e.reverse());
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