package DP;

import java.util.*;
public class AvoidRoads{
    private int[][] cache;
    private List badList;
    public long numWays(int width, int height, String[] bad){
        if(width == 0 && height == 0){
            return 0;
        }
        cache = new int[width+1][height+1];
        for(int[] row:cache){
            Arrays.fill(row, -1);
        }
        cache[0][0] = 0;
        cache[0][1] = 1;
        cache[1][0] = 1;
        badList = new ArrayList(Arrays.asList(bad));
        long ret = 0;
        ret = findWay(width, height);
        return ret;
    }
    
    private long findWay(int x, int y){
        long ret = 0;
        if(cache[x][y] > -1){
            return cache[x][y];
        }
        if(x >= 1 && y >= 0 && !blocked(x-1, y, x, y) ){
            ret += findWay(x-1, y);
        }
        if(x >= 0 && y >= 1 && !blocked(x, y-1, x, y)){
            ret += findWay(x, y-1);
        }
        
        System.out.println(x+" "+y+" "+ret);
        return ret;
    }
    
    private boolean blocked(int x, int y, int x1, int y1){
        if(badList.contains(x+" "+y+" "+x1+" "+y1)
          || badList.contains(x1+" "+y1+" "+x+" "+y)){
            System.out.println("Blocked "+x+" "+y+" "+x1+" "+y1);
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        AvoidRoads ar = new AvoidRoads();
        //System.out.println(ar.numWays(6, 6, new String[]{"0 0 0 1","6 6 5 6"}));
        System.out.println(ar.numWays(1, 1, new String[]{}));
    }
}