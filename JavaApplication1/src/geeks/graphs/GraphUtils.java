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
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author ROHANME
 */
public class GraphUtils {

    public static Graph generateGraph(int n) {
        Graph graph = new Graph();
        Vertex[] vertexArr = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexArr[i] = new Vertex("" + i);
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int temp = rand.nextInt(n) - n / 2;
                    if (temp > 0) {
                        int temp1 = rand.nextInt(n / 2);
                        Edge e = new Edge(vertexArr[i], vertexArr[j], temp, temp1);
                        graph.addEdge(vertexArr[i], e);
                    }
                }
            }
        }
        return graph;
    }
}

class Vertex {

    String name;
    char color;

    Vertex(String nm) {
        name = nm;
    }

    public String toString() {
        return name + " color: " + color;
    }
}

class Graph {

    Map<Vertex, List<Edge>> map = new HashMap();

    public void addEdge(Vertex v, Edge e) {
        List<Edge> list = map.get(v);
        if (list == null) {
            list = new ArrayList();
            map.put(v, list);
        }
        list.add(e);
    }

    public String toString() {
        Iterator<Vertex> itr = map.keySet().iterator();
        String toString = "";
        while (itr.hasNext()) {
            Vertex v = itr.next();
            List<Edge> list = map.get(v);
            toString = list.toString() + "\n";
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
        return source + " " + dest + " " + weight + " " + capacity;
    }
}
