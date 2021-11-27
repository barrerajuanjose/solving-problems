package com.solutions.a20211126b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {
    public static int solve(int A, int[][] B) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            List<Integer> neighbours = graph.get(B[i][0]);
            if (neighbours == null) {
                neighbours = new ArrayList<>();
            }

            neighbours.add(B[i][1]);

            graph.put(B[i][0], neighbours);
        }

        boolean[] visited = new boolean[A+1];
        int current;

        Queue<Integer> queue = new ArrayBlockingQueue<>();
        queue.add(B[0][0]);

        while (!queue.isEmpty()) {
            current = queue.poll();
            visited[current] = true;

            if (current == A) {
                return 1;
            }

            if (graph.get(current) != null) {
                for(Integer neighbour : graph.get(current)) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] B = new int[3][2];
        B[0][0] = 1;
        B[0][1] = 2;
        B[1][0] = 2;
        B[1][1] = 3;
        B[2][0] = 4;
        B[2][1] = 3;

        solve(4, B);
    }
}