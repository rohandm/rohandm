/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

import java.util.Stack;

/**
 *
 * @author rohan_000
 */
public class QueueUsingStack<T>{
    Stack<T> stack1;
    Stack<T> stack2;
    QueueUsingStack(){
            stack1 = new Stack();
            stack2 = new Stack();
    }
    public void enqueue(T item){
        while(!stack1.isEmpty()){
                stack2.push(stack1.pop()); //1) 2) A 3) A B
        }
        stack2.push(item); //1) A 2) A B 3) A B C
        while(!stack2.isEmpty()){
                stack1.push(stack2.pop()); //1) A 2) B A 3) C B A
        }
    }


    public T dequeue(){
        if(!stack1.isEmpty()){
                return stack1.pop();
        }
        return null;
    }


    public boolean isEmpty(){
            return stack1.isEmpty();
    }
    public static void main(String args[]){
        QueueUsingStack<String> queue = new QueueUsingStack<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}