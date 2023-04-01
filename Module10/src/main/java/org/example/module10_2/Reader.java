package org.example.module10_2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/module10_2/fileInput.txt"));

            String line = reader.readLine();
            String[] create = line.split(" ");
            List<JSONObject> list = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                String name = values[0];
                int age = Integer.parseInt(values[1]);

                JSONObject object = new JSONObject();
                object.put(create[0], name);
                object.put(create[1], age);
                list.add(object);
            }
            reader.close();

            FileWriter writer = new FileWriter("src/main/java/org/example/module10_2/fileOutput.json");
            JSONArray jsonArray = new JSONArray(list);
            writer.write(jsonArray.toString(4));
            writer.close();

            System.out.println("Преобразование файла в JSON выполнено успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}