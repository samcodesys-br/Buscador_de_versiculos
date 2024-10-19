package org.example.Singleton;

import java.net.http.HttpClient;

public class HttpClientSingleton {
    public HttpClient instance;

    public HttpClientSingleton(){}

    public HttpClient getInstance() {
        if (instance==null){
            this.instance= HttpClient.newHttpClient();
        }
        return instance;
    }
}
