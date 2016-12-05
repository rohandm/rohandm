/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rohan_000
 */
public class StoreCredit {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int numTC = scanner.nextInt();
        int ind = 1;
        while(ind <= numTC){
            int credit = scanner.nextInt();
            int numItems = scanner.nextInt();
            int listInd = 1;
            int[] items = new int[credit];
            Arrays.fill(items, -1);
            while(listInd <= numItems){
                int itemPrice = scanner.nextInt();
                if(itemPrice < credit){
                    items[itemPrice] = listInd;
                }
                listInd++;
            }
            findItemstoBuy(ind, credit, items);
            ind++;
        }
    }

    private static void findItemstoBuy(int tcNum, int credit, int[] items) {
        for(int i = 0; i < items.length; i++){
            if(items[i] > 0 && items[credit-i] > 0){
                if(items[i] < items[credit-i]){
                    System.out.println("Case #"+tcNum+": "+items[i]+" "+items[credit-i]);
                    return;
                }
                else if(items[i] > items[credit-i]){
                    System.out.println("Case #"+tcNum+": "+items[credit-i]+" "+items[i]);
                    return;
                }
                
            }
        }
        System.out.println("Case #"+tcNum+": "+credit/2+" "+(credit/2+1));
    }
}
