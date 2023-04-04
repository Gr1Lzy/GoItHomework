package org.example.module13_2;

import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    private static final String URL_USERS =
            "https://jsonplaceholder.typicode.com/users";
    private static final String URL_POSTS =
            "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws Exception {
        System.out.println(getMaxIdPostByUserID(3));
        fileWriteUserIDAndPostID(46, 10);
    }

    public static String getMaxIdPostByUserID(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_USERS + "/" + id + "/posts"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonParser jsonParser = new JsonParser();
        JsonArray postsArray = jsonParser.parse(response.body()).getAsJsonArray();

        int maxId = 0;
        String bodyWithMaxID = "";

        for (JsonElement postElement : postsArray) {
            JsonObject postObject = postElement.getAsJsonObject();
            int postId = postObject.get("id").getAsInt();
            if (postId > maxId) {
                maxId = postId;
                bodyWithMaxID = postObject.get("body").getAsString();
            }
        }
        return bodyWithMaxID;
    }

    public static void fileWriteUserIDAndPostID(int userID, int postID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_POSTS + "/" + postID + "/comments"))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonArray comments = JsonParser.parseString(response.body()).getAsJsonArray();
        JsonObject jsonObject = null;
        for (JsonElement comment : comments) {
            JsonObject obj = comment.getAsJsonObject();
            if (obj.get("id").getAsInt() == userID) {
                jsonObject = obj;
                break;
            }
        }
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonObject);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(jsonArray);

        FileWriter file = new FileWriter("user-" + userID + "-post-" + postID + "-comments.json");
        file.write(jsonString);
        file.close();
    }
}

