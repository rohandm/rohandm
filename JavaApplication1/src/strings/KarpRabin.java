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
public class KarpRabin {
    public static void main(String args[]){
        String message = "sdjskjdabcksdjskdabcdfd";
        String pattern = "abc";
        
        int primeNum = 101;
        
        int patLen = pattern.length();
        int patHash = 0;
        int msgHash = 0;
        char[] patArr = pattern.toCharArray();
        char[] msgArr = message.toCharArray();
        //O(p)
        for(int i = 0; i < patLen; i++){
            patHash = patHash + patArr[i]*(int)Math.pow(primeNum, i); 
            msgHash = msgHash +  msgArr[i]*(int)(Math.pow(primeNum, i));
        }
        boolean match = true;
        //O(p) best(1)
        if(patHash == msgHash){
            match = true;
            
            for(int i = 0; i < patLen; i++){
                if(msgArr[i] != patArr[i]){
                    match = false;
                    break;
                }
            }
            if(match){
                System.out.println("pattern found at index: 0");
            }
        }
        //O(mp) best(m) average(m+p)
        for(int i = 1; i < message.length()-patLen; ++i){
            match = true;
            //rolling hash
            msgHash = (msgHash-msgArr[i-1])/primeNum + msgArr[i+patLen-1]*(int)Math.pow(primeNum, patLen-1);
            System.out.println(patHash+" "+msgHash);
            if(patHash == msgHash){
                for(int j = i; j < i+patLen; ++j){
                    if(msgArr[j] != patArr[j%i]){
                        match = false;
                        break;
                    }
                }
                if(match){
                    System.out.println("pattern found at index: "+i);
                }
            }
        }
    }
}
