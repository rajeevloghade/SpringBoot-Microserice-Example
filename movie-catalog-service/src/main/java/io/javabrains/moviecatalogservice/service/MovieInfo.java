package io.javabrains.moviecatalogservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.resource.MovieControllerResource;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		log.debug("Inside MovieInfo service class getCatalogItem method invoked with rating object :{}", rating);
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), "Description", rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		log.debug("Inside MovieInfo service class getFallbackCatalogItem method invoked with rating object :{}", rating);
		return new CatalogItem("No movie found", "No Description", rating.getRating());
	}

}
