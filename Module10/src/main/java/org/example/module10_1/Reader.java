package org.example.module10_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void read() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/org/example/module10_1/file.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.matches("\\(?[0-9]{3}\\)?-?\\s?[0-9]{3}-[0-9]{4}")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
