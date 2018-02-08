package com.zuehlke.rating.omdb;

import com.zuehlke.rating.Rating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class InMemoryRatingAdapter implements RatingAdapter {

    private final Map<String, List<Rating>> ratings = new HashMap<>();

    public InMemoryRatingAdapter() {
        ratings.put("tt0372784", asList(
                new Rating("Internet Movie Database", "8.3/10"),
                new Rating("Rotten Tomatoes", "84%"),
                new Rating("Metacritic", "70/100")
        ));

        ratings.put("tt1637725", asList(
                new Rating("Internet Movie Database", "7.0/10"),
                new Rating("Rotten Tomatoes", "67%"),
                new Rating("Metacritic", "62/100")
        ));

        ratings.put("tt1375666", asList(
                new Rating("Internet Movie Database", "8.8/10"),
                new Rating("Rotten Tomatoes", "86%"),
                new Rating("Metacritic", "74/100")
        ));

        ratings.put("tt0068646", asList(
                new Rating("Internet Movie Database", "9.2/10"),
                new Rating("Rotten Tomatoes", "99%"),
                new Rating("Metacritic", "100/100")
        ));

        ratings.put("tt0468569", asList(
                new Rating("Internet Movie Database", "9.0/10"),
                new Rating("Rotten Tomatoes", "94%"),
                new Rating("Metacritic", "82/100")
        ));

        ratings.put("tt0816692", asList(
                new Rating("Internet Movie Database", "8.6/10"),
                new Rating("Rotten Tomatoes", "71%"),
                new Rating("Metacritic", "74/100")
        ));

        ratings.put("tt1675434", asList(
                new Rating("Internet Movie Database", "8.6/10"),
                new Rating("Rotten Tomatoes", "74%"),
                new Rating("Metacritic", "57/100")
        ));
    }

    @Override
    public List<Rating> getRatings(String imdbId) {
        return ratings.get(imdbId);
    }
}
