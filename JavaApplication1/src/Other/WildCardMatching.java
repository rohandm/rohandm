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
public class WildCardMatching {
    public static void main(String[] args){
        System.out.println(isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }
    public static boolean isMatch(String s, String p) {
        if((s == null && p == null) || ( s == "" && p == "")){
            return true;
        }
        if(s == null || p == null){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int sInd = 0;
        int pInd = 0;
        while(sInd < sArr.length && pInd < pArr.length){
            if(sArr[sInd] != pArr[pInd] && pArr[pInd] != '?'){
                
                if(pArr[pInd] == '*'){
                    if(pInd < pArr.length - 1 && pArr[pInd+1] == sArr[sInd]){
                        //System.out.println(sArr[sInd] + " "+pArr[pInd]+" "+pArr[pInd+1]);
                        ++pInd;
                    }
                    else{
                        //System.out.println(sArr[sInd] + " "+pArr[pInd]);
                        ++sInd;
                        continue;
                    }
                }
                else if(pInd > 1 && sInd > 0 
                        && pArr[pInd-1] == sArr[sInd-1] 
                        && pArr[pInd-2] == '*'){
                    //System.out.println(sArr[sInd] + " "+pArr[pInd]);
                    pInd = pInd-2;
                }
            }
            ++sInd;
            ++pInd;
        }
        //System.out.println(sInd + " "+sArr.length+" "+pInd+" "+pArr.length);
        if(sInd == sArr.length || !(pInd == pArr.length || (pInd == pArr.length-1 && pArr[pArr.length-1] == '*'))){
            return false;
        }
        return true;
    }
}
