package org.example.module12_2;

import java.util.Arrays;

public class FizzBuzzGame {
    int[] array;
    String[] resultArray;

    public FizzBuzzGame(int length) {
        array = new int[length];
        resultArray = new String[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (i + 1);
        }
        System.out.println(Arrays.toString(array));
    }

    String[] launch() {
        Thread fizzbuzz = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int index = 0; index < array.length; index++) {
                    if(array[index] % 3 == 0 && array[index] % 5 == 0) {
                        resultArray[index] = "fizzbuzz";
                    }
                }
            }
        });
        Thread fizz = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            while (!Thread.currentThread().isInterrupted()) {
                for (int index = 0; index < array.length; index++) {
                    if(array[index] % 3 == 0 && resultArray[index] == null) {
                        resultArray[index] = "fizz";
                    }
                }
            }
        });
        Thread buzz = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int index = 0; index < array.length; index++) {
                    if(array[index] % 5 == 0 && resultArray[index] == null) {
                        resultArray[index] = "buzz";
                    }
                }
            }
        });

        Thread number = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int index = 0; index < array.length; index++) {
                    if(array[index] % 3 != 0 && array[index] % 5 != 0) {
                        resultArray[index] = String.valueOf(array[index]);
                    }
                }
            }
        });

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();

        while (!Thread.currentThread().isInterrupted()) {
            int count = 0;
            for (String s : resultArray) {
                if (s != null) {
                    count++;
                }
            }
            if (count == resultArray.length) {
                break;
            }
        }

        fizz.interrupt();
        buzz.interrupt();
        fizzbuzz.interrupt();
        number.interrupt();

        return resultArray;
    }
}
