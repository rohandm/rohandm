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
public class DivideBitwise{
	public static void main(String[] args){
		int dividend = 45;
		int divisor = 5;
		int quotient = 0;
                int temp = dividend;
		do{
			quotient += divide(temp, divisor);
                        temp = dividend - divisor*quotient;
                        System.out.println(quotient+ " "+temp);
		} while(divisor*quotient < dividend);
		
		System.out.println(quotient);
	}
	
	public static int divide(int dividend, int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		int quotient = 1;
		int temp = divisor;
		if(dividend == divisor){
			return 1;
		}
		if(divisor > dividend){
			return 0;
		}
		while(temp < dividend){
			temp = temp << 1;
			quotient = quotient << 1;
		}
		
		return quotient >> 1;
	}
	
	
}