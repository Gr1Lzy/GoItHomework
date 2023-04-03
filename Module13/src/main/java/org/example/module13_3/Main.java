package org.example.module13_3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        int userId = 1;
        String apiUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";
        JSONArray tasks = new JSONArray(sendGet(apiUrl));

        System.out.println("Open tasks:");
        for (int i = 0; i < tasks.length(); i++) {
            JSONObject task = tasks.getJSONObject(i);
            if (!task.getBoolean("completed")) {
                System.out.println(task.getString("title"));
            }
        }
    }

    private static String sendGet(String url) {
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response.toString();
    }
}

