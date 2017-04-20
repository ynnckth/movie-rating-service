package com.zuehlke.rating.movieservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private final long id;
    private final String imdbId;

    @JsonCreator
    public Movie(@JsonProperty("id") long id,
                 @JsonProperty("imdbId") String imdbId) {
        this.id = id;
        this.imdbId = imdbId;
    }

    public long getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id == movie.id && imdbId.equals(movie.imdbId);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + imdbId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }
}
