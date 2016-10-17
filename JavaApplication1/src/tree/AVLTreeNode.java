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
public class AVLTreeNode extends BinaryTreeNode{

    public AVLTreeNode(int key) {
        super(key);
    }
    /*AVLTreeNode(int value){
        this.setValue(value);
    }*/
    public boolean isBalanced(){
        int leftHeight;
        int rightHeight;
        if(this.getLeftNode() != null){
            leftHeight = this.getLeftNode().getHeight()+1;
        }
        else{
            leftHeight = 0;
        }
        if(this.getRightNode() != null){
            rightHeight = this.getRightNode().getHeight()+1;
        }
        else{
            rightHeight = 0;
        }
        return Math.abs(leftHeight-rightHeight) <= 1;
    }
    
    @Override
    public void addRightNode(BinaryTreeNode aRightNode){
        super.addRightNode(aRightNode);
        if(!this.isBalanced()){
            balanceNode();
        }
    }
    
    public void addLeftNode(BinaryTreeNode aLeftNode){
        super.addLeftNode(aLeftNode);
        if(!this.isBalanced()){
            balanceNode();
        }
    }

    public void balanceNode() {
        System.out.println("Balancing");
        if(this.getLeftNode() == null && this.getRightNode() != null){
            if(this.getRightNode().getLeftNode() == null){
                leftRotation();
            }
            else{
                rightLeftRotation();
            }
        }
        if(this.getRightNode() == null && this.getLeftNode() != null){
            if(this.getLeftNode().getRightNode() == null){
                rightRotation();
            }
            else{
                leftRightRotation();
            }
        }
    }
    
    private void leftRotation(){
        AVLTreeNode rightNode = (AVLTreeNode) this.getRightNode();
        if(this.getParentNode() == null){
            return;
        }
        if(this.getParentNode().getLeftNode() == this){
            this.getParentNode().setLeftNode(rightNode);
        }
        else{
            this.getParentNode().setRightNode(rightNode);
        }
        this.setRightNode(null);
        rightNode.setLeftNode(this);
    }
    
    private void rightRotation(){
        AVLTreeNode leftNode = (AVLTreeNode) this.getLeftNode();
        if(this.getParentNode() == null){
            return;
        }
        if(this.getParentNode() == null){
            return;
        }
        if(this.getParentNode().getLeftNode() == this){
            this.getParentNode().setLeftNode(leftNode);
        }
        else{
            this.getParentNode().setRightNode(leftNode);
        }
        this.setLeftNode(null);
        leftNode.setRightNode(this);
    }

    private void rightLeftRotation() {
        AVLTreeNode rightNode = (AVLTreeNode) this.getRightNode();
        AVLTreeNode subNode = (AVLTreeNode) rightNode.getLeftNode();
        rightNode.setLeftNode(null);
        this.setRightNode(null);
        if(this.getParentNode() == null){
            return;
        }
        if(this.getParentNode().getLeftNode() == this){
            this.getParentNode().setLeftNode(subNode);
        }
        else{
            this.getParentNode().setRightNode(subNode);
        }
        subNode.setLeftNode(this);
        subNode.setRightNode(rightNode);
    }
    
    private void leftRightRotation(){
        AVLTreeNode leftNode = (AVLTreeNode) this.getLeftNode();
        AVLTreeNode subNode = (AVLTreeNode) leftNode.getRightNode();
        leftNode.setRightNode(null);
        this.setLeftNode(null);
        if(this.getParentNode() == null){
            return;
        }
        if(this.getParentNode().getLeftNode() == this){
            this.getParentNode().setLeftNode(subNode);
        }
        else{
            this.getParentNode().setRightNode(subNode);
        }
        subNode.setRightNode(this);
        subNode.setLeftNode(leftNode);
    }
}
