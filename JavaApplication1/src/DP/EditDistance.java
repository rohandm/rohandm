/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class EditDistance {

    public static void main(String args[]) {
        String str1 = "between";
        String str2 = "peen";
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        System.out.println(editDistance(chArr1, chArr1.length-1, chArr2, chArr2.length-1));
    }

    static Map<String, Integer> editMap = new HashMap();

    public static int editDistance(char[] chArr1, int end1, char[] chArr2, int end2) {
        if (end1 <= -1) {
            return end2 + 1;
        }
        if (end2 <= -1) {
            return end1 + 1;
        }
        String key = end1 + "_" + end2;
        int val = 0;
        Integer value = editMap.get(key);
        if (value != null) {
            return value;
        }
        if (chArr1[end1] == chArr2[end2]) {
            val = editDistance(chArr1, end1 - 1, chArr2, end2 - 1);
        } else {
            val = 1 + Math.min(Math.min(editDistance(chArr1, end1 - 1, chArr2, end2),
                    editDistance(chArr1, end1, chArr2, end2 - 1)),
                    editDistance(chArr1, end1-1, chArr2, end2 - 1));
        }
        editMap.put(key, val);
        return val;
    }
}
