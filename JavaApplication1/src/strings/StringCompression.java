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
public class StringCompression{
	public static void main(String args[]){
	String str = "aabcccccaaa";
	
	char[] chArr = str.toCharArray();
	StringBuilder strB = new StringBuilder();
        int j = 0;
	for(int i = 0; i < chArr.length; i = i+j){
		j = 1;
		while(i+j < chArr.length && chArr[i+j] == chArr[i]){
			j++;
		}
		strB.append(chArr[i]).append(j);
	}
        String str1 = strB.toString();
	if(str1.length() < str.length()){
	System.out.println(strB.toString());
        }
        else{
                System.out.println(str);
        }
}
}
