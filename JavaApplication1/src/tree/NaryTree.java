/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class NaryTree {
    private NaryTreeNode root;
    private int n;
    private int currLevel;
    
    public static void main(String args[]){
        NaryTree tree = new NaryTree(3);
        int n = 20;
        for(int i = 0; i < n; i++){
            tree.addNode((int)(n*Math.random()));
        }
        System.out.println(tree.postOrderTraversal());
        List<NaryTreeNode> retList = tree.bfs();
        int level = 0;
        for(NaryTreeNode node: retList){
            if(node.level > level){
                level = node.level;
                System.out.println();
            }
            System.out.print(node+" ");
        }
    }
    
    NaryTree(int num){
        n = num;
        currLevel = 0;
    }
    
    public void addNode(int c){
        if(root == null){
            root = new NaryTreeNode(c, 0);
            currLevel = 1;
        }
        else{
            int i = currLevel;
            while(!root.addChildren(c, i, n)){
                i++;
            }
            currLevel = i;
        }
    }
    
    
    public List<NaryTreeNode> postOrderTraversal(){
        Stack<NaryTreeNode> stack = new Stack<>();
        List<NaryTreeNode> visited = new ArrayList();
        stack.push(root);
        while(!stack.isEmpty()){
            NaryTreeNode node = stack.peek();
            boolean childrenProcessed = true;
            for(NaryTreeNode childNode: node.children){
                if(!visited.contains(childNode)){
                    childrenProcessed = false;
                    stack.push(childNode);
                }
            }
            if(childrenProcessed){
                visited.add(stack.pop());
            }
        }
        return visited;
    }
    
    public List<NaryTreeNode> bfs(){
        Queue<NaryTreeNode> queue = new LinkedList();
        List<NaryTreeNode> visited = new ArrayList();
        queue.add(root);
        while(!queue.isEmpty()){
            NaryTreeNode node = queue.poll();
            visited.add(node);
            queue.addAll(node.children);
        }
        return visited;
    }
}

class NaryTreeNode{
    List<NaryTreeNode> children;
    int value;
    int level;
    NaryTreeNode parent;
    
    NaryTreeNode(int c, int l){
        value = c;
        level = l;
        children = new ArrayList();
    }

    public boolean addChildren(int c, int l, int n) {
        if(l == level+1){
            if(children.size() < n){
                NaryTreeNode childNode = new NaryTreeNode(c, l); 
                children.add(childNode);
                childNode.parent = this;
                return true;
            }
            return false;
        }
        if(l > level+1){
            for(NaryTreeNode child: children){
                if(child.addChildren(c, l, n)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String toString(){
        String s = "V:"+value+" L:"+level;
        if(parent != null){
            s = s+" P:"+parent.value;
        }
        return s;
    }
}
