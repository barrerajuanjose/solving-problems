package com.solutions.a202211125d;

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
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER. The function accepts
     * INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> group = new HashMap<>();
        for (Integer number : arr) {
            if (!group.containsKey(number)) {
                group.put(number, 0);
            }

            group.put(number, group.get(number) + 1);
        }

        return arr.size() - group.values().stream().mapToInt(v -> v).max().orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Result.equalizeArray(Arrays.asList(1, 2, 3, 4, 4, 5));

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
