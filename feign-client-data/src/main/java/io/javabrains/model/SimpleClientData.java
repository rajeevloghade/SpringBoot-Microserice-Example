package io.javabrains.model;

public class SimpleClientData {
	private int id;
	private String name;
	private int amount;
	private String port;

	public SimpleClientData() {
		super();
	}

	public SimpleClientData(int id, String name, int amount, String port) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public String getPort() {
		return port;
	}

	@Override
	public String toString() {
		return "SimpleClientData [id=" + id + ", name=" + name + ", amount=" + amount + ", port=" + port + "]";
	}

}