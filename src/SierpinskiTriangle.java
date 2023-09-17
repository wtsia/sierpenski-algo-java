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
 *
 *
 * matrix of char
 *
 *16               *1
 *15              * *2
 *14             *   *3
 *12            * * * *4
 *12           *       *
 *11          * *     * *
 *10         *   *   *   *
 *9         * * * * * * * *
 *8        *               *
 *7       * *             * *
 *6      *   *           *   *
 *5     * * * *         * * * *
 *4    *       *       *       *
 *3   * *     * *     * *     * *
 *2  *   *   *   *   *   *   *   *
 *1 * * * * * * * * * * * * * * * *
 *
 */
class SierpinskiTriangle {
    private static void drawSierpinski(int sideLength, int depth) {
        char[] triangle = sierpinskiGenerator(sideLength);
        int type = 1;
        triangle = sierpinskiDivider(triangle, sideLength, type, depth);

        // Print char array into completed triangle
        int currentRowLength = 1;
        int currentIndex = 0;

        for (int row = 0; row < sideLength; row++) {
            // Print leading spaces for alignment
            for (int space = 0; space < sideLength - row - 1; space++) {
                System.out.print(" ");
            }
            // Print characters on the current row
            for (int i = 0; i < currentRowLength; i++) {
                System.out.print(triangle[currentIndex]);
                if (currentIndex < triangle.length - 1) {
                    currentIndex++;
                }
            }
            // Move to the next row
            System.out.println();
            currentRowLength += 2;
        }
    }
    private static char[] sierpinskiDivider(char[] inputTriangle, int sideLength, int type, int depth) {
        if (depth == 0) {
            return inputTriangle;
        }

        // Generate initial coordinate
        int midpointLength = midpoint(sideLength, 0);
        int indexRemoval;

        // 1 = start, 2 = sub top, 3 = sub bottom
        if (type == 1) {
            indexRemoval = arithmeticSumOdd(midpointLength) + 1; // first index
        } else if (type == 2) {
            indexRemoval = arithmeticSumOdd(midpointLength); // top triangle
        } else {
            indexRemoval = arithmeticSumOdd(midpointLength); // bottom triangles
        }

        int amountRemoved = midpointLength * 2 - 1;
        int counter = midpointLength;

        for (int i = 0; i < 2; i++) {
            int tempNum = 2;
            int loopCounter = 0;
            for (int n = indexRemoval; n < indexRemoval + amountRemoved; n++) {
                inputTriangle[n] = ' ';
            }
            for (int j = indexRemoval + i * amountRemoved + (int) Math.pow(2, 3 + i); j < indexRemoval + (i + 2) * amountRemoved + tempNum; j++) {
                inputTriangle[j] = ' ';
                loopCounter++;
                if (loopCounter % 2 == 1) {
                    tempNum *= 3;
                } else {
                    tempNum *= 2;
                }
            }
        }
        // indexRemoval + 0*amountRemoved + 0*(int) Math.pow(2, 3 + i)
        // indexRemoval + (0 + 1)*amountRemoved + 0*j < indexRemoval + 0 * (i + 2) * amountRemoved +
        for (int n = indexRemoval; n < indexRemoval + amountRemoved + 0; n++) {
            inputTriangle[n] = ' ';
        }
        for (int j = indexRemoval + amountRemoved + 4; j < indexRemoval + 2*amountRemoved + 2; j++) {
          inputTriangle[j] = ' '; // 2
        }
        for (int k = indexRemoval + 2*amountRemoved + 8 + 2; k < indexRemoval + 3*amountRemoved + 2 * 3; k++) {
            inputTriangle[k] = ' '; // 3
        }
        for (int l = indexRemoval + 3*amountRemoved + 16 + 2; l < indexRemoval + 4*amountRemoved + 10; l++) {
            inputTriangle[l] = ' '; // 3
            System.out.println(l);
        }
        return inputTriangle;
    };

    /**
     * Generates a Sierpinski triangle pattern as a character array with the given triangle size.
     *
     * @param length The number of char for the Sierpinski triangle. It must be a positive integer.
     * @return A character array representing a Sierpinski triangle pattern with 'n' units for length.
     * @throws IllegalArgumentException if 'n' is not a positive integer.
     */
    private static char[] sierpinskiGenerator(int length) {
        int arrayLength = arithmeticSum(length);
        char[] baseTriangle = new char[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
                baseTriangle[i] = '*';
        }
        System.out.println("Size of array input: " + arrayLength + ", and size of actual:" + baseTriangle.length);
        return baseTriangle;
    };

    /**
     * Computes the sum of the first 'n' positive integers using the arithmetic series formula.
     *
     * @param n The number of terms to include in the arithmetic sum. It must be a non-negative integer.
     * @return The sum of the first 'n' positive integers using the arithmetic series formula.
     * @throws IllegalArgumentException if 'n' is a negative integer.
     */
    private static int arithmeticSum(int n) {
        return n * (n + 1) / 2;
    };

    /**
     * Calculates the sum of odd numbers in an arithmetic sequence up to a given term.
     *
     * This method takes an integer 'n' and returns the sum of the first 'n' odd numbers in an
     * arithmetic sequence. The sequence starts with 1 and increments by 2 for each term.
     *
     * @param n The number of terms in the sequence to consider.
     * @return The sum of the first 'n' odd numbers in the arithmetic sequence.
     * @throws IllegalArgumentException If 'n' is less than 1.
     */
    private static int arithmeticSumOdd(int n) {
        return n * n;
    }

    /**
     * Computes the midpoint between two double values.
     *
     * @param x1 The first double value.
     * @param x2 The second double value.
     * @return The midpoint between 'x1' and 'x2' as a double value.
     */
    private static int midpoint(int x1, int x2) {
        return Math.abs(x1 + x2) / 2;
    };

    public static void main(String[] args) {
        int sideLength = 16;
        int depth = 2;
        drawSierpinski(sideLength, depth);
    }
}
