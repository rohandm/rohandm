/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.Arrays;

/**
 *
 * @author rohan_000
 */
public class ReversePolishNotation {
    public static void main(String args[]){
        String[] arr = {"2", "1", "+", "3", "*"};
        Arrays.stream(arr)
                .reduce("",(a,b) -> {
                    if(b="+"){
                });
    }
}
