package org.example.module10_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {
    public static void read() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/org/example/module10_3/words.txt"))) {
            String line;
            Map<String, Integer> wordCounter = new HashMap<>();
            StringBuilder words = new StringBuilder("");
            while ((line = bufferedReader.readLine()) != null) {
                words.append(line).append(" ");
            }
            String[] array = words.toString().trim().split(" ");

            for (String word : array) {
                if(!wordCounter.containsKey(word)) {
                    wordCounter.put(word, 1);
                } else {
                    int count = wordCounter.get(word);
                    wordCounter.put(word, count + 1);
                }
            }
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCounter.entrySet());
            Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            });

            for (Map.Entry<String, Integer> entry : entries) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
}
