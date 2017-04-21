package com.zuehlke.rating;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/")
@Controller
public class RatingController {

    private final RatingService ratingService;
    private boolean awkward = false;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratings/{id}")
    @ResponseBody
    public List<Rating> getRatingsById(@PathVariable("id") long id) {
        if (awkward) {
            sleep();
        }

        return ratingService.getRatingsById(id);
    }

    private void sleep() {
        try {
            Thread.sleep(generateRandomNumber(1, 10) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long generateRandomNumber(long lower, long upper) {
        return lower + (long) (Math.random() * (upper - lower));
    }

    @PostMapping("/admin/awkward")
    @ResponseBody
    public boolean flipAwkward() {
        awkward = !awkward;
        return awkward;
    }

}
