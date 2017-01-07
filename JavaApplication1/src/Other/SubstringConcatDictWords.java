/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.*;

/**
 *
 * @author ROHANME
 */
public class SubstringConcatDictWords {
    public static void main(String[] args){
        SubstringConcatDictWords obj = new SubstringConcatDictWords();
        System.out.println(obj.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        long modCode = 0;
        List<Integer> retList = new ArrayList();
        if(words == null || words.length == 0 ){
            return retList;
        }
        char[] dictChArr = new char[words.length*words[0].length()];
        int ind = 0;
        for(String word: words){
            System.arraycopy(word.toCharArray(), 0, dictChArr, ind, word.length());
            ind+=word.length();
        }
        long dictSum = 0;
        for(char ch: dictChArr){
            dictSum += ch;
        }
        //System.out.println(dictSum);
        char[] chArr = s.toCharArray();
        for(int i = chArr.length-1; i >= 0; --i){
            modCode += chArr[i];
            if(i < chArr.length - dictChArr.length){
                modCode = modCode - chArr[i+dictChArr.length];
            }
            //System.out.println(i+" "+(i+dictChArr.length-1)+" "+modCode);
            if(modCode == dictSum){
                //System.out.println("Inside if");
                if(compareCharSeq(chArr, i, words, dictChArr.length)){
                  retList.add(i);  
                }
            }
        } 
        return retList;
    }
    
    static boolean compareCharSeq(char[] chArr1, int startInd, String[] words, int wordLength){
        boolean equal = true;
        String str1 = new String(chArr1, startInd, wordLength);
        //System.out.println(str1);
        for(String word: words){
            int len = str1.length();
            //System.out.println(str1+"      "+word);
            str1 = str1.replaceFirst(word, "");
            if(str1.length() == len){
                return false;
            }
        }
        return true;
    }
}
