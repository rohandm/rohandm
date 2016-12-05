/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

public class StringPermutations{
	public static void main(String args[]){
	int[] arr1 = new int[128];//Only for ascii char string


	int max = 0;
	String str1 = "abcd";
	String str2 = "acdb";
	char[] chArr1 = str1.toCharArray();
	char[] chArr2 = str2.toCharArray();
	for(int i = 0; i < chArr1.length; i++){
            arr1[chArr1[i]]++;
	}
	for(int i = 0; i < chArr2.length; i++){
            arr1[chArr2[i]]--;
	}
	for(int i = 0; i < arr1.length; i++){
		if(arr1[i] != 0){
			System.out.println("Not a permutation");
			return;
        }
	}
	System.out.println("Strings are permutation");
}
}
