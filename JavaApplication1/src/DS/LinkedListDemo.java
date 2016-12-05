/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author rohan_000
 */
public class LinkedListDemo{
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("A");
        list.add("E");
        System.out.println(list);
        removeDuplicates(list);
        System.out.println(list);
    }

    private static void removeDuplicates(MyLinkedList list) {
        List<String> set = new ArrayList();
        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String str1 = itr.next();
            if(set.contains(str1)){
                itr.remove();
            }
            set.add(str1);
        }
    }
}
class MyLinkedList <T> implements Iterable{
    LLNode<T> head;
    
    MyLinkedList(){
    }
    
    public String toString(){
        LLNode node = head;
        StringBuilder strB = new StringBuilder();
        while(node != null){
            strB.append(node.toString());
            strB.append(" ");
            node = node.getNextNode();
        }
        return strB.toString();
    }
    
    public void add(T val){
        LLNode node = new LLNode(val);
        if(head == null){
            head = node;
            return;
        }
        LLNode node1 = head;
        while(node1.getNextNode() != null){
            node1 = node1.getNextNode();
        }
        node1.setNextNode(node);
    }
    
    public void remove(T val){
        if(head == null || val == null){
            return;
        }
        LLNode node = head;
        LLNode prevNode = null;
        while(node != null && !Objects.equals(val, node.getValue())){
            prevNode = node;
            node = node.getNextNode();
        }
        if(node != null && Objects.equals(val, node.getValue())){
            if(prevNode == null){
                head = head.getNextNode();
            }
            else{
                prevNode.setNextNode(node.getNextNode());
            }
        }
        return;
        
    }
    
    public boolean contains(T val){
        if(head == null || val == null){
            return false;
        }
        LLNode node = head;
        while(node != null && !Objects.equals(val, node.getValue())){
            node = node.getNextNode();
        }
        if(node != null && Objects.equals(val, node.getValue())){
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            LLNode currentNode = null;
            LLNode nextNode = head;
            LLNode prevNode = null;
            @Override
            public boolean hasNext() {
                if(nextNode == null){
                    return false;
                }
                return true;
            }

            @Override
            public Object next() {
                if(hasNext()){
                    Object retVal = nextNode.getValue();
                    prevNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.getNextNode();
                    return retVal;
                }
                return null;
            }
            
            @Override
            public void remove(){
                if(currentNode == null){
                    return;
                }
                else{
                    if(prevNode != null){
                        prevNode.setNextNode(nextNode);
                    }
                    currentNode = nextNode;
                }
            }
            
        };
    }
}

class LLNode<T>{
    private LLNode<T> nextNode;
    private T value;
    
    LLNode(T val){
        value = val;
    }

    /**
     * @return the nextNode
     */
    public LLNode<T> getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(LLNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }
    
    public String toString(){
        if(getValue() == null){
            return "null";
        }
        return getValue().toString();
    }
}


