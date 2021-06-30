package io.javabrains.moviecatalogservice.models;

public class Rating {

	private String movieId;
	private int rating;
	private String portNumber;

	public Rating() {
		super();
	}

	public Rating(String movieId, int rating, String portNumber) {
		super();
		this.movieId = movieId;
		this.rating = rating;
		this.portNumber = portNumber;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", rating=" + rating + ", portNumber=" + portNumber + "]";
	}

}
