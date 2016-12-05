/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author rohan_000
 */
public class ReverseWords {
    public static void main(String args[]){
        String sentence = "open the template in the editor for";
        String[] words = sentence.split("\\s+");
        
        /*String newWords = IntStream.range(0, words.length)
                //.filter(i -> i < words.length/2)
                .mapToObj(i -> words[words.length-1-i])
                .reduce("", (a,b) -> a+" "+b)
                .substring(1);*/
        String newWords = Arrays.stream(sentence.split("\\s+"))
                .reduce("", (a,b) -> b+" "+a);
        
        System.out.println(newWords);
    }
}
