package DP;


import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan_000
 */
public class ChessMetric {
    public long howMany(int size, int[] start, int[] end, int numMoves){
        int[][] moves = new int[][]{ {0, 1, 0, 1, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}};
        long[][] board = new long[size][size];
        long[][] board1 = new long[size][size];
        
        board[start[0]][start[1]] = 1;
        
        for(int i = 0; i < numMoves; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(board[j][k] > 0){
                        int x1 = Math.max(j-2, 0);
                        int x2 = Math.min(j+2, size-1);
                        int y1 = Math.max(k-2, 0);
                        int y2 = Math.min(k+2, size-1);
                        //System.out.println(i + " " + j + " "+k);
                        //System.out.println(x1 + " "+y1+" "+x2+" "+y2);
                        for(int l = x1; l <= x2; l++){
                            for(int m = y1; m <= y2; m++){
                                board1[l][m] = board1[l][m]+board[j][k]*moves[l-(j-2)][m-(k-2)];
                            }
                        }
                        //board[j][k]--;
                    }
                }
            }
            /*for(int[] row: board1){
                System.out.println(Arrays.toString(row));
            }
            
            System.out.println("\n\n");*/
            board = board1;
            board1 = new long[size][size];
        }
        return board[end[0]][end[1]];
    }
    
    public static void main(String args[]){
        ChessMetric cm = new ChessMetric();
        System.out.println(cm.howMany(3, new int[]{0, 0}, new int[]{1, 0}, 1));
        //System.out.println(cm.howMany(3, new int[]{0, 0}, new int[]{2, 2}, 1));
        //System.out.println(cm.howMany(3, new int[]{0, 0}, new int[]{0, 0}, 2));
    }
}
