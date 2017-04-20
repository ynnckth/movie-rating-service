package com.zuehlke.rating.omdb;

import com.zuehlke.rating.Rating;
import com.zuehlke.rating.omdb.OmdbAdapter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class OmdbAdapterIntegrationTest {
    @Test
    public void getRatings() throws Exception {
        OmdbAdapter omdbAdapter = new OmdbAdapter("http://www.omdbapi.com/");

        List<Rating> ratings = omdbAdapter.getRatings("tt0096895");

        assertThat(ratings, hasSize(3));
        assertThat(ratings, hasItem(new Rating("Internet Movie Database", "7.6/10")));
    }

}