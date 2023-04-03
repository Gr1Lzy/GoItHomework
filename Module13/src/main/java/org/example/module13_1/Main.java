package org.example.module13_1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    private static final String MAIN_URL =
            "https://jsonplaceholder.typicode.com/users";

    private static final String USER = "{"
            + "\"name\": \"Andrey Kolomoets\","
            + "\"username\": \"gr1lzy\","
            + "\"email\": \"kolomoets@example.com\""
            + "}";

    public static void main(String[] args) throws Exception {
        System.out.println(getAllUsers(MAIN_URL)
                + "\n-------------------------------------------------------");
        System.out.println("User added: \n" + createUser()
                + "\n-------------------------------------------------------");
        System.out.println("User updated: \n" + updateUser(1)
                + "\n-------------------------------------------------------");
        System.out.println("DELETED code: " + deleteUser(1)
                + "\n-------------------------------------------------------");
        System.out.println("User by id: " + getUserByID(2)
                + "\n-------------------------------------------------------");
        System.out.println("User by username: " + getUserByUsername("Maxime_Nienow")
                + "\n-------------------------------------------------------");
    }

    public static String createUser() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(USER))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String updateUser(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(USER))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static int deleteUser(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_URL + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }

    public static String getAllUsers(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getUserByID(int id) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_URL + "/" + id))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String getUserByUsername(String username) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_URL + "?username=" + username))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}