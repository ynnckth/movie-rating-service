package com.zuehlke.rating.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OmdbRating {

    private final String source;
    private final String value;

    @JsonCreator
    public OmdbRating(@JsonProperty("Source") String source,
                      @JsonProperty("Value") String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "OmdbRating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
