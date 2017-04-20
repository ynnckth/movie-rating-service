package com.zuehlke.rating.movieservice;

import feign.RequestLine;

import java.util.List;

public interface MovieApiClient {
    @RequestLine("GET /api/v1/movies")
    List<Movie> getMovies();
}
