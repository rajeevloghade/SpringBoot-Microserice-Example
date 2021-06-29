package io.javabrains.moviecatalogservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.resource.MovieControllerResource;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMillisecond", value = "5000") })
	public CatalogItem getCatalogItem(Rating rating) {
		log.debug("Inside MovieInfo service class getCatalogItem method invoked with rating object :{}", rating);
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), "Description", rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		log.debug("Inside MovieInfo service class getFallbackCatalogItem method invoked with rating object :{}",
				rating);
		return new CatalogItem("No movie found", "No Description", rating.getRating());
	}

}
