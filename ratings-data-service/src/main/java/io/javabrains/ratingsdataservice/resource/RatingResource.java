package io.javabrains.ratingsdataservice.resource;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

	@Value("${server.port}")
	private String portNumber;

	Logger log = LoggerFactory.getLogger(RatingResource.class);

	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		log.trace("Inside RatingResource class getRating invoked with movieId : {}", movieId);
		return new Rating(movieId, 5, portNumber);
	}

	@GetMapping("/user/{userId}")
	public UserRating getAllRating(@PathVariable("userId") String userId) {
		log.trace("Inside RatingResource class getAllRating invoked with userId : {}", userId);
		return new UserRating(Arrays.asList(new Rating("AAA", 7, portNumber), new Rating("BBB", 8, portNumber),
				new Rating("CCC", 9, portNumber)));
	}
}
