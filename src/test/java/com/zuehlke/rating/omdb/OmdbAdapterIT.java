package com.zuehlke.rating.omdb;

import com.zuehlke.rating.Rating;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class OmdbAdapterIT {

    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
    }

    @Test
    public void getRatings() throws Exception {
        OmdbAdapter omdbAdapter = new OmdbAdapter("http://www.omdbapi.com/");

        List<Rating> ratings = omdbAdapter.getRatings("tt0096895");

        assertThat(ratings, hasSize(3));
        assertThat(ratings, hasItem(new Rating("Internet Movie Database", "7.6/10")));
    }

}