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
public class Carrotland {

    static int d = 0;
    
    public static void main(String args[]){
        //int[][] arr = {{2, 3}, {6, 9}, {10, 160}};
        int[][] arr = {{91207, 89566}, {-88690, -83026}, {67100, 47194}};
        System.out.println(answer(arr));
    }

    public static int answer(int[][] vertices) {
        long x1 = vertices[0][0];

        long y1 = vertices[0][1];

        long x2 = vertices[1][0];

        long y2 = vertices[1][1];

        long x3 = vertices[2][0];

        long y3 = vertices[2][1];
        
        System.out.println((x2-x1)+" "+(y2-y1)+" "+Math.abs(gcd(x2-x1, y2-y1)));
        System.out.println((x3-x2)+" "+(y3-y2)+" "+Math.abs(gcd(x3-x2, y3-y2)));
        System.out.println((x1-x3)+" "+(y1-y3)+" "+Math.abs(gcd(x1-x3, y1-y3)));
        
        long d = Math.abs(gcd(x2-x1, y2-y1)) + Math.abs(gcd(x3-x2, y3-y2)) + Math.abs(gcd(x1-x3, y1-y3));
        System.out.println(x1*(y2-y3));
        System.out.println(x2*(y3-y1));
        System.out.println(x3*(y1-y2));
        long area = Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2;
        System.out.println(area);
        //System.out.println(getArea(x1, y1, x2, y2, x3, y3));
        //System.out.println(area(vertices));
        return (int)(area - d/2 + 1);

    }
    
    private static long gcd(long a, long b){
        if(a == 0 || b == 0){
            return Math.abs(a+b);
        }
        return gcd(b, a%b);
    }
    
    private static double getArea(long x1, long y1, long x2, long y2, long x3, long y3) {
        double a = calculateDistance(x1, y1, x2, y2);
        double b = calculateDistance(x2, y2, x3, y3);
        double c = calculateDistance(x3, y3, x1, y1);

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
* Calculate the distance between two points on a 2D plane using the Pythagorean theorem.
*/
    private static double calculateDistance(long x1, long y1, long x2, long y2) {
        long a = Math.abs(x1 - x2);
        long b = Math.abs(y1 - y2);
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
    public static long area(long[][] vertices) {
    return Math.abs((vertices[1][0] - vertices[0][0]) * (vertices[2][1] - vertices[0][1])
            - (vertices[2][0] - vertices[0][0]) * (vertices[1][1] - vertices[0][1]));
    }
}
