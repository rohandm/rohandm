/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ROHANME
 */
public class StringPermutations {
    public static void main(String args[]){
        Set retList = new HashSet();
        permutations("mui", retList);
        System.out.println(retList.toString());
    }

    public static void permutations(String s, Set retList){
        if(s == null || s.length() == 0){
            return;
        }
        if(retList.contains(s)){
            return;
        }
        retList.add(s);
        for(int i = 0; i < s.length(); i++){
            String str1 = s.substring(0,i)+s.substring(i+1, s.length());
            //System.out.println(str1);
            permutations(str1, retList);
        }
    }
}
