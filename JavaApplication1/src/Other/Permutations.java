/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author rohan_000
 */
public class Permutations {
    static int[] arr;
    public static void main(String args[]){
        int[] input = {1,2,3};
        arr = input;
        List<List<Integer>> list = permutations(0, arr.length-1);
        list.sort((a,b) -> {
            Iterator<Integer> itr1 = a.iterator();
            Iterator<Integer> itr2 = b.iterator();
            while(itr1.hasNext() && itr2.hasNext()){
                Integer i1 = itr1.next();
                Integer i2 = itr2.next();
                if(i1 == i2){
                    continue;
                }
                return i1 - i2;
            }
            return 0;
        });
        System.out.println("Count:"+list.size());
        for(List l: list){
            System.out.println(l);
        }
    }

    static Map<String, List> map = new HashMap<>();
    static List<List<Integer>> permutations(int startInd, int endInd){
        List<List<Integer>> list = new ArrayList<>();
        String key = startInd+"_"+endInd;
        if(startInd > endInd){
            return list;
        }
        if(startInd == endInd){
            List<Integer> l = new ArrayList();
            l.add(arr[startInd]);
            list.add(l);
            return list;
        }
        if(map.containsKey(key)){
            return map.get(key);
        }
        int el = arr[startInd];
        List<List<Integer>> pList = permutations(startInd+1, endInd);
        for(int i = 0; i < endInd-startInd+1; i++){
            for(List<Integer> tempList: pList){
            
                List<Integer> elList = new ArrayList<>(tempList);
                elList.add(i, el);
                list.add(elList);
            }
        }
        return list;
    }
}
