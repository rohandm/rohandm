/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class HuffmanCompression {
    public static void main(String args[]){
        String str = "In 2013 faster alternative to Arithmetic coding was proposed,"
                + " capable of using fractional number of bits to store codewords with"
                + " Asymmetric Numeral Systems (ANS).[6] This variant is used in Facebook's Zstandard (2016) and in Apple";
        
        char[] chArr = str.toCharArray();
        int[] freqArr = new int[128];
        
        for(char ch: chArr){
            freqArr[ch]++;
        }
        //System.out.println(Arrays.toString(freqArr));
        PriorityQueue<TrieNode> pq = new PriorityQueue<>((a,b) -> a.value-b.value);
        Arrays.stream(freqArr).forEach(i -> pq.add(new TrieNode(i, freqArr[i])));
        
        TrieNode root = buildTrie(pq);
        //System.out.println(root);
        
        String[] codeArr = new String[128];
        buildCode(codeArr, root, "");
        System.out.println(Arrays.toString(codeArr));
        
        StringBuffer compressedString = new StringBuffer();
        for(int i = 0; i < chArr.length; i++){
            compressedString.append(codeArr[chArr[i]]);
        }
        System.out.println(compressedString);
    }

    private static TrieNode buildTrie(PriorityQueue<TrieNode> pq) {
        while(pq.size() > 1){
            TrieNode leftNode = pq.poll();
            TrieNode rightNode = pq.poll();
            TrieNode node = new TrieNode(0, leftNode.frequency+rightNode.frequency);
            node.leftNode = leftNode;
            node.rightNode = rightNode;
            pq.add(node);
        }
        return pq.poll();
    }

    private static void buildCode(String[] str, TrieNode node, String s) {
        if(node == null){
            return;
        }
        if(node.isLeafNode()){
            buildCode(str, node.leftNode, s+'0');
            buildCode(str, node.rightNode, s+'1');
        }
        else{
            str[node.value] = s;
        }
        
    }
}

class TrieNode{
    int value;
    int frequency;
    TrieNode leftNode;
    TrieNode rightNode;
    
    TrieNode(int val, int freq){
        value = val;
        frequency = freq;
    }
    
    public boolean isLeafNode(){
        if(leftNode == null && rightNode == null){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return value+" "+frequency+" "+leftNode+" "+rightNode;
    }
}