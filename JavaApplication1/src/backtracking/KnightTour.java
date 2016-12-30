/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class KnightTour{
	public static void main(String[] args){
		int n = 3;
		visited = new boolean[n][n];
		System.out.println(findKnightTour(0, 0, "0-0"));
	}
	static int[][] moves = {{-1, -2}, {1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}};
        static boolean[][] visited;
	public static boolean findKnightTour(int x, int y, String path){
            System.out.println(x+" "+y);
		if(x < 0 || y < 0 || x >= visited.length || y >= visited.length){
			return false;
		}
		String pos = x+"-"+y;
		if(visited[x][y]){
			if(checkIfAllTrue()){
                            return true;
                        }
                        else{
                            visited[x][y] = false;
                            return false;
                        }
		}
		visited[x][y] = true;
		path = path+" "+pos;
		
		for(int i = 0; i < moves.length; i++){
			if(findKnightTour(x+moves[i][0], y+moves[i][1], path)){
				return true;
			}
		}
                visited[x][y] = false;
                return false;
	}
        
        public static boolean checkIfAllTrue(){
            for(int i = 0; i < visited.length; i++){
                for(int j = 0; j < visited.length; j++){
                    if(!visited[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }
}