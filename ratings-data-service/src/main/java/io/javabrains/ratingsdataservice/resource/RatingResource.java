package io.javabrains.ratingsdataservice.resource;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}

	@GetMapping("/user/{userId}")
	public UserRating getAllRating(@PathVariable("userId") String userId) {
		return new UserRating(Arrays.asList(new Rating("AAA", 7), new Rating("BBB", 8), new Rating("CCC", 9)));
	}
}
