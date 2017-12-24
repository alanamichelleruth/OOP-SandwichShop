package edu.albany.sandwichShop;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

import edu.albany.person.Person;

public class Cashier extends Person{

	private double amountInReg; //Amount of money in the cash register
	
	//Constructor to assign Cashier's name and cash register amount
	public Cashier(String name, double amount){
		super(name, "cashier");
		this.amountInReg = amount;
	}
	
	//Method to make a sandwich purchase, decrease customer money and increase cash register money
	public void checkOut(Customer customer){
		DecimalFormat df = new DecimalFormat("0.00"); //to format money output

		//Display the total and ask customer how they're paying
		String message = "Your total is $" + customer.getFormattedTotalCost() + "\nHow are you paying?\n(Cash only please, enter dollar amount in the form \"00.00\")";	
		String answer = JOptionPane.showInputDialog(null, message, "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);

		//If the customer entered a valid monetary amount
		try{
			double cashPaid = Double.valueOf(answer);
			amountInReg += cashPaid; //Increment amountInReg
		
			//Calculate the change, see if the customer can't afford the order
			double change = cashPaid - customer.getTotalCost();
			String message2 = "";
			if (change < 0){
				amountInReg += change; //Decrement amountInReg by the customer's amount owed --- Sandwich hut could go in dept
				message2 += "You owe: $" + df.format(change*-1) + "\nYou do not have enough money to pay, go work in the kitchen.";
			}
			//Otherwise, the customer can afford the order
			else{
				amountInReg -= change; //Decrement amountInReg by the customer's change
				message2 += "Change due: $" + df.format(change) + "\nThank you for your purchase " + customer.getName() + ", enjoy your day!";
			}
			
			//Display whether or not the customer successfully made the purchase
			JOptionPane.showMessageDialog(null, message2, "Sandwich Hut", JOptionPane.QUESTION_MESSAGE);
		} 
		//If the customer didn't enter a monetary amount
		catch (Exception e){
			String message2 = "Invalid monetary amount.";
			JOptionPane.showMessageDialog(null, message2, "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);
			checkOut(customer);
		}
	}

	public double getAmountInReg() {
		return amountInReg;
	}
}
