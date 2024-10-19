package org.example.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verse {
    @JsonProperty("book")
    public String book;
    @JsonProperty("chapter")
    public int chapter;
    @JsonProperty("number")
    public int number;
    @JsonProperty("text")
    public String text;
}
