/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
At the time when Pythagoreanism was prevalent, people were also focused on different ways to factorize a number. In one class, Pythagoreas asked his disciples to solve one such problem, Reverse Factorization. They were given a set of integer, A = {a1, a2,..., aK}, and an integer N. They need to find the a way to reach N, starting from 1, and at each step multiplying current value by any element of A. But soon they realise that there may exist more than one way to reach N. So they decided to find a way in which number of states are least. All of sudden they started on this new problem. People solved it and then started shouting their answer. CRAP!!!. There still exists multiple answers. So finally after much consideration, they settled on the lexicographically smallest series among those solutions which contains the least number of states.
 */
package DP;

/**
 *
 * @author ROHANME
 */
public class ReverseFactorization {
    public static void main(String args[]){
       System.out.println(reverseFactors(8, new int[]{2, 3, 4}));
    }

    public static int reverseFactors(int n, int[] arr){
        if(n == 0){
            
        }
    }
}

