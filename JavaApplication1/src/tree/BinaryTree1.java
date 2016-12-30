/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author rohan_000
 */
public class BinaryTree1 {

    TreeNode1 root;
    public static void main(String args[]) throws IOException{
        int n = 10;
        int k = 100;
        BinaryTree1 tree = new BinaryTree1();
        //int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            tree.addAVLNode((int)(n*Math.random()));
            //arr[i] = (int)(k*Math.random());
        }
        //System.out.println(printAllPaths(tree, 20));
        tree.root.printTree();
        System.out.println("Pre Order");
        tree.preOrderTraversal();
        System.out.println("\nIn Order");
        tree.inOrderTraversal();
        System.out.println("\nPost Order");
        tree.postOrderTraversal();
    }

    public void preOrderTraversal() {
        Stack<TreeNode1> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode1 node = stack.pop();
            TreeNode1 leftNode = node.leftNode;
            TreeNode1 rightNode = node.rightNode;
            System.out.print(node.value+" ");
            if(rightNode != null){
                stack.push(rightNode);
            }
            if(leftNode != null){
                stack.push(leftNode);
            }
        }
    }
    
    public void inOrderTraversal() {
        Stack<TreeNode1> stack = new Stack();
        stack.add(root);
        List<TreeNode1> visited = new ArrayList();
        while(!stack.isEmpty()){
            TreeNode1 node = stack.peek();
            TreeNode1 leftNode = node.leftNode;
            TreeNode1 rightNode = node.rightNode;
            boolean visitedLeft = true;
            if(leftNode != null && !visited.contains(leftNode)){
                stack.push(leftNode);
                visitedLeft = false;
            }
            else if(visitedLeft){
                visited.add(stack.pop());
                System.out.print(node.value+" ");
                if(rightNode != null && !visited.contains(rightNode)){
                    stack.push(rightNode);
                }
            }
        }
    }
    
    public void postOrderTraversal() {
        Stack<TreeNode1> stack = new Stack();
        stack.add(root);
        List<TreeNode1> visited = new ArrayList();
        while(!stack.isEmpty()){
            TreeNode1 node = stack.peek();
            TreeNode1 leftNode = node.leftNode;
            TreeNode1 rightNode = node.rightNode;
            boolean visitedChildren = true;
            if(rightNode != null && !visited.contains(rightNode)){
                stack.push(rightNode);
                visitedChildren = false;
            }
            if(leftNode != null && !visited.contains(leftNode)){
                stack.push(leftNode);
                visitedChildren = false;
            }
            if(visitedChildren){
                visited.add(stack.pop());
                System.out.print(node.value+" ");
            }
        }
    }
    
    
    private static Set<String> printAllPaths(BinaryTree1 tree, int n) {
        List<TreeNode1> list = tree.bfs();
        Map<TreeNode1, String>[] pathSeq = new Map[n+1];
        Map<TreeNode1, Integer>[] pathSum = new Map[n+1];
        Iterator<TreeNode1> itr = list.iterator();
        while(itr.hasNext()){
            TreeNode1 node = itr.next();
            if(node.value <= n){
                pathSeq[node.value] = new HashMap();
                pathSum[node.value] = new HashMap();
                pathSeq[node.value].put(node, " "+node.value);
                pathSum[node.value].put(node, node.value);
            }
        }
        Iterator<TreeNode1> itr1 = list.iterator();
        while(itr1.hasNext()){
            TreeNode1 node = itr1.next();
            for(int i = 0; i <= n-node.value; i++){
                if(pathSeq[i] != null && pathSeq[i].keySet().contains(node.parentNode)){
                    if(pathSeq[i+node.value] == null){
                        pathSeq[i+node.value] = new HashMap();
                        pathSum[i+node.value] = new HashMap();
                    }
                    pathSeq[i+node.value].put(node, node.value+" "+pathSeq[i].get(node.parentNode));
                    pathSum[i+node.value].put(node, node.value+i);
                }
            }
        }
        if(pathSeq[n] == null){
            return null;
        }
        return new HashSet(pathSeq[n].values());
    }
    
    private static boolean checkIfSubTree(BinaryTree1 tree, TreeNode1 node1) {
        List<LinkedList<TreeNode1>> list1 = TreeToLinkedList(tree);
        if(list1.size() <= node1.depth){
            return false;
        }
        LinkedList treeList = list1.get(node1.depth);
        Iterator<TreeNode1> itr = treeList.iterator();
        while(itr.hasNext()){
            if(Objects.equals(node1, itr.next())){
                return true;
            }
        }
        return false;
    }
    
    private static TreeNode1 getCommonAncestor(TreeNode1 node1, TreeNode1 node2) {
        if(node1 == null || node2 == null){
            return null;
        }
        while(node1.height > node2.height){
            System.out.println(node1.height + " "+node2.height);
            node1 = node1.parentNode;
            if(node1 == null){
                return null;
            }
        }
        while(node1.height < node2.height){
            System.out.println(node1.height + " "+node2.height);
            node2 = node2.parentNode;
            if(node2 == null){
                return null;
            }
        }
        while(!Objects.equals(node1, node2)){
            System.out.println(node1.value+" "+node1.height+" "+node2.value+" "+node2.height);
            node1 = node1.parentNode;
            node2 = node2.parentNode;
        }
        return node1;
    }
    
    public static boolean checkBST(BinaryTree1 tree){
        return tree.root.checkBST();
    }

    private static List<LinkedList<TreeNode1>> TreeToLinkedList(BinaryTree1 tree) {
        tree.root.calculateHeights();
        //System.out.println(tree.root.depth);
        List<LinkedList<TreeNode1>> retList = new ArrayList();
        for(int i = 0; i <= tree.root.depth; i++){
            retList.add(new LinkedList<>());
        }
        List<TreeNode1> list = tree.dfs();
        for(TreeNode1 node: list){
            LinkedList ll = retList.get(node.depth);
            if(ll == null){
                ll = new LinkedList();
                retList.add(node.depth, ll);
            }
            ll.add(node);
        }
        return retList;
    }
    
    private void addNode(int d) {
        if(root == null){
            root = new TreeNode1(d, 0);
            return;
        }
        root.addNode(d);
    }
    
    private void addBSTNode(int d) {
        if(root == null){
            root = new TreeNode1(d, 0);
            return;
        }
        root.addBSTNode(d);
    }
    
    private void addAVLNode(int d) {
        if(root == null){
            root = new TreeNode1(d, 0);
            return;
        }
        root.addAVLNode(d);
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
    
    public static TreeNode1 minHeightBinaryTreeFromSortedArray(int[] arr, int startInd, int endInd, int height){
        if(startInd > endInd){
            return null;
        }
        int mid = (startInd+endInd)/2;
        TreeNode1 node = new TreeNode1(arr[mid], height);
        if(startInd < endInd){
            node.leftNode = minHeightBinaryTreeFromSortedArray(arr, startInd, mid, height+1);
            node.rightNode = minHeightBinaryTreeFromSortedArray(arr, mid+1, endInd, height+1);
        }
        return node;
    }

    private List<TreeNode1> dfs() {
        return root.dfs();
    }
    
    private List<TreeNode1> bfs(){
        Queue<TreeNode1> queue = new LinkedList();
        List<TreeNode1> list = new ArrayList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode1 node = queue.poll();
            list.add(node);
            if(node.leftNode != null){
                queue.add(node.leftNode);
            }
            if(node.rightNode != null){
                queue.add(node.rightNode);
            }
        }
        return list;
    }



}

