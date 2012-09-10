// Name: Javier Chavez
// Email: jchavez589@cnm.edu
// Exercise 1 Getting started
// Loan Listing 2.11 p71
// Due: sept 4 2012

import javax.swing.JOptionPane; 


public class ComputeLoanUsingInputDialog {
	public static void main(String[] args) {

			//showing user info and program info
			JOptionPane.showMessageDialog(null,"Javier\nCompute Loan\nLoan Listing 2.11 p 71");
			//asking user input
			String intrestDia = JOptionPane.showInputDialog("Enter Yearly Interest rate");
			// convert input to double
			double yrlyinterestRate = Double.parseDouble(intrestDia); //string to double
			// calculate monthly interest rate
			double monthlyIntrestRate = yrlyinterestRate/1200;
			// ask user input
			String numberofYrDia = JOptionPane.showInputDialog("Enter number of years");
			// convert input to double
			double numberofYrs = Double.parseDouble(numberofYrDia);
			// ask user input
			String loanDia = JOptionPane.showInputDialog("Enter the amount you want to be loaned");
			// parse input
			double loanAmount = Double.parseDouble(loanDia);
			// calculate monthly payment
			double monthlypayment = loanAmount * monthlyIntrestRate / (1-1 / Math.pow(1+monthlyIntrestRate, numberofYrs*12));
			//calculate total payment after number of years
			double totalpayment = monthlypayment * numberofYrs * 12;
			// show message
			String message = 	"Your monthly payment will be " + ((int)(monthlypayment*100)/100.0) + 
								"\nyour total amount paid will be " + ((int)(totalpayment*100)/100.0);

			JOptionPane.showMessageDialog(null, message);			

	}
}