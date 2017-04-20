package com.zuehlke.rating.movieservice;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class MovieAdapterIntegrationTest {

    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
    }

    @Test
    public void getMovies() throws Exception {
        MovieAdapter movieAdapter = new MovieAdapter("https://movie-service.herokuapp.com/");

        List<Movie> movies = movieAdapter.getMovies();

        assertThat(movies, hasSize(7));
        assertThat(movies, hasItem(new Movie(1, "tt0372784")));

    }
}