class Path{
    HashMap<TreeNode1, TempNode> map = new HashMap();
}

class TempNode{
    TreeNode1 node;
    int sum;
    TempNode(TreeNode1 node){
        sum = node.value;
    }
}

class TreeNode1{
    TreeNode1 leftNode;
    TreeNode1 rightNode;
    TreeNode1 parentNode;
    int value;
    int height;
    int depth;
    boolean heightCalculated = false;
    
    TreeNode1(int val, int aDepth){
        value = val;
        depth = aDepth;
    }
    
    public boolean checkBalanced(){
        if(!heightCalculated){
            calculateHeights();
        }
        if(leftNode != null && rightNode != null && Math.abs(leftNode.height - rightNode.height) > 1){
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
    
    void addAVLNode(int d){
        if(d <= value){
            if(leftNode == null){
                leftNode = new TreeNode1(d, this.depth+1);
                leftNode.parentNode = this;
            }
            else{
                leftNode.addAVLNode(d);
            }
        }
        else{
            if(rightNode == null){
                rightNode = new TreeNode1(d, this.depth+1);
                rightNode.parentNode = this;
            }
            else{
                rightNode.addAVLNode(d);
            }
        }
        heightCalculated = false;
        if(!checkBalanced()){
            balanceNode();
        }
    }
    
    void balanceNode(){
        if(this.leftNode == null
                && this.rightNode != null){
            if(this.rightNode.rightNode != null){
                leftRotation();
            }
            else if(this.rightNode.leftNode != null){
                rightLeftRotation();
            }
        }
        
        if(this.rightNode == null
                && this.leftNode != null){
            if(this.leftNode.leftNode != null){
                rightRotation();
            }
            else if(this.leftNode.rightNode != null){
                leftRightRotation();
            }
        }
    }
    
    void leftRotation(){
        TreeNode1 rightNode = this.rightNode;
        this.rightNode = null;
        updateParent(rightNode);
        rightNode.leftNode = this;
    }
    
    void rightRotation(){
        TreeNode1 leftNode = this.leftNode;
        this.leftNode = null;
        updateParent(leftNode);
        leftNode.rightNode = this;
    }
    
    void rightLeftRotation(){
        this.rightNode.rightRotation();
        leftRotation();
    }
    
    void leftRightRotation(){
        this.leftNode.leftRotation();
        rightRotation();
    }
    
    void updateParent(TreeNode1 node){
        if(this.parentNode == null){
            return;
        }
        if(this == this.parentNode.leftNode){
            this.parentNode.leftNode = node;
        }
        if(this == this.parentNode.rightNode){
            this.parentNode.rightNode = node;
        }
    }

    void addBSTNode(int d) {
        if(d <= value){
            if(leftNode == null){
                leftNode = new TreeNode1(d, this.depth+1);
                leftNode.parentNode = this;
            }
            else{
                leftNode.addBSTNode(d);
            }
        }
        else{
            if(rightNode == null){
                rightNode = new TreeNode1(d, this.depth+1);
                rightNode.parentNode = this;
            }
            else{
                rightNode.addBSTNode(d);
            }
        }
    }
    
    void addNode(int d) {
        if(leftNode == null){
            leftNode = new TreeNode1(d, this.depth+1);
            leftNode.parentNode = this;
        }
        else if(rightNode == null){
            rightNode = new TreeNode1(d, this.depth+1);    
            rightNode.parentNode = this;
        }
        else{
            this.calculateHeights();
            if(leftNode.height <= rightNode.height){
                leftNode.addNode(d);
            }
            else{
                rightNode.addNode(d);
            }
        }
    }
    
    public void printTree() throws IOException {
        if (rightNode != null) {
            rightNode.printTree(true, "");
        }
        printNodeValue();
        if (leftNode != null) {
            leftNode.printTree(false, "");
        }
    }
    private void printNodeValue() throws IOException {
            //out.write(value);
        //out.write('\n');
        System.out.println(value);//+" "+height+" "+depth);
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(boolean isRight, String indent) throws IOException {
        if (rightNode != null) {
            rightNode.printTree(true, indent + (isRight ? "        " : " |      "));
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
        printNodeValue();
        if (leftNode != null) {
            leftNode.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }

    void calculateHeights() {
        if(leftNode != null){
            leftNode.calculateHeights();
            height = leftNode.height+1;
        }
        if(rightNode != null){
            rightNode.calculateHeights();
            height = Math.max(height, rightNode.height+1);
        }
    }

    List<TreeNode1> dfs() {
        List<TreeNode1> list = new ArrayList<>();
        list.add(this);
        if(this.leftNode != null){
            list.addAll(leftNode.dfs());
        }
        if(this.rightNode != null){
            list.addAll(rightNode.dfs());
        }
        return list;
    }
    
    public String toString(){
        return ""+this.value;
    }

    boolean checkBST() {
        if(leftNode != null){
            if(leftNode.value > value || !leftNode.checkBST()){
                return false;
            }
        }
        if(rightNode != null){
            if(rightNode.value < value || !rightNode.checkBST()){
                return false;
            }
        }
        return true;
    }
}

