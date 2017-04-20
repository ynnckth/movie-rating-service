package com.zuehlke.rating;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/api/v1/")
@Controller
public class RatingController {

    @RequestMapping(value = "/ratings/{id}", method = GET)
    @ResponseBody
    public List<Rating> getRatings() {
        return asList(
                new Rating("Internet Movie Database", "8.3/10"),
                new Rating("Rotten Tomatoes", "84%")
        );
    }
}
