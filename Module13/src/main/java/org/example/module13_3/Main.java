package org.example.module13_3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println(getOpenTodosForUser(1));
    }

    public static String getOpenTodosForUser(int userId) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/" + userId + "/todos"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Open tasks for user ").append(userId).append(":\n");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            if (!obj.getBoolean("completed")) {
                stringBuilder.append(obj.getString("title")).append(" - false\n");
            }
        }
        return stringBuilder.toString();
    }
}