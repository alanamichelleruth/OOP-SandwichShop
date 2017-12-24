package edu.albany.sandwichShop;

import java.text.DecimalFormat;
import javax.swing.JList;
import javax.swing.JOptionPane;

import edu.albany.person.Person;

public class SandwichMaker extends Person{

	private Customer customer;
	
	public SandwichMaker(String name, Customer customer){
		super(name, "sandwich maker");
		this.customer = customer;
	}
	
	//Make a sandwich for a given customer with selected ingredients
	public void askCustomerWants(){
        JList list = new JList(Ingredients.values());
		Sandwich currSandwich = new Sandwich();

        //Display a multi-selection window of ingredients to choose from
        JOptionPane.showMessageDialog(null, list, "Choose ingredients (Ctrl key for multiple)", JOptionPane.PLAIN_MESSAGE);
		
        //Add all the ingredients to the sandwich
		for (Object i: list.getSelectedValuesList()){
			currSandwich.addIngredient((Ingredients)i);
		}
		
		//Add the sandwich to the customer's sandwiches
		customer.addSandwich(currSandwich);
	}
	
	//Recite in an info message the customer's sandwiches thus far
	//Return the user's answer
	public int reciteOrder(){
		String message = customer.getName() + ", so far, you have:\n";
		
		//Loop through all the customer's sandwiches
		for(Sandwich s : customer.getSandwiches()){
			//Loop through all that sandwiches' ingredients
			for(Ingredients i : s.getIngredients()){
				message += i.getName() + "--$" + i.getFormattedPrice() + "\n";
			}
			message += "_________________\n";
		}
		message += "Total: $" + customer.getFormattedTotalCost() + "\n";
		message += "\n Would you like to add another Sandwich to your order?";
		
		//Return the user's option
		return JOptionPane.showOptionDialog(null, message, "Sandwich Hut", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
