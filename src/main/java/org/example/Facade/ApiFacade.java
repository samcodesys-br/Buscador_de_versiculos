package org.example.Facade;

import org.example.Adapter.JsonToVerseAdapter;
import org.example.Factory.ApiRequestFactory;
import org.example.Model.Verse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiFacade {
    private final HttpClient client;
    public JsonToVerseAdapter jsonToVerseAdapter;
    public ApiRequestFactory apiRequestFactory;
    public ApiFacade() {
        this.client = HttpClient.newHttpClient();
        this.apiRequestFactory=new ApiRequestFactory();
        this.jsonToVerseAdapter=new JsonToVerseAdapter();
    }

    public Verse buscarVersiculos(String url, String word) throws IOException, InterruptedException {
        String body="{ \"version\" : \"nvi\", \"search\" : \""+word+"\" }";
        HttpRequest request=apiRequestFactory.buildRequest(url,body);
        HttpResponse response=client.send(request, HttpResponse.BodyHandlers.ofString());
        return jsonToVerseAdapter.convertToVerse(response);
    }
}
