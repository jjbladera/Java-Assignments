// Name: Javier Chavez
// Email: jchavez589@cnm.edu
// Exercise 1 Getting started
// Loan Listing 2.11 p71
// Due: sept 4 2012

import javax.swing.JOptionPane; 


public class ComputeLoanUsingInputDialog {
	public static void main(String[] args) {
		int retry = 0;

		do{
			JOptionPane.showMessageDialog(null,"Javier\nCompute Loan\nLoan Listing 2.11 p 71");

			String intrestDia = JOptionPane.showInputDialog("Enter Yearly Interest rate");

			double yrlyinterestRate = Double.parseDouble(intrestDia); //string to double

			double monthlyIntrestRate = yrlyinterestRate/1200;

			String numberofYrDia = JOptionPane.showInputDialog("Enter number of years");

			double numberofYrs = Double.parseDouble(numberofYrDia);

			String loanDia = JOptionPane.showInputDialog("Enter the amount you want to be loaned");

			double loanAmount = Double.parseDouble(loanDia);

			double monthlypayment = loanAmount * monthlyIntrestRate / (1-1 / Math.pow(1+monthlyIntrestRate, numberofYrs*12));

			double totalpayment = monthlypayment * numberofYrs * 12;

			String message = 	"Your monthly payment will be " + monthlypayment + 
								"\nyour total amount paid will be " + totalpayment + 
								"\n\nwould you like to play again?";

			retry = JOptionPane.showConfirmDialog(null, message);
			
		}while(retry==0);
	}
}