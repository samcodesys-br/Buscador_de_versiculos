package org.example.Adapter;

import com.fasterxml.jackson.databind.*;
import org.example.Model.Verse;

import java.io.IOException;
import java.net.http.HttpResponse;

public class JsonToVerseAdapter {
    public Verse verse;
    public ObjectMapper objectMapper;

    public JsonToVerseAdapter(){
        this.verse=new Verse();
        this.objectMapper=new ObjectMapper();
    }


    public Verse convertToVerse(HttpResponse response) throws IOException {
        verse=objectMapper.readValue(response.body().toString(),Verse.class);
        System.out.println(verse.text);
        return verse;
    }
}
