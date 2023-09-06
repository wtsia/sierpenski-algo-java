import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * This program generates and prints the Sierpinski Triangle pattern using recursion.
 * It starts with a sideLength equilateral triangle and recursively draws smaller triangles.
 * Customize the initial triangle's size and iteration depth.
 *
 * @author Winston Tsia
 * @since August 27, 2023
 */
class SierpinskiTriangle {
    /**
     * helper function to call other methods and draw triangle
     * @param sideLength
     * @return
     */
    private static void drawSierpinski(int sideLength, int depth) {
        double[][] triangle = sierpinskiGenerator(sideLength, depth);
        sierpinskiDivider(triangle, depth);
        // print
    }

    /**
     *
     * @param inputTriangle
     * @param depth
     * @return
     */
    private static double[][] sierpinskiDivider(double[][] inputTriangle, int depth) {
        if (depth == 0) {
            return inputTriangle;
        };

        double[][]triangleMidpoint = new double[4][];
        triangleMidpoint[0]= midpoint(inputTriangle[0], inputTriangle[1]);
        triangleMidpoint[1]= midpoint(inputTriangle[0], inputTriangle[2]);
        triangleMidpoint[2]= midpoint(inputTriangle[1], inputTriangle[2]);

        // substitute data into initial triangle's last empty array for segment removal w/ height and length
        inputTriangle[3][0] = triangleMidpoint[0][0];
        inputTriangle[3][1] = triangleMidpoint[1][0] - triangleMidpoint[0][0];

        double[][]subTriangle1 = new double[4][];
        subTriangle1[0] = inputTriangle[0];
        subTriangle1[1] = triangleMidpoint[1];
        subTriangle1[2] = triangleMidpoint[2];

        double[][]subTriangle2 = new double[4][];
        subTriangle2[0] = triangleMidpoint[0];
        subTriangle2[1] = inputTriangle[1];
        subTriangle2[2] = triangleMidpoint[1];

        double[][]subTriangle3 = new double[4][];
        subTriangle3[0] = triangleMidpoint[2];
        subTriangle3[1] = triangleMidpoint[1];
        subTriangle3[2] = inputTriangle[2];

        sierpinskiDivider(subTriangle1, depth - 1);
        sierpinskiDivider(subTriangle2, depth - 1);
        sierpinskiDivider(subTriangle3, depth - 1);

        return inputTriangle;
    };

    /**
     * Constructs a sierpinski triangle using input sideLength for a coordinate system stored in a 2-dimensional array
     * with the 4th element used for storing the distance between the midpoints.
     * @param sideLength
     * @return A 2-dimensional array with the dimensions of an equilateral triangle of `sideLength` length
     */
    private static double[][] sierpinskiGenerator(int sideLength, int depth) {
        // Triangle formed from bottom left at origin (0,0), midpoint between left and top, top with x,y coord, ...
        double[][] baseTriangle = new double[depth*6][];
        baseTriangle[0] = new double[]{0, 0};
        baseTriangle[1] = new double[]{sideLength / 2.0, Math.sqrt(3) / 2.0 * sideLength};
        baseTriangle[2] = new double[]{sideLength, 0};
        baseTriangle[3] = new double[]{0, 0}; // initialize removal height and removal length as 0
        return baseTriangle;
    };

    /**
     *
     * @param A
     * @param B
     * @return a single array with 2 elements, which are the midpoint between the coordinates stored in A and B
     */
    private static double[] midpoint(double[] A, double[] B) {
        return new double[]{ Math.abs(A[0] + B[0]) / 2.0 , Math.abs(A[1] + B[1]) / 2.0};
    };

    public static void main(String[] args) {
        int sideLength = 16;
        int depth = 2;
        drawSierpinski(sideLength, depth);
    }
}
