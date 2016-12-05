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
public class BitwiseIntegerSum {
    public static void main(String args[]){
        int m = 5;
        int n = 7;
        int p = (m&n) << 1;
        int x = m^n;
        while(p != 0){
            int p1 = p&x;
            x = x ^ p;
            p = p1<<1;
        }
        System.out.println(x);
    }
}
