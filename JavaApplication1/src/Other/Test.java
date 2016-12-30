/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author rohan_000
 */
public class Test {
    public static void main(String args[]){
        long a = System.currentTimeMillis();
        System.out.println(a);
        long b = Long.MAX_VALUE-a;
        System.out.println(b);
        System.out.println(Long.toBinaryString(b));
        System.out.println(Long.toBinaryString(b).length());
        System.out.println(Long.toBinaryString(Long.MAX_VALUE).length());
        System.out.println(Long.toBinaryString(Long.MAX_VALUE).length());
        System.out.println(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE).bitLength());
    }
    
    static List<List<Integer>> list = new ArrayList();
    public static List method1(){
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(3);
        list.add(list1);
        return list1;
    }
}

