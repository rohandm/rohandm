/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

/**
 *
 * @author rohan_000
 */
public class ReverseBits {
    public static void main(String args[]){
        int n = 11;
        int output = 0;
        output = output^n&1;
        n = n >> 1;
        while(n!=0){
            output = output << 1; 
            output = output^n&1;
            n = n >> 1;
        }
        System.out.println(output);
    }
}
