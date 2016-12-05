/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author rohan_000
 */
public class MyCollections{
    
    public static void main(String args[]){
        MyMap<String, String> map = new MyMap();
        map.put("A", "1");
        map.put("B", "Y");
        map.put("C", "X");
        map.put("D", "2");
        map.put("E", "3");
        map.put("F", "U");
        //System.out.println(map);
        map.put("A", "Z");
        map.put("D", "W");
        map.put("E", "V");
        //System.out.println(map);
        map.put("G", "T");
        map.put("H", "S");
        map.put("I", "R");
        map.put("J", "Q");
        map.put("K", "P");
        map.put("L", "O");
        map.put("M", "N");
        Iterator itr = map.keySet().iterator();
        while(itr.hasNext()){
            System.out.print(itr.next());
        }
        System.out.println();
        Iterator itr1 = map.values().iterator();
        while(itr1.hasNext()){
            System.out.print(itr1.next());
        }
        
        /*MySet set = new MySet();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        set.add("F");
        set.add("A");
        System.out.println(set);
        set.add("B");
        set.add("G");
        set.add("H");
        System.out.println(set);*/
        
        /*MyList list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        list.add("D");
        System.out.println(list);
        System.out.println(list.contains("A"));*/
        
        
    }
}

class MyMap<T1, T2> {
    private static final int initialCapacity = 10;
    private int currentCapacity = 10;
    private LinkedList<MyEntry>[] internalArray;
    private int size = 0;
    private static final float loadFactor = 0.75f;
    
    MyMap(){
       this(initialCapacity); 
    }
    
    MyMap(int capacity){
        currentCapacity = capacity;
        internalArray = new LinkedList[capacity]; 
    }
    
    private void ensureCapacity(){
        currentCapacity *= 2;
        LinkedList<MyEntry>[] newArray = new LinkedList[currentCapacity];
        for(LinkedList<MyEntry> list: internalArray){
            if(list != null){
                Iterator<MyEntry> itr = list.iterator();
                while(itr.hasNext()){
                    MyEntry entry = itr.next();
                    int index = entry.getKey().hashCode()%currentCapacity;
                    if(newArray[index] == null){
                        newArray[index] = new LinkedList<MyEntry>();
                    }
                    newArray[index].add(entry);
                }
            }
        }
        internalArray = newArray;
    }
    
    public T2 get(T1 key){
        LinkedList<MyEntry> list = internalArray[key.hashCode()%currentCapacity];
        if(list == null){
            return null;
        }
        Iterator<MyEntry> itr = list.iterator();
        while(itr.hasNext()){
            MyEntry entry = itr.next();
            if(key.equals(entry.getKey())){
                return (T2) entry.getValue();
            }
        }
        return null;
    }
    
    public void put(T1 key, T2 value){
        size++;
        //System.out.println((float)size/(float)currentCapacity );
        if((float)size/(float)currentCapacity > loadFactor){
            ensureCapacity();
        }
        int index = key.hashCode()%currentCapacity;
        if(internalArray[index] == null || key == null){
            internalArray[index] = new LinkedList<>();
        }
        Iterator<MyEntry> itr = internalArray[index].iterator();
        while(itr.hasNext()){
            MyEntry entry = itr.next();
            if(key.equals(entry.getKey())){
                entry.setValue(value);
                return;
            }
        }
        MyEntry entry = new MyEntry(key, value);
        internalArray[index].add(entry);
    }
    
    public void remove(T1 key){
        int index = key.hashCode()%currentCapacity;
        if(internalArray[index] == null || key == null){
            return;
        }
        Iterator<MyEntry> itr = internalArray[index].iterator();
        while(itr.hasNext()){
            if(key.equals(itr.next().getKey())){
                itr.remove();
                size--;
                return;
            }
            
        }
        return;
    }
    
    public String toString(){
        return Arrays.toString(internalArray);
    }
    
    public MyList<T1> keySet(){
        MyList<T1> list = new MyList(this.size);
        for(LinkedList<MyEntry> li: internalArray){
            if(li == null){
                continue;
            }
            for(MyEntry entry: li){
                list.add((T1)entry.getKey());
            }
        }
        return list;
    }
    
    public MyList<T2> values(){
        MyList<T2> list = new MyList(this.size);
        for(LinkedList<MyEntry> li: internalArray){
            if(li == null){
                continue;
            }
            for(MyEntry entry: li){
                list.add((T2)entry.getValue());
            }
        }
        return list;
    }
}

class MyEntry<T1, T2>{
    private T2 value;
    private T1 key;

    MyEntry(T1 aKey, T2 aValue){
        key = aKey;
        value = aValue;
    }
    /**
     * @return the key
     */
    public T1 getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(T1 key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public T2 getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T2 value) {
        this.value = value;
    }
    
