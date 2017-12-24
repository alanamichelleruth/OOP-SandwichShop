package edu.albany.sandwichShop;

import java.text.DecimalFormat;
import java.text.NumberFormat;

//Enum for the ingredients available for a sandwich
public enum Ingredients {
	
	//String name for the ingredient, double is the price
	CHICKEN("chicken", 4.99),
	TURKEY("turkey", 4.99),
	ROASTBEEF("roast beef", 5.99),
	HAM("ham", 5.99),
	VEG("veg", 4.99),
	CHEESE("cheese", .99),
	LETTUCE("lettuce", 0),
	TOMATO("tomato", 0),
	ONION("onion", 0),
	SAUCE("sauce", 0);
	
	private final String name;
	private final double price;
	
	private Ingredients(String name, double price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice(){
		return price;
	}
	
	public String getFormattedPrice() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(price);
	}
}
