package model;

public class Product {
	private String description;
	private double price;

	// Construtor padrão
	public Product() {}

	// Novo construtor com parâmetros
	public Product(String description, double price) {
		this.description = description;
		this.price = price;
	}


	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
