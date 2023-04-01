package org.example;

import org.example.module11_1.ArrayOfNames;
import org.example.module11_2.ArrayOfUpperCase;
import org.example.module11_3.ArrayOfSortedInteger;
import org.example.module11_4.MathRandom;
import org.example.module11_5.Zip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Peter", "John", "Alex");
        String result = ArrayOfNames.odd(names);
        System.out.println(result);
        System.out.println("---------------------------------------");
        System.out.println(ArrayOfUpperCase.upperRevAlphabet(names));
        System.out.println("---------------------------------------");
        List<String> numbers = Arrays.asList("1, 2, 0", "4, 5");
        System.out.println(ArrayOfSortedInteger.sortNumbers(numbers));
        System.out.println("---------------------------------------");
        MathRandom.generate(2).limit(10).forEach(System.out::println);
        System.out.println("---------------------------------------");
        Stream<Integer> first = Stream.of(1, 3, 4, 5, 6, 7);
        Stream<Integer> second = Stream.of(5, 4, 2, 6, 7);
        Zip.zip(first, second).forEach(System.out::print);
    }
}