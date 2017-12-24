package edu.albany.sandwichShop;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edu.albany.person.Person;

public class Customer extends Person{

	private ArrayList<Sandwich> sandwiches;
	
	//Constructor for a Customer with a given name
	public Customer(String name){
		super(name, "customer");
		sandwiches = new ArrayList<Sandwich>();
	}
	
	//Add a sandwich to the customer's order
	public void addSandwich(Sandwich s){
		sandwiches.add(s);
	}
	
	//Return the total cost (formatted) of the sandwiches in the order
	public String getFormattedTotalCost(){
		DecimalFormat df = new DecimalFormat("0.00"); //to format money output
		return df.format(getTotalCost());
	}
	
	//Return the total cost (unformatted) of the sandwiches in the order
	public double getTotalCost(){
		double total = 0;
		
		//Loop through all sandwiches and increment total
		for (Sandwich s : sandwiches){
			total += s.getCost();
		}
		
		return total;
	}
		
	public ArrayList<Sandwich> getSandwiches() {
		return sandwiches;
	}
}
