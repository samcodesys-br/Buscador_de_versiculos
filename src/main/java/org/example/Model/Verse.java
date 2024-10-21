package org.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Verse {
    @JsonProperty("book")
    public Book book;
    @JsonProperty("chapter")
    public int chapter;
    @JsonProperty("number")
    public int number;
    @JsonProperty("text")
    public String text;

    @Override
    public String toString() {
        return String.format("""
                %s %s:%s (%s)
                "%s"
                """,book.name,chapter,number,book.testament,text);
    }
}
