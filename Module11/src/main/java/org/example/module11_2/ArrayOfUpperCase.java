package org.example.module11_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayOfUpperCase {
    public static String upperRevAlphabet(List<String> array) {
        return array.stream().sorted(Comparator.reverseOrder()).map(String::toUpperCase).collect(Collectors.joining(", "));
    }
}
