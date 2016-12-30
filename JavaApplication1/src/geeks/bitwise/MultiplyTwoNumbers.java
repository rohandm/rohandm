/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.bitwise;

/**
 *
 * @author ROHANME
 */
public class MultiplyTwoNumbers{
	public static void main(String[] args){
		int n = 7;
                int m = 6;
                int result = m;
		int p = Integer.MAX_VALUE;
                int temp = 0;
                int temp1 = n;
		while(p > 0){
                    if(p == Integer.MAX_VALUE){
                        p = 0;
                    }
                    temp1 = temp1-(int)Math.pow(2, p);
			p = getLowerPowOf2(temp1);
                        System.out.println(p+ " "+n);
                        if(p < 0){
                            break;
                        }
			temp = m << p;
			if(temp < m){
				System.out.println("Overflow");
				break;
			}
                        result += temp;
		}
		
		System.out.println(result);
	}
	
	public static int getLowerPowOf2(int n){
		int p = 0;
		
		while(Math.pow(2, p) <= n){
			++p;
		}
		return p-1;
	}
	
	
}