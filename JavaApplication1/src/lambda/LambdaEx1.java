/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author rohan_000
 */
public class LambdaEx1 {
    public static void main(String args[]){
        MyInterface myObj;
        
        //myObj = (n) -> n*Math.random();
        //myObj = () -> "";
        
        //System.out.println(myObj.getValue(5));
        System.out.println(getVal((n)->n*Math.random(), 8));
    }
    public static double getVal(MyInterface myObj, int n){
        return myObj.getValue(n);
    }
}

interface MyInterface{
    double getValue(int n);
}
