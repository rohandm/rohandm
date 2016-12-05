/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * @author rohan_000
 */
public class CombinationSum {
    public static void main(String args[]){
        int[] arr = new int[]{2, 3, 6, 7};
        List<List<Integer>> list = sumCombination1(arr, 7);
        Set<List<Integer>> set = new HashSet();
        System.out.println(list);
        list.forEach(a -> {
            a.sort((c,d) -> c-d);
            set.add(a);
        });
        System.out.println(set);
    }
    
    static Map<Integer, List> map = new HashMap<>();
    private static List<List<Integer>> sumCombination(int[] arr, int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        List<List<Integer>> set = new ArrayList();
        for(int i: arr){
            List<Integer> list;
            if(n==i){
                list = new ArrayList();
                list.add(i);
                set.add(list);
                continue;
            }
            else if(n < i){
                continue;
            }
            else{
                list = new ArrayList();
                List<List<Integer>> set1 = sumCombination(arr, n-i);
                set1.forEach(a -> {
                    List<Integer> b = new ArrayList(a);
                    b.add(i);
                    //b.sort((c,d) -> c-d);
                    set.add(b);
                });
            }
        }
        map.put(n, set);
        return set;
    }
    
    private static List<List<Integer>> sumCombination1(int[] arr, int n) {
        Arrays.sort(arr);
        List<List<Integer>>[] listArr = new List[n];
        listArr[0] = new ArrayList();
        List<Integer> list = new ArrayList();
        listArr[0].add(list);
        IntStream.range(1, n-1).forEach(i -> {
            listArr[i] = new ArrayList();
            /*if(arr[i] == n){
                List list1 = new ArrayList();
                list1.add(i);
                listArr[i].add(list1);
            }*/
            Arrays.stream(arr).filter(j -> j < i).forEach(j ->{
                List<List<Integer>> list2 = listArr[i-1-j];
                list2.forEach(a -> {
                    List b = new ArrayList(a);
                    b.add(j);
                    listArr[i].add(b);
                });
            });
        });
        return listArr[n-1];
    }
}
