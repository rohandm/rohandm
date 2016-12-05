/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class GenerateParenthesis {
    public static void main(String args[]){
        int n = 4;
        generateParenthesis(n, n, "");
        System.out.println(list);
    }
    static List list = new ArrayList();
    static void generateParenthesis(int left, int right, String s){
        if(s.startsWith("}")){
            System.out.println(left+" "+right+" "+s);
        }
        if(left > right){
            return;
        }
        if(left == 0 && right == 0){
            list.add(s);
            return;
        }
        if(left > 0){
            generateParenthesis(left-1, right, s+"{");
        }
        if(left < right && right > 0){
            generateParenthesis(left, right-1, s+"}");
        }
    }
}
