package com.solutions.a20211203a;

import java.util.Arrays;
import java.util.List;

public class Soluction {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        Integer bestOption = listOfIntegers.stream().filter(i -> i > 8).findFirst().orElse(listOfIntegers.stream().filter(i -> i < 5).findFirst().orElse(null));

        System.out.println(bestOption);
    }
}
