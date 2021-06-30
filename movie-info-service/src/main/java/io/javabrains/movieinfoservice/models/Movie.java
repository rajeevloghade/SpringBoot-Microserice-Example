package io.javabrains.movieinfoservice.models;

public class Movie {
	private String movieId;
	private String name;
	private String description;
	private String portNumber;

	public Movie() {
		super();
	}

	public Movie(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public Movie(String movieId, String name, String description) {
		this.movieId = movieId;
		this.name = name;
		this.description = description;
	}

	public Movie(String movieId, String name, String description, String portNumber) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", portNumber="
				+ portNumber + "]";
	}
}
