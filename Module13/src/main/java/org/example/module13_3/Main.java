package org.example.module13_3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users/";

    public static void main(String[] args) throws Exception {
        System.out.println(getOpenTodosForUser(1));
    }

    public static String getOpenTodosForUser(int userId) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/" + userId + "/todos"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray tasks = new JSONArray(response.body());
        List<JSONObject> openTasks = new ArrayList<>();
        for (int i = 0; i < tasks.length(); i++) {
            JSONObject task = tasks.getJSONObject(i);
            if (!task.getBoolean("completed")) {
                openTasks.add(task);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(openTasks);
    }
}