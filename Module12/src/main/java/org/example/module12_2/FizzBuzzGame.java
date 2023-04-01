package org.example.module12_2;

import java.util.Arrays;

public class FizzBuzz {
    int[] array;
    String[] resultArray;
    boolean value = true;
    int index = 0;
    String[] start() {
        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();
        value = false;
        return resultArray;
    }
    public FizzBuzz(int length) {
        array = new int[length];
        resultArray = new String[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (i + 1);
        }
        System.out.println(Arrays.toString(array));
    }
    Thread fizz = new Thread(() -> {
        while (value) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(array[index] % 3 == 0) {
                resultArray[index] = "fizz";
                index++;
            }
        }
    });
    Thread buzz = new Thread(() -> {
        while (value) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
            if(array[index] % 5 == 0) {
                resultArray[index] = "buzz";
                index++;
            }
        }
    });
    Thread fizzbuzz = new Thread(() -> {
        while (value) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(array[index] % 3 == 0 && array[index] % 5 == 0) {
                resultArray[index] = "fizzbuzz";
                index++;
            }
        }
    });
    Thread number = new Thread(() -> {
        while (value) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(array[index] % 3 != 0 && array[index] % 5 != 0) {
                resultArray[index] = String.valueOf(array[index]);
                index++;
            }
        }
    });
}
