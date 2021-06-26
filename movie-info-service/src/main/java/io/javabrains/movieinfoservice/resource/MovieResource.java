package io.javabrains.movieinfoservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@GetMapping("/{movieId}")
	public Movie getResource(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test Name");
	}

//	@Value("${api.key}")
//	private String apiKey;
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@RequestMapping("/{movieId}")
//	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
//		MovieSummary movieSummary = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
//		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
//	}

}