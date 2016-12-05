package Other; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridZero {   


    int[] x;
    public static void main(String args[]){
        int size = 15;
        int[][] matrix = new int[size][size];
        
        for(int p = 0; p < 1; p++){
            int num = 0;
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    int rand = (int)Math.round(Math.random());
                    /*if(num < 112 && rand == 1){
                        matrix[i][j] = rand;
                        num++;
                    }
                    else{
                        matrix[i][j] = 0;
                    }*/
                    if(rand == 1 && num < 50){
                        fillMoves1(matrix, size, i, j);
                    }
                    num++;
                    
                }
            }
        //displayMatrix(matrix);
        int retVal = answer(matrix);
        System.out.println(answer(matrix));
        }
    }
    public static void displayMatrix(int[][] matrix){
        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }
   public static int answer(int[][] matrix){
       int len = matrix.length;
       if(len < 0){
           return -1;
       }
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return matrix[0][0];
        }
        int lenSq = len*len;
        int[][] arr = new int[lenSq][lenSq];
        for(int i = 0; i < len; i++){
            
            for(int j = 0; j < len; j++){
                fillMoves(arr, len, i, j);
            }
        }
        int ind = 0;
        int[] b = new int[lenSq];
        int sum = 0;
        for(int[] rMatrix: matrix){
            for(int el: rMatrix){
                b[ind++] = el;
                sum+=el;
            }
        }
        //System.out.println(sum);
        int retVal = geSolve(arr, b);
        /*if(retVal > 85 && len == 15){
            return 50;
        }*/
        return retVal;
        
    }
    
    public static void fillMoves(int[][] arr, int len, int row, int col){
        int colId = row*len+col;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i == row || j == col){
                    arr[i*len+j][colId] ^= 1;
                }
            }
        }
    }
    
    public static void fillMoves1(int[][] arr, int len, int row, int col){
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i == row || j == col){
                    arr[i][j] ^= 1;
                }
            }
        }
    }
    public static int geSolve(int[][] A, int[] b){
        int size = b.length;
        /*for( int[] row: A){
            System.out.println(Arrays.toString(row));
        }*/
        for(int i = 0; i < size; ++i){
            int max = i;
            for(int j = i+1; j < size; ++j){
                if(Math.abs(A[j][i]) > Math.abs(A[max][i])){
                    max = j;
                }
            }
            int[] temp = A[max];
            A[max] = A[i];
            A[i] = temp;
            int tempB = b[max];
            b[max] = b[i];
            b[i] = tempB;
            
            if(A[i][i] != 0){
                for(int j = i+1; j < size; ++j){
                    int f = A[j][i]/A[i][i];
                    //b[j] = Math.abs(b[j]-f*b[i])%2;
                    b[j] = b[j] ^ (f & b[i]);
                    for(int k = i; k < size; k++){
                        //A[j][k] = Math.abs(A[j][k]-f*A[i][k])%2;
                        A[j][k] = A[j][k] ^ (f & A[i][k]);
                    }
                }
            }
            
            /*System.out.print(i);
            for( int[] row: A){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("\n"+Arrays.toString(b)+"\n");*/
        }
        int[] x = new int[size];
        List<Integer> list = new ArrayList<>();
        for(int i = size - 1; i >= 0; --i){
            int sum = 0;
            for(int j = i+1; j < size; ++j){
                //sum += A[i][j]*x[j];
                //sum = sum%2;
                sum = sum ^ (A[i][j] & x[j]);
            }
            //sum = Math.abs(sum)%2;
            //b[i] = Math.abs(b[i])%2;
            if(A[i][i] == 0){
                 if(sum != b[i]){
                    return -1;
                 }
                 else{
                     list.add(i);//x[i] = 1;//0
                 }
            }
            else{
                //x[i] = Math.abs(b[i] + sum)%2;
                x[i] = b[i] ^ sum;
            }
        }
        int moves = 0;
        for(int el: x){
            moves += el;
        }
        if(list.size() > 0){
            int i = list.get(0);
            List<Integer> exList = new ArrayList<>();
            exList.add(i);
            int ret = eval(A, b, i, exList);
            
            if(ret > 0){
                moves = Math.min(moves, ret);
            }
        }
        return moves;
    }
    
    private static int eval(int[][] A, int[] b, int ind, List<Integer> exList) {
        int size = b.length;
        int retVal = Integer.MAX_VALUE;
        for(int p = 0; p < 2; ++p){
            int[] x = new int[size];
            x[ind] = p;
            List<Integer> list = new ArrayList<>();
            for(int i = size - 1; i >= 0; --i){

                int sum = 0;
                for(int j = i+1; j < size; ++j){
                    if(exList.contains(j)){
                        continue;
                    }
                    //sum += A[i][j]*x[j];
                    //sum = sum%2;
                    sum = sum ^ (A[i][j] & x[j]);
                }
                //sum = Math.abs(sum)%2;
                //b[i] = Math.abs(b[i])%2;
                if(A[i][i] == 0){
                     if(sum != b[i]){
                        return Integer.MAX_VALUE;
                     }
                     else{
                         list.add(i);//x[i] = 1;//0
                         exList.add(i);
                     }
                }
                else{
                    //x[i] = Math.abs(b[i] + sum)%2;
                    x[i] = b[i] ^ sum;
                }
            }
            int moves = 0;
            for(int el: x){
                moves += el;
            }
        if(list.size() > 0){
                int i = list.get(0);
                int ret = eval(A, b, i, exList);
                if(ret > 0){
                    moves = Math.min(moves, ret);
                }
            }
            if(moves > 0){
                    retVal = Math.min(moves, retVal);
            }
        }
        return retVal;
    }
}