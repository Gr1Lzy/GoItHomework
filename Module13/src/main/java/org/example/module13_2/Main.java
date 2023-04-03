package org.example.module13_2;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        int userId = 1;
        String apiUrl = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        JSONArray posts = new JSONArray(sendGet(apiUrl));
        JSONObject lastPost = posts.getJSONObject(posts.length() - 1);
        int postId = lastPost.getInt("id");

        apiUrl = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";
        JSONArray comments = new JSONArray(sendGet(apiUrl));

        for (int i = 0; i < comments.length(); i++) {
            JSONObject comment = comments.getJSONObject(i);
            System.out.println(comment.getString("name") + ": " + comment.getString("body"));
        }

        String fileName = "user-" + userId + "-post-" + postId + "-comments.json";
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(comments.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return response.toString();
    }
}