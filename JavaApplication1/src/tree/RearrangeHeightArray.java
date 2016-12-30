/*
You are given two array, first array contain integer which represent heights of persons and second array contain how many persons in front of him are standing who are greater than him in term of height and forming a queue. Ex 
A: 3 2 1 
B: 0 1 1 
It means in front of person of height 3 there is no person standing, person of height 2 there is one person in front of him who has greater height then he, similar to person of height 1. Your task to arrange them 
Ouput should be. 
3 1 2 
Here - 3 is at front, 1 has 3 in front ,2 has 1 and 3 in front.

 */
package tree;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class RearrangeHeightArray {
    public static void main(String args[]){
        int[] heightArr = {6,5,4,3,2,1};
        int[] tallerPplInFrontArr = {0,0,0,2,2,4 };
        Person[] personArr = new Person[heightArr.length];
        for(int i = 0; i < heightArr.length; i++){
            personArr[i] = new Person();
            personArr[i].height = heightArr[i];
            personArr[i].numTallerInFront = tallerPplInFrontArr[i];
        }
        Arrays.sort(personArr);
        Tree2 tree = new Tree2();
        for(int i = 0; i < personArr.length; i++){
            tree.addNode(personArr[i].height, personArr[i].numTallerInFront);
        }
        System.out.println(tree.inOrderTraverSal());
    }
}

class Person implements Comparable<Object>{
    int height;
    int numTallerInFront;

    @Override
    public int compareTo(Object o) {
        if(o == null || o.getClass() != this.getClass()){
            return -1;
        }
        Person p = (Person)o;
        return p.height-this.height;
    }
}

//Tree for case when number of taller ppl in front are specified
class Tree2{
    Node2 root;

    
    public void addNode(int name, int value){
        if(root == null){
            root = new Node2(name, value+1);
            return;
        }
        root.addNode(name, value);
    }
    
    public List<Node2> inOrderTraverSal(){
        Stack<Node2> stack = new Stack();
        stack.push(root);
        List<Node2> visited = new ArrayList();
        while(!stack.isEmpty()){
            
            Node2 node = stack.peek();

            //System.out.println(node.val);
            boolean hasVisitedLeftNode = true;
            if(node.leftNode != null && !visited.contains(node.leftNode)){
                    hasVisitedLeftNode = false;
                    stack.push(node.leftNode);
            }
            if(hasVisitedLeftNode){
                stack.pop();
                visited.add(node);
                if(node.rightNode != null){
                    if(!visited.contains(node.rightNode)){
                        stack.push(node.rightNode);
                    }
                }
            }
        }
        return visited;
    }
}

class Node2{
    Node2 leftNode;
    Node2 rightNode;
    int val;
    int name;
    
    Node2(int aName, int value){
        name = aName;
        val = value;
    }
    
    public void addNode(int aName, int aValue){
        if(aValue < val){
            ++this.val;
            if(leftNode == null){
                leftNode = new Node2(aName, aValue+1);
                return;
            }
            leftNode.addNode(aName, aValue);
            return;
        }
        else{
            if(rightNode == null){
                rightNode = new Node2(aName, aValue+1);
                return;
            }
            rightNode.addNode(aName, aValue);
        }
    }
    
    public String toString(){
        return ""+name+":"+val;
    }
}

class Tree3{
    
}