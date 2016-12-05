/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.HashMap;

/**
 *
 * @author rohan_000
 */
public class Vertex {
    private HashMap<Vertex, Edge> incoming = new HashMap<Vertex, Edge>();
    private HashMap<Vertex, Edge> outgoing = new HashMap<Vertex, Edge>();
    private String name = "";
    private int dist = Integer.MAX_VALUE;
    private boolean visited = false;
    private String visitedVertices = "";

    Vertex(String src){
        name = src;
    }
    
    public void clear(){
        setDist(Integer.MAX_VALUE);
        setVisited(false);
        setVisitedVertices("");
    }
    /**
     * @return the incoming
     */
    public Edge getIncommingEdge(Vertex v) {
        return getIncoming().get(v);
    }

    /**
     * @param incoming the incoming to set
     */
    public void addIncomingEdge(Vertex v, Edge e) {
        this.getIncoming().put(v, e);
    }

    /**
     * @return the outgoing
     */
    public Edge getOutgoingEdge(Vertex v) {
        return getOutgoing().get(v);
    }

    /**
     * @param outgoing the outgoing to set
     */
    public void addOutgoingEdge(Vertex v, Edge e)  {
        this.getOutgoing().put(v, e);
    }

    /**
     * @return the incoming
     */
    public HashMap<Vertex, Edge> getIncoming() {
        return incoming;
    }

    /**
     * @param incoming the incoming to set
     */
    public void setIncoming(HashMap<Vertex, Edge> incoming) {
        this.incoming = incoming;
    }

    /**
     * @return the outgoing
     */
    public HashMap<Vertex, Edge> getOutgoing() {
        return outgoing;
    }

    /**
     * @param outgoing the outgoing to set
     */
    public void setOutgoing(HashMap<Vertex, Edge> outgoing) {
        this.outgoing = outgoing;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dist
     */
    public int getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(int dist) {
        this.dist = dist;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the visitedVertices
     */
    public String getVisitedVertices() {
        return visitedVertices;
    }

    @Override
    public String toString() {
        return "Vertex{" + "name=" + name + ", dist=" + dist + ", visitedVertices=" + visitedVertices + '}';
    }

    /**
     * @param visitedVertices the visitedVertices to set
     */
    public void setVisitedVertices(String visitedVertices) {
        this.visitedVertices = visitedVertices;
    }
            
}
