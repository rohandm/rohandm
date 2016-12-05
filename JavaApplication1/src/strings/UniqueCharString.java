/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * @author rohan_000
 */
public class UniqueCharString{
	public static void main(String args[]){
	int[] arr = new int[128];//Only for ascii char string
	int max = 0;
	String str = "abcd";
	char[] chArr = str.toCharArray();
	for(char ch: chArr){
		if(arr[ch] >= 1){
			System.out.println("Duplicate char found");
			return;
                }
                arr[ch]++;
	}
	System.out.println("String chars are unique");
}
}
