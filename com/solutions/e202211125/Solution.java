package com.solutions.e202211125;

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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER n 2. INTEGER k 3. INTEGER r_q 4. INTEGER c_q 5.
     * 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int diff_q = Math.abs(r_q - c_q);
        int amount_diagonals = r_q == 1 && c_q == 1 || r_q == 1 && c_q == n || r_q == n && c_q == 1 || r_q == n && c_q == n ? 1 : 2;
        int blocksToAttack = (n - 1) + (n - 1) + ((n - 1 - diff_q) * amount_diagonals);

        for (List<Integer> obstacle : obstacles) {
            int r_o = obstacle.get(0);
            int c_o = obstacle.get(1);
            if (canAttack(r_o, c_o, r_q, c_q)) {
                if (r_o == r_q) {
                    if (c_q > c_o) {
                        blocksToAttack = blocksToAttack - c_o;
                    } else {
                        blocksToAttack = blocksToAttack - (n - c_o + 1);
                    }
                }
                if (c_o == c_q) {
                    if (r_q > r_o) {
                        blocksToAttack = blocksToAttack - r_o;
                    } else {
                        blocksToAttack = blocksToAttack - (n - r_o + 1);
                    }
                }
            }
        }

        return blocksToAttack;
    }

    public static boolean canAttack(int r, int c, int r_q, int c_q) {
        if (r == r_q && c == c_q) return false;

        if (r == r_q) return true;
        if (c == c_q) return true;

        if (r_q - c_q == r - c) return true;
        if (c_q + r_q == c + r) return true;

        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
