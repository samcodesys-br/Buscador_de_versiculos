package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    @JsonProperty("name")
    public String name;
    @JsonProperty("testament")
    public String testament;
}
