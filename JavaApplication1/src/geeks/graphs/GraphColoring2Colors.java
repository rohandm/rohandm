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
public class GraphColoring2Colors {

    public static void main(String[] args) {
        Graph graph = GraphUtils.generateGraph(10);
        System.out.println(bfsColoring(graph));
    }

    public static boolean bfsColoring(Graph graph) {
        Set<Vertex> vertexSet = graph.map.keySet();
        if (vertexSet.size() <= 0) {
            return false;
        }
        Vertex v = (Vertex) vertexSet.toArray()[0];
        Queue<Vertex> queue = new LinkedList();
        queue.offer(v);
        char toggle = 'R' ^ 'G';
        char parentColor = 'R';
        v.color = 'G';
        Map<Vertex, Vertex> parentMap = new HashMap();
        while (!queue.isEmpty()) {
            v = queue.poll();
            Vertex parent = parentMap.get(v);
            if (parent != null) {
                parentColor = parent.color;
            }
            if (v.color == parent.color) {
                return false;
            }
            v.color = (char) (parentColor ^ toggle);
            List<Edge> list = graph.map.get(v);
            Iterator<Edge> itr = list.iterator();
            while (itr.hasNext()) {
                Vertex neighbour = itr.next().dest;
                queue.offer(neighbour);
                parentMap.put(neighbour, v);
            }
        }
        return true;
    }
}
