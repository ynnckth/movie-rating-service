package com.zuehlke.rating.omdb;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuehlke.rating.Rating;
import feign.Logger;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.slf4j.Slf4jLogger;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OmdbAdapter {

    private final OmdbApiClient omdbApiClient;

    public OmdbAdapter(String url) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        omdbApiClient = HystrixFeign.builder()
                .decoder(new JacksonDecoder(mapper))
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(OmdbApiClient.class, url);
    }

    public List<Rating> getRatings(String imdbId) {
        OmdbMovie omdbMovie = omdbApiClient.getMovieByImdbId(imdbId);
        List<OmdbRating> ratings = omdbMovie.getRatings();
        return ratings.stream()
                .map(Rating::from)
                .collect(toList());
    }
}
