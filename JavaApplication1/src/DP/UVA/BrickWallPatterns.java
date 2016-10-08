/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


Brick wall for height 2
f(1) = 1 f(2) = 2 f(3) = 3
f(n) = add 1 brick upright to each of f(n-1) combinations and add 2 bricks on top of each other to f(n-2) combinations
so f(n) = f(n-1) + f(n-2) for n > 2
 */
package DP.UVA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
class BrickWallPatterns {
    private static List<BigInteger> patterns = new ArrayList();
    public static void main(String args[]){
        patterns.add(BigInteger.valueOf(0));
        patterns.add(BigInteger.valueOf(1));
        patterns.add(BigInteger.valueOf(2));
        patterns.add(BigInteger.valueOf(3));
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        while(input != 0){
            
            System.out.println(findPatterns(input));
            input = scan.nextInt();
        }
    }
    
    static BigInteger findPatterns(int n){
        BigInteger bigInt;
        if(n <= 3){
            bigInt = BigInteger.valueOf(n);
            return bigInt;
        }
        if(patterns.size() > n && patterns.get(n) != null){
            return patterns.get(n);
        }
        
        bigInt = findPatterns(n-1).add(findPatterns(n-2));
        patterns.add(n, bigInt);
        return bigInt;
    }
}

