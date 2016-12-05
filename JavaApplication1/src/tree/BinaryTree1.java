/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class BinaryTree1 {
    TreeNode1 root;
    public static void main(String args[]) throws IOException{
        int n = 5;
        BinaryTree1 tree = new BinaryTree1();
        for(int i = 0; i < n; i++){
            tree.addNode((int)(n*Math.random()));
        }
        tree.root.calculateDepths();
        System.out.println(tree.root.checkBalanced());
        //OutputStreamWriter out = new OutputStreamWriter(System.out);
        tree.root.printTree(null);
        //out.flush();
        //out.close();
    }

    private void addNode(int d) {
        if(root == null){
            root = new TreeNode1(d, 0);
            return;
        }
        root.addNode(d);
    }
    
    public void displayTree(){
        Stack<TreeNode1> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode1 node = stack.pop();
            if(node.leftNode != null){
                stack.push(node.leftNode);
            }
            if(node.rightNode != null){
                stack.push(node.rightNode);
            }
        }
    }

}

class TreeNode1{
    TreeNode1 leftNode;
    TreeNode1 rightNode;
    TreeNode1 parentNode;
    int value;
    int height;
    int depth;
    
    TreeNode1(int val, int aHeight){
        value = val;
        height = aHeight;
    }
    
    public boolean checkBalanced(){
        if(leftNode != null && rightNode != null && Math.abs(leftNode.depth - rightNode.depth) > 1){
            return false;
        }
        if(leftNode != null && !leftNode.checkBalanced()){
            return false;
        }
        if(rightNode != null && !rightNode.checkBalanced()){
            return false;
        }
        return true;
    }

    void addNode(int d) {
        if(d <= value){
            if(leftNode == null){
                leftNode = new TreeNode1(d, this.height+1);
            }
            else{
                leftNode.addNode(d);
            }
        }
        else{
            if(rightNode == null){
                rightNode = new TreeNode1(d, this.height+1);
            }
            else{
                rightNode.addNode(d);
            }
        }
    }
    
    public void printTree(OutputStreamWriter out) throws IOException {
        if (rightNode != null) {
            rightNode.printTree(out, true, "");
        }
        printNodeValue(out);
        if (leftNode != null) {
            leftNode.printTree(out, false, "");
        }
    }
    private void printNodeValue(OutputStreamWriter out) throws IOException {
            //out.write(value);
        //out.write('\n');
        System.out.println(value+" "+depth);
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
        if (rightNode != null) {
            rightNode.printTree(out, true, indent + (isRight ? "        " : " |      "));
        }
        //out.write(indent);
        System.out.print(indent);
        if (isRight) {
            //out.write(" /");
            System.out.print(" /");
        } else {
            //out.write(" \\");
            System.out.print(" \\");
        }
        //out.write("----- ");
        System.out.print("----- ");
        printNodeValue(out);
        if (leftNode != null) {
            leftNode.printTree(out, false, indent + (isRight ? " |      " : "        "));
        }
    }

    void calculateDepths() {
        if(leftNode != null){
            leftNode.calculateDepths();
            depth = leftNode.depth+1;
        }
        if(rightNode != null){
            rightNode.calculateDepths();
            depth = Math.max(depth, rightNode.depth+1);
        }
    }
}
