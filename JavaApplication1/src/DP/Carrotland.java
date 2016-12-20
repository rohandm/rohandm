package DP;

import java.util.Arrays;

/**
 * Carrotland ==========
 *
 * The rabbits are free at last, free from that horrible zombie science
 * experiment. They need a happy, safe home, where they can recover.
 *
 * You have a dream, a dream of carrots, lots of carrots, planted in neat rows
 * and columns! But first, you need some land. And the only person who's selling
 * land is Farmer Frida. Unfortunately, not only does she have only one plot of
 * land, she also doesn't know how big it is - only that it is a triangle.
 * However, she can tell you the location of the three vertices, which lie on
 * the 2-D plane and have integer coordinates.
 *
 * Of course, you want to plant as many carrots as you can. But you also want to
 * follow these guidelines: The carrots may only be planted at points with
 * integer coordinates on the 2-D plane. They must lie within the plot of land
 * and not on the boundaries. For example, if the vertices were (-1,-1), (1,0)
 * and (0,1), then you can plant only one carrot at (0,0).
 *
 * Write a function answer(vertices), which, when given a list of three
 * vertices, returns the maximum number of carrots you can plant.
 *
 * The vertices list will contain exactly three elements, and each element will
 * be a list of two integers representing the x and y coordinates of a vertex.
 * All coordinates will have absolute value no greater than 1000000000. The
 * three vertices will not be collinear.
 *
 * Languages =========
 *
 * To provide a Python solution, edit solution.py To provide a Java solution,
 * edit solution.java
 *
 * Test cases ==========
 *
 * Inputs: (int) vertices = [[2, 3], [6, 9], [10, 160]] Output: (int) 289
 *
 * Inputs: (int) vertices = [[91207, 89566], [-88690, -83026], [67100, 47194]]
 * Output: (int) 1730960165
 *
 * Use verify [file] to test your solution and see how it does. When you are
 * finished editing your code, use submit [file] to submit your answer. If your
 * solution passes the test cases, it will be removed from your home folder.
 */
/**
 *
 * @author rohan_000
 */
public class Carrotland {

    static int d = 0;

    public static void main(String args[]) {
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

        System.out.println((x2 - x1) + " " + (y2 - y1) + " " + Math.abs(gcd(x2 - x1, y2 - y1)));
        System.out.println((x3 - x2) + " " + (y3 - y2) + " " + Math.abs(gcd(x3 - x2, y3 - y2)));
        System.out.println((x1 - x3) + " " + (y1 - y3) + " " + Math.abs(gcd(x1 - x3, y1 - y3)));

        long d = Math.abs(gcd(x2 - x1, y2 - y1)) + Math.abs(gcd(x3 - x2, y3 - y2)) + Math.abs(gcd(x1 - x3, y1 - y3));
        System.out.println(x1 * (y2 - y3));
        System.out.println(x2 * (y3 - y1));
        System.out.println(x3 * (y1 - y2));
        long area = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
        System.out.println(area);
        //System.out.println(getArea(x1, y1, x2, y2, x3, y3));
        //System.out.println(area(vertices));
        return (int) (area - d / 2 + 1);

    }

    private static long gcd(long a, long b) {
        if (a == 0 || b == 0) {
            return Math.abs(a + b);
        }
        return gcd(b, a % b);
    }

    private static double getArea(long x1, long y1, long x2, long y2, long x3, long y3) {
        double a = calculateDistance(x1, y1, x2, y2);
        double b = calculateDistance(x2, y2, x3, y3);
        double c = calculateDistance(x3, y3, x1, y1);

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Calculate the distance between two points on a 2D plane using the
     * Pythagorean theorem.
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
