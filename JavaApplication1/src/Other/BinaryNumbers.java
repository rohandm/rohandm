/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author rohan_000
 */
public class BinaryNumbers {
    public static void main(String args[]){
        System.out.println("Binary representation of 13 is "+Integer.toBinaryString(13));
        System.out.println("Binary representation of -13 is "+Integer.toBinaryString(-13));
        
        System.out.println("Convert to lower case:");
        System.out.println(Character.toChars('A' | ' '));
        System.out.println("Convert to upper case:");
        System.out.println(Character.toChars('a' & '_'));
        System.out.println("Invert case:");
        System.out.println(Character.toChars('a' ^ ' '));
        System.out.println(Character.toChars('A' ^ ' '));
        System.out.println("Max int:"+~(1<<31));
        System.out.println("Max int:"+((1<<31)-1));
        System.out.println("Max int:"+~(1<<-1));
        System.out.println("Min int:"+(1<<31));
        System.out.println("Max long:"+~((long)1<<127));
        
    }
}
