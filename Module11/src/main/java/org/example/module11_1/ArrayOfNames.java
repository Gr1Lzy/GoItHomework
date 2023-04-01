package org.example.module11_1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayOfNames {

    public static String odd(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
}
