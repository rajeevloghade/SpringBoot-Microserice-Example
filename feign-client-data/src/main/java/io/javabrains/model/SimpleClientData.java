package io.javabrains.model;

public class SimpleClientData {
	private int id;
	private String name;
	private int amount;

	public SimpleClientData(int id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	@Override
	public String toString() {
		return "SimpleClientData [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}

}