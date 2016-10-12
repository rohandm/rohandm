/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ROHANME
 */
class SitupBenches {
    static int[][] minVal = new int[24][5];
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            int cnt = scan.nextInt();
            
            int[][] benchTurnArr = new int[24][2];
            for(int k = 0; k < benchTurnArr.length; k++){
                Arrays.fill(benchTurnArr[k], -1);
            }
            for(int j = 0; j < cnt; j++){
                int hour = scan.nextInt();
                int incline = scan.nextInt();
                if(benchTurnArr[hour][0] < 0){
                    benchTurnArr[hour][0] = incline;
                }
                else{
                    benchTurnArr[hour][1] = incline;
                }
            }
            if(benchTurnArr[0][0] > -1){
                minVal[0][0] = Math.abs(benchTurnArr[0][0]-10);
                if(benchTurnArr[0][1] > -1){
                   minVal[0][1] = Math.abs(benchTurnArr[0][1]-10); 
                }
            }
            for(int k = 0; k < 24; k++ ){
                minVal[k]
            }
        }
    }
}

class BenchTurn{
    int hour;
    int incline;
    
    
    public int getHour(){
        return hour;
    }
    
    public int getIncline(){
        return incline;
    }
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public void setIncline(int incline){
        this.incline = incline;
    }
}
