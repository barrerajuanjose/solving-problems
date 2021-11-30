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

                Map<String, List<Integer>> healthIndex = new HashMap<>();
                for (int i = first; i <= last; i++) {
                    String geneKey = genes.get(i);
                    List<Integer> values = healthIndex.get(geneKey);
                    if (values == null) {
                        values = new ArrayList<>();
                    }
                    values.add(health.get(i));
                    healthIndex.put(geneKey, values);
                }

                int healthDNA = 0;

                for (int i = 0; i < d.length(); i++) {
                    for (int j = d.length(); i <= j; j--) {
                        List<Integer> subHealth = healthIndex.get(d.substring(i, j));

                        if (subHealth != null) {
                            healthDNA += subHealth.stream().collect(Collectors.summingInt(l -> l));
                            break;
                        }

                    }
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
