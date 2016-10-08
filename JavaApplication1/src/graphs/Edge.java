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
    
    Edge(Vertex source, Vertex dest, int weight, boolean directed){
        dest.getIncoming().put(source, this);
        source.getOutgoing().put(dest, this);
        if(!directed){
            source.getIncoming().put(dest, this);
            dest.getOutgoing().put(source, this);
        }
    
    }
}
