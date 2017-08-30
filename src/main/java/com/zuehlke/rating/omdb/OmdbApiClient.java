package com.zuehlke.rating.omdb;

import feign.Param;
import feign.RequestLine;

public interface OmdbApiClient {
    @RequestLine("GET /?i={imdbId}&apikey=53f5b894")
    OmdbMovie getMovieByImdbId(@Param("imdbId") String imdbId);
}
