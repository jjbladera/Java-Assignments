// Name: Javier Chavez
// Email: jchavez589@cnm.edu
// Exercise 1 Getting started
// Listing 3.5 p 98
// Due: sept 4 2012


import javax.swing.JOptionPane;

public class ComputeandInterpretBMI {


	public static void main(String[] args) {
		final double KILO_PER_POUND = 0.45359237;
		final double METER_PER_INCH = 0.0254;
		//show user info
		JOptionPane.showMessageDialog(null,"Javier\nCompute BMI\nListing 3.5 p 98");
		//ask user input
		String weightString = JOptionPane.showInputDialog(null,"Enter weight in pounds");
		// parse input
		double weight = Double.parseDouble(weightString);
		//ask user input
		String heightString = JOptionPane.showInputDialog(null,"Enter height in inches");
		//parse input
		double height = Double.parseDouble(heightString);
		//convert to metric
		double weightInKilo = weight * KILO_PER_POUND;
		double heighttoMeter = height * METER_PER_INCH;

		double bmi = weightInKilo / (heighttoMeter * heighttoMeter);
		
		if (bmi < 16) {
			JOptionPane.showMessageDialog(null,"You're are seriously underweight"+ bmi);		 	
		 } 
		 else if (bmi < 18) {
		 	JOptionPane.showMessageDialog(null,"You're underweight"+ bmi);
		 }
		 else if (bmi < 24) {
		 	JOptionPane.showMessageDialog(null,"You're normal weight"+ bmi);
		 }
		 else if (bmi < 29) {
		 	JOptionPane.showMessageDialog(null,"You're overweight"+ bmi);
		 }
		 else if (bmi < 35) {
		 	JOptionPane.showMessageDialog(null,"You're seriously overweight"+ bmi);
		 }
		 else {
		 	JOptionPane.showMessageDialog(null,"You're unbelievable " + bmi);
		 }




	}
}