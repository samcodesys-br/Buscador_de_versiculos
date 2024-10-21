package org.example.Adapter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Map;

public class JsonToVerseAdapter {
    public ObjectMapper objectMapper;

    public JsonToVerseAdapter(){
        this.objectMapper=new ObjectMapper();
    }


    public Map<String, Object> convertToVerseList(HttpResponse response) throws IOException {
        TypeReference<Map<String,Object>> typeRef=new TypeReference<Map<String,Object>>() {};
        Map<String,Object> verseList=objectMapper.readValue(response.body().toString(),typeRef);
        System.out.println(verseList.get("verses"));
        return verseList;
    }
}
