/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class StringArray {
    public static void main(String args[]){
        //reverse polish notation
        System.out.println(reversePolishNotation(new String[]{"2", "1", "+", "3", "*"}));
    }
    static int reversePolishNotation(String[] inputArr){
        Stack<Integer> stack = new Stack();
        String operators = "+*-/";
        for(String t: inputArr){
            int index = operators.indexOf(t);
            if(index > -1){
                int a = stack.pop();
                switch(index){
                    case 0: stack.push(a+stack.pop());
                            break;
                    case 1: stack.push(a*stack.pop());
                            break;
                    case 2: stack.push(stack.pop()-a);
                            break;
                    case 3: stack.push(stack.pop()/a);
                            break;
                }
            }
            else{
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
