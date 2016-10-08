/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.math.BigInteger;

/**
 *
 * @author rohan_000
 */
public class CanonicalAddress {
    public static void main(String args[]){
        System.out.println(X86IsCanonicalAddress("1111111111111111101001001000010010000101010101010101010101010101"));
    }
    
    public static boolean X86IsCanonicalAddress(String binStr){
        BigInteger bigInt = new BigInteger(binStr, 2);
        return bigInt.shiftRight(48).equals(new BigInteger("1111111111111111", 2)) || bigInt.shiftRight(48).equals(new BigInteger("0000000000000000", 2));
    }
}
