package com.zuehlke.rating.omdb;

import com.zuehlke.rating.Rating;
import com.zuehlke.rating.rest.RestClientFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OmdbAdapter implements RatingAdapter {

    private final OmdbApiClient omdbApiClient;

    public OmdbAdapter(String url) {
        omdbApiClient = RestClientFactory.createClient(url, OmdbApiClient.class);
    }

    @Override
    public List<Rating> getRatings(String imdbId) {
        OmdbMovie omdbMovie = omdbApiClient.getMovieByImdbId(imdbId);
        List<OmdbRating> ratings = omdbMovie.getRatings();
        return ratings.stream()
                .map(Rating::from)
                .collect(toList());
    }
}
