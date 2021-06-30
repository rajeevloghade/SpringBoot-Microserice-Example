package io.javabrains.moviecatalogservice.models;

public class CatalogItem {

	private String name;
	private String desc;
	private int rating;
	private String portNumber;

	public CatalogItem() {
		super();
	}

	public CatalogItem(String name, String desc, int rating, String portNumber) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
		this.portNumber = portNumber;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "CatalogItem [name=" + name + ", desc=" + desc + ", rating=" + rating + ", portNumber=" + portNumber
				+ "]";
	}

}
