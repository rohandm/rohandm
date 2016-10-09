/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
class DrawerChest {
    private static BigInteger[][] lockedDrawers = new BigInteger[65][65];
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 65; i++){
            Arrays.fill(lockedDrawers[i], BigInteger.valueOf(-1));
        }
        lockedDrawers[0][0] = BigInteger.valueOf(0);
        lockedDrawers[1][1] = BigInteger.valueOf(1);
        lockedDrawers[1][0] = BigInteger.valueOf(1);
        lockedDrawers[2][0] = BigInteger.valueOf(2);
        lockedDrawers[2][1] = BigInteger.valueOf(1);
        lockedDrawers[2][2] = BigInteger.valueOf(1);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        while(n1 >= 0 || n2 >= 0){
            if(n1 <= 0 || n2 <=0){
                continue;
            }
            System.out.println(countLockedDrawers(n1, n2));
            n1 = scan.nextInt();
            n2 = scan.nextInt();
        }
    }

    private static BigInteger countLockedDrawers(int n1, int p) {
        if(lockedDrawers[n1][p].compareTo(BigInteger.valueOf(0)) >= 0){
            return lockedDrawers[n1][p];
        }
        
        lockedDrawers[n1][p] = BigInteger.valueOf(0);
        if(n1 > 1){
            lockedDrawers[n1][p] = countLockedDrawers(n1-2, p);
        }
        if(n1 > 0 && p > 1){
                lockedDrawers[n1][p] = lockedDrawers[n1][p].add(countLockedDrawers(n1-1, p-1));
        }
        return lockedDrawers[n1][p];
    }
}
