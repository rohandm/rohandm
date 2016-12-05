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
public class StackSorter {

    public static Stack sort(Stack stack) { //159
        Stack tempStack = new Stack();
        
        int num2 = (int) stack.pop(); //1) 9
        int num1 = 0;//(int) stack.pop(); //1) 5
        while (!stack.isEmpty()) {
            num1 = (int) stack.pop();
            while(num1 < num2){
                stack.push(num2);
                if(tempStack.isEmpty()){
                    tempStack.push(num1);
                    num2 = (int)stack.pop();
                    num1 = (int)stack.pop();
                }
                else{
                    num2 = (int)tempStack.pop();
                }
            }
            //while (num1 >= num2) {
                tempStack.push(num2);//
                num2 = num1; //
                if (stack.isEmpty()) { //
                    tempStack.push(num2);
                    break;
                }
                 //
            //}
           /* while (num1 < num2) {
                //if (tempStack.isEmpty()) {
                    tempStack.push(num1);
                  //  break;
                //}
                //num2 = num1; //1.1)19
                if (stack.isEmpty()) { //
                    tempStack.push(num2);
                    break;
                }
                num1 = (int) tempStack.pop();//1.1) 2
            }*/
        }
        //tempStack.push(num1);
        return tempStack;
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(9);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack = StackSorter.sort(stack);
        System.out.println(stack);
    }
}
