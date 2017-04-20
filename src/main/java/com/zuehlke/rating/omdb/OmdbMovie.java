package com.zuehlke.rating.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OmdbMovie {

    private final List<OmdbRating> ratings;

    @JsonCreator
    public OmdbMovie(@JsonProperty("Ratings") List<OmdbRating> ratings) {
        this.ratings = ratings;
    }

    public List<OmdbRating> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return "OmdbMovie{" +
                "ratings=" + ratings +
                '}';
    }
}
