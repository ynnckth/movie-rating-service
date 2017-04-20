package com.zuehlke.rating;

import com.zuehlke.rating.movieservice.Movie;
import com.zuehlke.rating.movieservice.MovieAdapter;
import com.zuehlke.rating.omdb.OmdbAdapter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class RatingService {

    private final MovieAdapter movieAdapter;
    private final OmdbAdapter omdbAdapter;

    public RatingService(MovieAdapter movieAdapter, OmdbAdapter omdbAdapter) {
        this.movieAdapter = movieAdapter;
        this.omdbAdapter = omdbAdapter;
    }

    List<Rating> getRatingsById(long id) {
        Optional<Movie> movie = findMovieById(id);

        return movie.map(m -> omdbAdapter.getRatings(m.getImdbId()))
                .orElse(Collections.emptyList());
    }

    private Optional<Movie> findMovieById(long id) {
        List<Movie> movies = movieAdapter.getMovies();

        return movies.stream().filter(m -> m.getId() == id).findFirst();
    }
}
