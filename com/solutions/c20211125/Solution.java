package com.solutions.c20211125;

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
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER. The function accepts
     * INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int movement = 0;
        int start = c.size() > 2 && c.get(2) == 0 ? 2 : 1;

        for (int i = start; i < c.size(); i++) {
            movement++;
            if (i+1 < c.size() && c.get(i+1) == 0) {
                i++;
            }
        }

        return movement == 0 ? 1 : movement;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int result = Result.jumpingOnClouds(Arrays.asList(0, 0));

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}