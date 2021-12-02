package com.solutions.a20211201;

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
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(Integer[][] matrix) {
        // Write your code here
        int[] regions = new int[Math.max(matrix.length, matrix[0].length)];
        boolean hasRegions = false;
        int amountRegions = 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    hasRegions = true;
                    int regionId = getRegionId(matrix, i, j, amountRegions);

                    if (regionId > 1) {
                        regions[regionId] += 1;
                    }
                }
            }
        }
        return hasRegions ? Math.max(2, Arrays.stream(regions).max().orElse(1)) - 1 : 0;
    }

    private static int getRegionId(Integer[][] matrix, int i, int j, int amountRegions) {
        int maxPartner = 0;
        // above row
        if (matrix[Math.max(0, i - 1)][Math.max(0, j - 1)] > maxPartner) {
            maxPartner = matrix[Math.max(0, i - 1)][Math.max(0, j - 1)];
        }
        if (matrix[Math.max(0, i - 1)][Math.max(0, j)] > maxPartner) {
            maxPartner = matrix[Math.max(0, i - 1)][Math.max(0, j)];
        }
        if (matrix[Math.max(0, i - 1)][Math.min(matrix[0].length - 1, j + 1)] > maxPartner) {
            maxPartner = matrix[Math.max(0, i - 1)][Math.min(matrix[0].length - 1, j + 1)];
        }
        // same row
        if (matrix[Math.max(0, i)][Math.max(0, j - 1)] > maxPartner) {
            maxPartner = matrix[Math.max(0, i)][Math.max(0, j - 1)];
        }
        if (matrix[Math.max(0, i)][Math.min(matrix[0].length - 1, j + 1)] > maxPartner) {
            maxPartner = matrix[Math.max(0, i)][Math.min(matrix[0].length - 1, j + 1)];
        }
        // bellow row
        if (matrix[Math.min(matrix.length - 1, i + 1)][Math.max(0, j - 1)] > maxPartner) {
            maxPartner = matrix[Math.min(matrix.length - 1, i + 1)][Math.max(0, j - 1)];
        }
        if (matrix[Math.min(matrix.length - 1, i + 1)][Math.max(0, j)] > maxPartner) {
            maxPartner = matrix[Math.min(matrix.length - 1, i + 1)][Math.max(0, j)];
        }
        if (matrix[Math.min(matrix.length - 1, i + 1)][Math.min(matrix[0].length - 1, j + 1)] > maxPartner) {
            maxPartner = matrix[Math.min(matrix.length - 1, i + 1)][Math.min(matrix[0].length - 1, j + 1)];
        }

        if (maxPartner == 1) {
            amountRegions++;
            matrix[i][j] = amountRegions;
        }

        return matrix[i][j];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        Integer[][] matrix = new Integer[n][m];

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix[i] = 
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()).toArray(new Integer[m]);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
