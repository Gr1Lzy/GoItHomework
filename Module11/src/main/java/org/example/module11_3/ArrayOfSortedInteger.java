package org.example.module11_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayOfSortedInteger {
    public static List<Integer> sortNumbers(List<String> array) {

        return array.stream()
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
    }
}
