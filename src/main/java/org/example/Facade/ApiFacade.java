package org.example.Facade;

import org.example.Adapter.JsonToVerseAdapter;
import org.example.Factory.ApiRequestFactory;
import org.example.Model.Verse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiFacade {
    private final HttpClient client;
    public JsonToVerseAdapter jsonToVerseAdapter;
    public ApiRequestFactory apiRequestFactory;
    public ApiFacade() {
        this.client = HttpClient.newHttpClient();
        this.apiRequestFactory=new ApiRequestFactory();
        this.jsonToVerseAdapter=new JsonToVerseAdapter();
    }

    public void buscarVersiculos(String word) throws IOException, InterruptedException {
        String body="{ \"version\" : \"nvi\", \"search\" : \""+word+"\" }";
        String url="https://www.abibliadigital.com.br/api/verses/search";
        HttpRequest request=apiRequestFactory.buildRequest(url,body);
        HttpResponse response=client.send(request, HttpResponse.BodyHandlers.ofString());
        Map<String, Object> verseList=jsonToVerseAdapter.convertToVerseList(response);
        System.out.println(verseList.toString());
    }
}
