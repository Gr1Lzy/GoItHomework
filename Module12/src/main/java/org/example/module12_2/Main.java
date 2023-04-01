package org.example.module12_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(40);
        System.out.println(Arrays.toString(fizzBuzzGame.launch()));
    }
}
