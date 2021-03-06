package com.solutions.a20211126a;

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
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = BigInteger.ONE;
        BigInteger aux = BigInteger.ONE;

        while (aux.intValue() <= n) {
            result = result.multiply(aux);
            aux = aux.add(BigInteger.ONE);
        }

        System.out.println(result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = 25;

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
