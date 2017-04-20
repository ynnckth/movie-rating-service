package com.zuehlke.rating.omdb;

import feign.Param;
import feign.RequestLine;

public interface OmdbApiClient {
    @RequestLine("GET /?i={imdbId}")
    OmdbMovie getMovieByImdbId(@Param("imdbId") String imdbId);
}
