/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

/**
 *
 * @author ROHANME
 */
public class ClockAngle {
    public static void main(String args[]){
        System.out.println(angle("3:27"));
    }
    
    public static double angle(String time){
        String[] tokens = time.split(":");
        if(tokens.length != 2 ){
            return 0;
        }
        int hour = Integer.parseInt(tokens[0]);
        int min = Integer.parseInt(tokens[1]);
        
        return Math.abs((hour*30 + min/2) - min*6);
    }
}
