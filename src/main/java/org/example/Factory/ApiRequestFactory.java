package org.example.Factory;

import java.net.URI;
import java.net.http.HttpRequest;

public class ApiRequestFactory {
    public HttpRequest buildRequest(String url,String body){
        return HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }
}
