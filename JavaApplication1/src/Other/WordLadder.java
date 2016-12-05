/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */
package Other;

import graphs.Graph;

/**
 *
 * @author rohan_000
 */
public class WordLadder {
    public static void main(String args[]){
        Graph graph = new Graph();
        String[] dictArr = new String[]{"hit", "hot","dot","dog","lot","log", "cog"};
        String src = "hit";
        String dest = "cog";
        for(String s: dictArr){
            for(String s1: dictArr){
                if(s != s1 && getDistance(s, s1) == 1){
                    System.out.println("Adding edge "+s+" "+s1);
                    graph.addEdge(s, s1, 0, false);
                }
            }
        }
        graph.shortestDistance(src, dest);
        
    }
    
    private static int getDistance(String str1, String str2){
        if(str1 == null || str2 == null){
            return Integer.MAX_VALUE;
        }
        if(str1.length() != str2.length()){
            return Integer.MAX_VALUE;
        }
        int diff = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}

