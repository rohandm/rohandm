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
public class Vertex {
    private String value;
    private Map<Vertex, Edge> outgoingEdges;
    private Map<Vertex, Edge> incomingEdges;

    Vertex(String val){
        value = val;
        outgoingEdges = new HashMap<>();
        incomingEdges = new HashMap<>();
    }

    Vertex(Vertex source) {
        this.value = source.value;
        outgoingEdges = new HashMap<>();
        incomingEdges = new HashMap<>();
    }
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the map
     */
    public Edge getEdge(Vertex v) {
        return getOutgoingEdges().get(v);
    }

    /**
     * @param map the map to set
     */
    public void addToMap(Vertex v, Edge e) {
        this.getOutgoingEdges().put(v, e);
    }

    /**
     * @return the outgoingEdges
     */
    public Map<Vertex, Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    /**
     * @param outgoingEdges the outgoingEdges to set
     */
    public void addToOutgoingEdges(Vertex v, Edge e){
        this.outgoingEdges.put(v, e);
    }

    /**
     * @return the incomingEdges
     */
    public Map<Vertex, Edge> getIncomingEdges() {
        return incomingEdges;
    }

    /**
     * @param incomingEdges the incomingEdges to set
     */
    public void addToIncomingEdges(Vertex v, Edge e) {
        this.incomingEdges.put(v, e);
    }
}
