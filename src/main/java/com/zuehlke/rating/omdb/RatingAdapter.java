package com.zuehlke.rating.omdb;

import com.zuehlke.rating.Rating;

import java.util.List;

public interface RatingAdapter {
    List<Rating> getRatings(String imdbId);
}
