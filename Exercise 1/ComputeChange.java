// Name: Javier Chavez
// Email: jchavez589@cnm.edu
// Exercise 1 Getting started
// Listing 2.10 p 65
// Due: sept 4 2012

import javax.swing.JOptionPane;

public class ComputeChange {
	public static void main(String[] args) {
		int retry = 0;
		JOptionPane.showMessageDialog(null,"Javier Chavez\nCompute Change\nListing 2.10 p 65");
		
		do{

			String amountString = JOptionPane.showInputDialog(null,"Enter amount for example $11.56");

			double amount  = Double.parseDouble(amountString);

			int remaminingAmount = (int)(amount*100);

			//  make sure the non dollar amount is == when casted to int
			if ((double)remaminingAmount%100 != (amount*100)%100) {
				remaminingAmount++;
			}

			//find the number of dollars
			int numberOfOneDollars = remaminingAmount / 100;
			remaminingAmount = remaminingAmount % 100;

			//find the number of quarters
			int numberOfQuaters = remaminingAmount / 25;
			remaminingAmount = remaminingAmount % 25;

			//find the number of dimes
			int numberOfDimes = remaminingAmount / 10;
			remaminingAmount = remaminingAmount % 10;

			//find the number of nickels
			int numberOfNickels = remaminingAmount / 5;
			remaminingAmount = remaminingAmount % 5;

			// find the number of pennies
			int numberOfPennies =  remaminingAmount;


			String message =    "The amount $" + amount + " consists of \n" +  
								"\t" + numberOfOneDollars + " dollars\n" + 
								"\t" + numberOfQuaters + " quarters\n" +
								"\t" + numberOfDimes + " dimes\n" +
								"\t" + numberOfNickels + " nickels\n" +
								"\t" + numberOfPennies + " pennies\n";

			retry = JOptionPane.showConfirmDialog(null, message);
			
		}while(retry==0);
	}
}