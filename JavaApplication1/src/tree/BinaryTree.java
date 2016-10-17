/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class BinaryTree {
    private BinaryTreeNode root;
    
    public int getHeight(){
        if(getRoot() == null){
            return 0;
        }
        
        return getRoot().getHeight();
    }

    /**
     * @return the root
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    void addNode(int key) {
        BinaryTreeNode root = getRoot();
        BinaryTreeNode node = new BinaryTreeNode(key);
        if(root == null){
            root = node;
        }
        else{
            root.addNode(node);
        }
        System.out.println(root);
    }

    boolean search(int key) {
        return false;
    }

    void delete(int key) {
        return;
    }
    
    public List<BinaryTreeNode> preOrderDisplay(int x, int y, int xDiff, int yDiff){
        Stack<BinaryTreeNode> stack = new Stack();
        root.setX(x);
        root.setY(y);
        stack.push(this.getRoot());
        List<BinaryTreeNode> retList = new ArrayList();
        
        while(!stack.empty()){
            BinaryTreeNode node = stack.pop();
            retList.add(node);
            if(node != null){
                BinaryTreeNode leftNode = node.getLeftNode();
                int level = (node.getY()-y)/yDiff;
                int yD = yDiff/10;
                if(leftNode != null){
                    leftNode.setX(node.getX()+(int)(0.2*(node.getX()-x))-xDiff);
                    //leftNode.setX(node.getX()-xDiff);
                    if(level%2 == 0){
                        yD = -1*yD;
                    }
                    leftNode.setY(node.getY()+yDiff+yD);
                    stack.push(leftNode);
                }
                BinaryTreeNode rightNode = node.getRightNode();
                if(rightNode != null){
                    rightNode.setX(node.getX()+(int)(0.2*(node.getX()-x))+xDiff);
                    //rightNode.setX(node.getX()+xDiff);
                    rightNode.setY(node.getY()+yDiff-yD);
                    stack.push(rightNode);
                }
            }
        }
        return retList;
    }
}
