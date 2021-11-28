package com.solutions.a20211128a;

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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        Map<String, Integer> teams = new HashMap<>();
        Integer maxKnows = 0;
        for (int i = 0; i < topic.size(); i++) {
            for (int j = i; j < topic.size(); j++) {
                Integer teamKnow = evaluateKnowsTopics(topic.get(i), topic.get(j));
                if (teamKnow > maxKnows) {
                    maxKnows = teamKnow;
                }
                teams.put(i + "-" + j, teamKnow);
            }
        }

        final Integer finalMaxKonws = maxKnows; 
        List<Integer> result = new ArrayList<>();
        result.add(0, maxKnows);
        result.add(1, teams.values().stream().filter(knows -> knows.equals(finalMaxKonws)).collect(Collectors.counting()).intValue());

        return result;
    }

    private static Integer evaluateKnowsTopics(String person1, String person2) {
        Integer teamKnow = 0;
        char[] knows1 = person1.toCharArray();
        char[] knows2 = person2.toCharArray();

        for (int i = 0; i < knows2.length; i++) {
            if (knows1[i] == '1' || knows2[i] == '1') {
                teamKnow++;
            }
        }

        return teamKnow;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
