package com.zuehlke.rating;

import com.zuehlke.rating.movieservice.Movie;
import com.zuehlke.rating.movieservice.MovieAdapter;
import com.zuehlke.rating.omdb.RatingAdapter;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatingControllerComponentTest {

    @MockBean
    private MovieAdapter movieAdapter;

    @MockBean
    private RatingAdapter ratingAdapter;

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        Movie movie = new Movie(1, "imdbId1");
        Mockito.when(movieAdapter.getMovies()).thenReturn(singletonList(movie));

        Rating rating = new Rating("Internet Movie Database", "8.3/10");
        Mockito.when(ratingAdapter.getRatings(any())).thenReturn(singletonList(rating));

        RestAssured.port = port;
    }

    @Test
    public void getRatingsById() throws Exception {
        when().
            get("/api/v1/ratings/1").
        then().
            statusCode(200).
            body("[0].source", equalTo("Internet Movie Database")).
            body("[0].value", equalTo("8.3/10"));
    }
}