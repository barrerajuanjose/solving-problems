package com.solutions.a20211130a;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     * 1. 2D_INTEGER_ARRAY matrix
     * 2. INTEGER r
     */

    public static void matrixRotation(int[][] matrix, int r) {
        // Write your code here
        /*
         * r <= matrix.length() && r <= matrix[0].length()
         * -> if (j <= matrix[0].length()/2)
         * -> i = i + r
         * else
         * -> i = i - r
         * -> if (i <= matrix.length()/2)
         * -> j = j - r
         * else
         * -> j = j + r
         * i == 0 || j == 0 || i == matrix.length() || j == matrix[0].length()
         * ->
         * 
         * i == 1 || j == 1 || i == matrix.length() - 1 || j == matrix[0].length() - 1
         */
        int rows = matrix.length;
        int columns = matrix[0].length;
        int fullMovements = rows * columns;
        int movements = r - (r / fullMovements) * fullMovements;
        Integer[][] rotatedMatrix = new Integer[rows][columns];
        int iAux, jAux;
        
        for (int m = 0; m < movements; m++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    iAux = i;
                    jAux = j;
                    if (i + 1 < rows - j) {
                        iAux = i + 1;
                    } else if (j + 1 < columns - i) {
                        jAux = j + 1;
                    } else if (i - 1 >= j) {
                        iAux = i - 1;
                    } else if (j - 1 >= i) {
                        jAux = j - 1;
                    }

                    rotatedMatrix[iAux][jAux] = matrix[i][j];
                }
            }    
        }
        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (movements <= columns / 2) {
                    iAux = i + r;
                } else {
                    iAux = i - r;
                }
                if (movements <= rows / 2) {
                    jAux = j + r;
                } else {
                    jAux = j - r;
                }

                rotatedMatrix[iAux][jAux] = matrix[i][j];
            }
        }*/

        for (int i = 0; i < rotatedMatrix.length; i++) {
            StringBuffer line = new StringBuffer();
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                line.append(rotatedMatrix[i][j] + " ");
            }
            System.out.println(line.deleteCharAt(line.length() - 1));
        }
    }

}

public class Solution {
    /*public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int r = 1;
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
