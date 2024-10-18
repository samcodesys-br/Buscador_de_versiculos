package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            System.out.println("Busca de versículos: ");
            System.out.println("> ");

            String word= input.nextLine().toLowerCase();

            String url="https://www.abibliadigital.com.br/api/verses/search";

            HttpClient client=HttpClient.newHttpClient();
            HttpRequest request= HttpRequest
                    .newBuilder()
                    .header("version","nvi")
                    .header("search",word)
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();


            HttpResponse response=client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}