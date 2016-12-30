/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class StringPermutations {

    public static void main(String args[]) {
        String str = "ABCD";
        List<String> permutations = permutations(str, 0, str.length()-1);
        System.out.println(permutations);
    }

    static Set<String> permutations(String str) {
        Set<String> permutations = new HashSet();
        if (str == null || str.length() <= 0) {
            permutations.add("");
            return permutations;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //System.out.println(i+" "+str.length());
            String str2 = str.substring(0, i);
            if (i < str.length() - 1) {
                str2 += str.substring(i + 1, str.length());
            }
            Set<String> set = permutations(str2);
            for (String str1 : set) {
                permutations.add(c + str1);
            }
        }
        return permutations;
    }

    static List<String> permutations(String str, int startInd, int endInd){
        List<String> list = new ArrayList();
        if(startInd == endInd){
            list.add(str);
            return list;
        }
        for(int i = startInd; i <= endInd; i++){
            str = swap(str, startInd, endInd);
            list.addAll(permutations(str, startInd+1, endInd));
            str = swap(str, startInd+1, endInd);
        }
        return list;
    }

    private static String swap(String str, int startInd, int endInd) {
        char[] chArr = str.toCharArray();
        char a = chArr[startInd];
        chArr[startInd] = chArr[endInd];
        chArr[endInd] = a;
        return String.valueOf(chArr);
    }
}
