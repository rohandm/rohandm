/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.*;

/**
 *
 * @author ROHANME
 */
public class MaxExpressionValue{
	public static void main(String[] args){
		String[] arr = {"1","+","2","*","3","+","4","*","5"};
		System.out.println(findMaxExpValue(arr, 0, arr.length-1));
                System.out.println(map);
	}
	static Map<String, Integer> map = new HashMap();
	static int findMaxExpValue(String arr[], int startInd, int endInd){
		if(startInd > endInd || endInd > arr.length-1){
			return 0;
		}
		if(startInd == endInd || startInd > endInd-3){
			if(arr[startInd] == "*" || arr[startInd] == "+"){
				return 0;
			}
			else{
				return Integer.valueOf(arr[startInd]);
			}
		}
		String key = startInd+"_"+endInd;
		Integer val = map.get(key);
		if(val != null){
			return val;
		}
		if(arr[startInd] == "*" || arr[startInd] == "+"){
			return 0;
		}
                int operand1 = Integer.valueOf(arr[startInd]);
                int operand2 = Integer.valueOf(arr[startInd+2]);
                int tempVal1 = 0;
                if(arr[startInd+1] == "*"){
                        val = operand1*findMaxExpValue(arr, startInd+2, endInd);
                        tempVal1 = operand1*operand2;
                }
                else if(arr[startInd+1] == "+"){
                        val = operand1+findMaxExpValue(arr, startInd+2, endInd);
                        tempVal1 = operand1+operand2;
                }
                if(startInd < arr.length-3){
                        if(arr[startInd+3] == "*"){
                                val = Math.max(val, tempVal1*findMaxExpValue(arr, startInd+4, endInd));
                        }
                        else if(arr[startInd+3] == "+"){
                                val = Math.max(val, tempVal1+findMaxExpValue(arr, startInd+4, endInd));
                        }
                }
		map.put(key, val);
		return val;
	}
}
