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
public class Test {
    public static void main(String args[]){
        List list1 = method1();
        List list2 = list.get(0);
        List<List<Integer>> list3 = new ArrayList();
        list3.addAll(list);
        list3.get(0).add(5);
        System.out.println(list1);
        System.out.println(list3);
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
