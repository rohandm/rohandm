/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class TowersOfHanoi {
    public static void main(String args[]){
        Stack stack1 = new Stack();
        stack1.push("9");
        stack1.push("8");
        stack1.push("7");
        stack1.push("6");
        stack1.push("5");
        stack1.push("4");
        stack1.push("3");
        stack1.push("2");
        stack1.push("1");
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(stack3);
        System.out.println();
        moveDisks(stack1.size(), stack1, stack2, stack3);
        
    }

    private static void moveDisks(int size, Stack origin, Stack buffer, Stack destination) {
        if(size == 0){
            return;
        }
        moveDisks(size - 1, origin, destination, buffer);
        destination.push(origin.pop());
        moveDisks(size - 1, buffer, origin, destination);
        System.out.println(origin);
        System.out.println(buffer);
        System.out.println(destination);
        System.out.println();
    }
}
