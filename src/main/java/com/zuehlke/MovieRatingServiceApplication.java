package com.zuehlke;

import com.zuehlke.rating.movieservice.MovieAdapter;
import com.zuehlke.rating.omdb.InMemoryRatingAdapter;
import com.zuehlke.rating.omdb.RatingAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingServiceApplication.class, args);
	}

	@Bean
	public MovieAdapter movieAdapter(@Value("${endpoint.movie-service}") String url) {
		return new MovieAdapter(url);
	}

	@Bean
	public RatingAdapter ratingAdapter(@Value("${endpoint.omdbapi}") String url) {
		return new InMemoryRatingAdapter();
	}
}
