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
 * @author ROHANME
 */
public class PriorityQueueEx {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(6);
        pq.offer(9);
        
        
        List list = new ArrayList();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        list.forEach(a -> System.out.println(a));
        
    }
}
