package edu.albany.sandwichShop;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class SandwichDriver {

	public static void main(String[] args){

		//Declare variables
		Cashier cshr; //The current cashier
		Customer customer; //The current customer
		SandwichMaker sm; //The current sandwich maker
		
		//Welcome the customer to the shop, ask them they're name
		String name = JOptionPane.showInputDialog(null, "Welcome to the Sandwich Hut!\nPlease enter your name.", "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);

		//If the customer enters their name
		while (name != null && !name.equals("")){	
			cshr = new Cashier("Alice", 200); //The cashier, with a beginning cash register balance of 200
			customer = new Customer(name);
			sm = new SandwichMaker("Jeff", customer);
			
			//Ask the customer if they would like to buy a sandwich
			Object[] options = {"I would like to buy a sandwich.",
								"I would like to view Sandwich Shop information."};
			int n = JOptionPane.showOptionDialog(null, ("Hi " + customer.getName() + ", how may we help you?"), "Sandwich Hut", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						
			//If the customer would rather view information
			if(n == JOptionPane.NO_OPTION){
				DecimalFormat df = new DecimalFormat("0.00"); //to format money output
				
				String message = cshr + "\n" + sm + "\nAmount in register: $" + df.format(cshr.getAmountInReg());
				
				//Display the stats
				JOptionPane.showMessageDialog(null, message, "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);				
			}
			
			
			//While the customer wants to buy a sandwich
			while (n == JOptionPane.YES_OPTION){			
	
				//The sandwichMaker asks the user what they want
				sm.askCustomerWants();
				
				//The sandwichMaker asks if the user wants more, while reciting the order to this point
				n = sm.reciteOrder();
			}

			//Once the customer is done ordering, check them out
			if (!customer.getSandwiches().isEmpty()){
				cshr.checkOut(customer);
			}
			
			//If everyone stole all the sandwiches without paying, close the store
			if(cshr.getAmountInReg() < 0){
				JOptionPane.showMessageDialog(null, "Sorry, the Sandwich Hut is closing forever. We are broke thanks to you.", "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			//Welcome a new customer to the shop, ask them they're name
			name = null;
			name = JOptionPane.showInputDialog(null, "Welcome to the Sandwich Hut!\nPlease enter your name.", "Sandwich Hut", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
