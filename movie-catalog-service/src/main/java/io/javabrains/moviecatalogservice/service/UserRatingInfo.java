package io.javabrains.moviecatalogservice.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.resource.MovieControllerResource;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;

	Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

	@HystrixCommand(fallbackMethod = "getFallbackUserRating"/*
															 * , commandProperties = {
															 * 
															 * @HystrixProperty(name =
															 * "circuitBreaker.requestVolumeThreshold", value = "5"),
															 * 
															 * @HystrixProperty(name =
															 * "circuitBreaker.errorThresholdPercentage", value = "50"),
															 * 
															 * @HystrixProperty(name =
															 * "circuitBreaker.sleepWindowInMillisecond", value =
															 * "5000") }
															 */)
	public UserRating getUserRating(String userId) {
		log.debug("Inside UserRatingInfo service class getUserRating method invoked with userId :{}", userId);
		return restTemplate.getForObject("http://ratings-data-service/ratingdata/user/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {
		log.debug("Inside UserRatingInfo service class getFallbackUserRating method invoked with userId :{}", userId);
		UserRating userRating = new UserRating();
		userRating.setUserRatings(Arrays.asList(new Rating("No movie found", 0)));
		return userRating;
	}
}
