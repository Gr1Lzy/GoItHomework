package org.example.module11_4;

import java.util.stream.Stream;

public class MathRandom {
    private static final long a = 25_214_903_917L;
    private static final long c = 11;
    private static final long m = (long) Math.pow(2, 48);



    public static Stream<Long> generate(long seed) {
        return Stream.iterate(seed, n -> (a * n + c) % m);

    }
}
