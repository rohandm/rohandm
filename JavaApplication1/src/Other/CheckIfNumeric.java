/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.util.*;

/**
 *
 * @author ROHANME
 */
public class CheckIfNumeric{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String nextLine = scan.nextLine();
		while(nextLine != "EOF"){
			System.out.println(nextLine.matches("[-$]?\\d+(\\.\\d+)?(e\\d+)?x?"));
                        nextLine = scan.nextLine();
		}
	}
}
