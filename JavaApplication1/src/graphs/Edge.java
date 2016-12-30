/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author rohan_000
 */
public class Edge {
    private Vertex source;
    private Vertex dest;
    private int weight;
    private int capacity;
    private boolean directed;

    Edge(Vertex source1, Vertex dest1, int weight1, int capacity1, boolean directed1){
        source = source1;
        dest = dest1;
        weight = weight1;
        capacity = capacity1;
        directed = directed1;
        source.addToOutgoingEdges(dest, this);
        dest.addToIncomingEdges(source, this);
        if(!directed){
            dest.addToOutgoingEdges(source, this);
            source.addToIncomingEdges(dest, this);
        }
    }

    Edge(Edge e) {
        this.source = new Vertex(e.getSource());
        this.dest = new Vertex(e.getDest());
        this.weight = e.weight;
        this.capacity = e.capacity;
        this.directed = e.directed;
        source.addToOutgoingEdges(dest, this);
        dest.addToIncomingEdges(source, this);
        if(!directed){
            dest.addToOutgoingEdges(source, this);
            source.addToIncomingEdges(dest, this);
        }
    }
    /**
     * @return the source
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Vertex source) {
        this.source = source;
    }

    /**
     * @return the dest
     */
    public Vertex getDest() {
        return dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the directed
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * @param directed the directed to set
     */
    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
