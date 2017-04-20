package com.zuehlke.rating.movieservice;

import com.zuehlke.rating.rest.RestClientFactory;

import java.util.List;

public class MovieAdapter {

    private final MovieApiClient movieApiClient;

    public MovieAdapter(String url) {
        movieApiClient = RestClientFactory.createClient(url, MovieApiClient.class);
    }

    public List<Movie> getMovies() {
        return movieApiClient.getMovies();
    }

}
