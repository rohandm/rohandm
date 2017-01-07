/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;
import java.util.*;

/**
 *
 * @author ROHANME
 */
public class LFUCache {
    
    public static void main(String[] args){
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.set(1, 1);
        
        lfuCache.set(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.set(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.set(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
    int capacity;
    HashMap<Integer, LFUEntry> map = new HashMap();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LFUEntry entry = map.get(key);
        if(entry == null){
            return -1;
        }
        ++entry.frequency;
        entry.lastAccessedTime = System.currentTimeMillis();
        return entry.value;
    }
    
    public void set(int key, int value) {
        LFUEntry val = map.get(key);
        if(val != null){
            val.value = value;
            val.lastAccessedTime = System.currentTimeMillis();
            ++val.frequency;
            return;
        }
        List<LFUEntry> list = null;
        if(map.size() >= capacity){
          list = new ArrayList(map.values());
          Collections.sort(list);
            Iterator<LFUEntry> itr = list.iterator();
            int size = map.size();
            while(size >= capacity && itr.hasNext()){
                --size;
                map.remove(itr.next().key);
            }
        }
        map.put(key, new LFUEntry(key, value));
    }
}

class LFUEntry implements Comparable{
    int value = 0;
    int key = 0;
    long lastAccessedTime = System.currentTimeMillis();
    int frequency = 0;
    
    LFUEntry(int key, int val){
        value = val;
        this.key = key;
    }
    
    public int getVal(){
        return value;
    }
    
    public int compareTo(Object o){
        if(o == null || o.getClass() != this.getClass()){
            return -1;
        }
        LFUEntry obj = (LFUEntry)o;
        if(this.frequency == obj.frequency){
            return (int)(this.lastAccessedTime - obj.lastAccessedTime);
        }
        return this.frequency - obj.frequency;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */
