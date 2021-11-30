package com.solutions.a20211129b;

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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int s = Integer.parseInt(bufferedReader.readLine().trim());
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int p = 0; p < s; p++) {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int first = Integer.parseInt(firstMultipleInput[0]);

                int last = Integer.parseInt(firstMultipleInput[1]);

                String d = firstMultipleInput[2];

                int healthDNA = 0;

                for (int i = first; i <= last; i++) {
                    String gen = genes.get(i);
                    int index = d.indexOf(gen);
                    int repeted = 0;

                    while (index >= 0) {
                        repeted++;
                        index = d.indexOf(gen, index + 1);
                    }
                    healthDNA += health.get(i) * repeted;
                }

                if (healthDNA < min) {
                    min = healthDNA;
                }

                if (healthDNA > max) {
                    max = healthDNA;
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println(min + " " + max);

        bufferedReader.close();
    }
}