    public String toString(){
        return key+":"+value;
    }
    

}

class MySet<T> implements Iterable{
    private static final int initialCapacity = 10;
    private int currentCapacity = initialCapacity;
    private static final float loadFactor = 0.75f;
    private int size = 0;
    private LinkedList<T>[] internalArray;
    
    MySet(){
        this(initialCapacity);
    }
    MySet(int capacity){
        currentCapacity = capacity;
        internalArray = new LinkedList[currentCapacity];
    }
    
    private void ensureCapacity(){
        currentCapacity *= currentCapacity;
        LinkedList<T>[] newArray = new LinkedList[currentCapacity];
        for(LinkedList list: internalArray){
            
            if(list == null){
                continue;
            }
            Iterator<T> itr = list.iterator();
            while(itr.hasNext()){
                T value = itr.next();
                int index = value.hashCode()%currentCapacity;
                if(newArray[index] == null){
                    newArray[index] = new LinkedList();
                }
                newArray[index].add(value);
            }
        }
        internalArray = newArray;
    }
    
    public void add(T item){
        if(item == null){
            return;
        }
        int index = item.hashCode()%currentCapacity;
        if(internalArray[index] == null){
            size++;
            if((float)size/(float)currentCapacity > loadFactor){
                ensureCapacity();
                index = item.hashCode()%currentCapacity;
            }
            internalArray[index] = new LinkedList<>();
        }
        Iterator<T> itr = internalArray[index].iterator();
        while(itr.hasNext()){
            T val = itr.next();
            if(item.equals(val)){
                val = item;
                return;
            }
        }
        internalArray[index].add(item);
    }
    
    public void remove(T item){
        int index = item.hashCode()%currentCapacity;
        LinkedList<T> list = internalArray[index];
        if(list == null || item == null){
            return;
        }
        Iterator<T> itr = list.iterator();
        while(itr.hasNext()){
            if(item.equals(item)){
                itr.remove();;
                size--;
                return;
            }
        }
        return;
    }
    
    public String toString(){
        return Arrays.toString(internalArray);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            int index = -1;
            @Override
            public boolean hasNext() {
                if(index+1 < size){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if(hasNext()){
                    return internalArray[++index];
                }
                return false;
            }
            
        };
    }
}

class MyList<T> implements Iterable{
    private static final int initialCapacity = 3;
    private int currentCapacity = initialCapacity;
    private int size = 0;
    private T[] internalArray;
    
    MyList(){
        this(initialCapacity);
    }
    
    MyList(int capacity){
        currentCapacity = capacity;
        internalArray = (T[])new Object[currentCapacity];  
    }
    
    public void add(T item){
        size++;
        if(size > currentCapacity){
            currentCapacity *= 2;
            internalArray = Arrays.copyOf(internalArray, currentCapacity);
        }
        internalArray[size-1] = item;
    }
    
    public void remove(T item){
        if(item == null){
            return;
        }
        for(int i = 0; i < size; i++){
            if(item.equals(internalArray[i])){
                for(int j = i+1; j < size; j++){
                    internalArray[j] = internalArray[j-1];
                }
                size--;
            }
        }
    }
    
    public T get(int index){
        if(index < size){
            return internalArray[index];
        }
        return null;
    }
    
    public boolean contains(T item){
        if(item == null){
            return false;
        }
        for(int i = 0; i < size; i++){
            if(item.equals(internalArray[i])){
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        return Arrays.toString(internalArray);
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            int index = -1;
            @Override
            public boolean hasNext() {
                if(index+1 < size){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if(hasNext()){
                    return internalArray[++index];
                }
                return null;
            }
            
        };
    }
}

class MyStack<T>{
    StackNode currentNode;
    
    public T peek(){
        return (T)currentNode.getValue();
    }
    
    public T poll(){
        T retVal = (T)currentNode.getValue();
        currentNode = currentNode.getPrevNode();
        return retVal;
    }
    
    public void push(T val){
        StackNode node = new StackNode(val, currentNode);
        currentNode = node;
    }
    
    public boolean isEmpty(){
        boolean retVal;
        return (currentNode == null)? true: false;
    }
}

class StackNode<T>{
    private T value;
    private StackNode<T> prevNode;
    
    StackNode(T val, StackNode node){
        value = val;
        prevNode = node;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the prevNode
     */
    public StackNode<T> getPrevNode() {
        return prevNode;
    }

    /**
     * @param prevNode the prevNode to set
     */
    public void setPrevNode(StackNode<T> prevNode) {
        this.prevNode = prevNode;
    }
}

