/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author rohan_000
 */
public class BinaryTreeNode {
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;
    private BinaryTreeNode parentNode;
    private int value;
    private int x;
    private int y;

    BinaryTreeNode(int key) {
        value = key;
    }

    /**
     * @return the leftNode
     */
    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
        if(leftNode != null){
            leftNode.setParentNode(this);
        }
    }

    /**
     * @return the rightNode
     */
    public BinaryTreeNode getRightNode() {
        return rightNode;
    }
    
    public void addNode(BinaryTreeNode subNode){
        if(subNode == null){
            return;
        }
        int subNodeValue = subNode.getValue();
        if(subNodeValue <= this.getValue()){
            addLeftNode(subNode);
        }
        else{
            addRightNode(subNode);
        }
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
        if(rightNode != null){
            rightNode.setParentNode(this);
        }
    }
    
    public void addRightNode(BinaryTreeNode rightNode) {
        if(this.getRightNode() == null){
            this.setRightNode(rightNode);
        }
        else{
            this.getRightNode().addNode(rightNode);
        }
    }
    
    public void addLeftNode(BinaryTreeNode leftNode) {
        if(this.getLeftNode() == null){
            this.setLeftNode(leftNode);
        }
        else{
            this.getLeftNode().addNode(leftNode);
        }
    }

    /**
     * @return the parentNode
     */
    public BinaryTreeNode getParentNode() {
        return parentNode;
    }

    /**
     * @param parentNode the parentNode to set
     */
    public void setParentNode(BinaryTreeNode parentNode) {
        this.parentNode = parentNode;
    }
    
    public int getDepth(){
        if(this.getParentNode() == null){
            return 0;
        }
        else{
            return this.getParentNode().getDepth();
        }
    }
    
    public int getHeight(){
        if(this.getLeftNode() == null && this.getRightNode() == null){
            return 0;
        }
        if(this.getLeftNode() == null){
            return this.getRightNode().getHeight()+1;
        }
        if(this.getRightNode() == null){
            return this.getLeftNode().getHeight()+1;
        }
        
        return Math.max(this.getLeftNode().getHeight()+1, this.getRightNode().getHeight()+1);
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    public String toString(){
        int parent = 0;
        int left = 0;
        int right = 0;
        if(this.getParentNode() != null){
            parent = this.getParentNode().getValue();
        }
        if(this.getLeftNode() != null){
            left = this.getLeftNode().getValue();
        }
        if(this.getRightNode() != null){
            right = this.getRightNode().getValue();
        }
        return "Parent:"+parent+" Value:"+getValue()+" Left:"+left+" Right:"+right;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
