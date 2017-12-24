package edu.albany.sandwichShop;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Sandwich {
	
	private ArrayList<Ingredients> ingredients; //All of the ingredients on the sandwich
	private double cost;
	
	public Sandwich(){
		ingredients = new ArrayList<Ingredients>();
		cost = 0;
	}
	
	public void addIngredient(Ingredients ingredient){
		ingredients.add(ingredient);
		cost += ingredient.getPrice();
	}
	
	public ArrayList<Ingredients> getIngredients(){
		return ingredients;
	}
	
	public double getCost(){
		return cost;
	}
	
	public String getFormattedCost() {
		DecimalFormat df = new DecimalFormat("0.00"); //to format money output
		return df.format(cost);
	}
}