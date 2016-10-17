/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rohan_000
 */
public class AVLTree extends BinaryTree{
    public static void main(String args[]){
        SecureRandom random = new SecureRandom();
        AVLTree t = new AVLTree();
        
        BinaryTreeNode root = new AVLTreeNode(50);
        t.setRoot(root);
        List<AVLTreeNode> list = new ArrayList();
        for(int i = 0; i < 20; i++){
            AVLTreeNode node = new AVLTreeNode((int)(Math.random()*100));
            root.addNode(node);  //insert word into Binary Search Tree
            list.add(node);
        }
        
        
        
        for(AVLTreeNode node: list){
            System.out.println(node);
        }
        
    }
}
