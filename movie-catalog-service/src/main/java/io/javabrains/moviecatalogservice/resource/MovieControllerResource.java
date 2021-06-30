package io.javabrains.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;
import io.javabrains.moviecatalogservice.service.MovieInfo;
import io.javabrains.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieControllerResource {

	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MovieInfo movieInfo;

	@Autowired
	private UserRatingInfo userRatingInfo;

	@Autowired
	private WebClient.Builder webClientBuilder;

	Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

//	@GetMapping("/{userId}")
//	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//		return Collections.singletonList(new CatalogItem("Transformers", "Test", 4));
//	}

	/**
	 * REST TEMPLATE TO CONSUME OTHER MICROSERVICE
	 */
//	@GetMapping("/{userId}")
//	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//		List<Rating> ratings = Arrays.asList(new Rating("AAA", 7), new Rating("BBB", 8), new Rating("CCC", 9));
//
//		return ratings.stream().map(rating -> {
//
//			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
//
//			return new CatalogItem(movie.getName(), "Description", rating.getRating());
//		}).collect(Collectors.toList());
//	}

	/**
	 * WEBCLIENT TO CONSUME OTHER MICROSERVICE
	 */
//	@GetMapping("/{userId}")
//	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
//
//		List<Rating> ratings = Arrays.asList(new Rating("AAA", 7), new Rating("BBB", 8), new Rating("CCC", 9));
//
//		return ratings.stream().map(rating -> {
//
//			Movie movie = webClientBuilder.build()
//					.get()
//					.uri("http://localhost:8082/movies/" + rating.getMovieId())
//					.retrieve()
//					.bodyToMono(Movie.class)
//					.block();
//
//			return new CatalogItem(movie.getName(), "Description", rating.getRating());
//		}).collect(Collectors.toList());
//	}

	/**
	 * REST TEMPLATE TO CONSUME OTHER TWO MICROSERVICE
	 */
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		log.trace("Inside MovieControllerResource class getCatalog invoked with userId : {}", userId);
//		List<Rating> ratings = Arrays.asList(new Rating("AAA", 7), new Rating("BBB", 8), new Rating("CCC", 9));
//		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingdata/user/" + userId,
//				UserRating.class);
//		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingdata/user/" + userId,
//				UserRating.class);

		// for Hystrix
		UserRating ratings = userRatingInfo.getUserRating(userId);

		return ratings.getUserRatings().stream().map(rating -> {

//			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
//			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
//					Movie.class);

			// for Hystrix
			return movieInfo.getCatalogItem(rating);
		}).collect(Collectors.toList());
	}

//	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond", value = "2000"),
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMillisecond", value = "5000") })
//	private CatalogItem getCatalogItem(Rating rating) {
//		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//		return new CatalogItem(movie.getName(), "Description", rating.getRating());
//	}

//	private CatalogItem getFallbackCatalogItem(Rating rating) {
//		return new CatalogItem("No movie found", "No Description", rating.getRating());
//	}

//	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
//	private UserRating getUserRating(String userId) {
//		return restTemplate.getForObject("http://ratings-data-service/ratingdata/user/" + userId, UserRating.class);
//	}

//	private UserRating getFallbackUserRating(String userId) {
//		UserRating userRating = new UserRating();
//		userRating.setUserRatings(Arrays.asList(new Rating("No movie found", 0)));
//		return userRating;
//	}

}