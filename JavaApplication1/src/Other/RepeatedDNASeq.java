/*
Problem

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
package Other;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author rohan_000
 */
public class RepeatedDNASeq {
    public static void main(String args[]){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        method1(s);
    }

    private static void method1(String s) {
        Map<String, Integer> map = new HashMap();
        for(int i = 10; i < s.length(); i++){
            String subStr = s.substring(i-10, i);
            if(map.containsKey(subStr)){
                map.put(subStr, map.get(subStr)+1);
            }
            else{
                map.put(subStr, 1);
            }
        }
        Predicate greaterThan1 = (n) -> map.get(n) > 1;
        System.out.println(map.keySet()
                .stream()
                .filter(greaterThan1)
                .collect(Collectors.toList())
                .toString());
    }
}
