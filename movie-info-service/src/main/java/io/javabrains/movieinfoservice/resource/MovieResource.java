package io.javabrains.movieinfoservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${server.port}")
	private String portNumber;

	Logger log = LoggerFactory.getLogger(MovieResource.class);

	@GetMapping("/{movieId}")
	public Movie getResource(@PathVariable("movieId") String movieId) {
		log.trace("Inside MovieResource class getResource invoked with movieId : {}", movieId);
		return new Movie(movieId, "Test Name", "desciption", portNumber);
	}

//	@Value("${api.key}")
//	private String apiKey;
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@RequestMapping("/{movieId}")
//	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
//	    log.trace("Inside MovieResource class getMovieInfo invoked with movieId : {}", movieId);
//		MovieSummary movieSummary = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
//		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
//	}

}