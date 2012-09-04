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

		JOptionPane.showMessageDialog(null,"Javier\nCompute BMI\nListing 3.5 p 98");

		String weightString = JOptionPane.showInputDialog(null,"Enter weight in pounds");

		double weight = Double.parseDouble(weightString);

		String heightString = JOptionPane.showInputDialog(null,"Enter height in inches");

		double height = Double.parseDouble(heightString);

		double weightInKilo = weight * KILO_PER_POUND;
		double heighttoMeter = height * METER_PER_INCH;

		double bmi = weightInKilo / (heighttoMeter * heighttoMeter);

		if (bmi < 16) {
			JOptionPane.showMessageDialog(null,"You're are seriously underweight");		 	
		 } 
		 else if (bmi < 18) {
		 	JOptionPane.showMessageDialog(null,"You're underweight");
		 }
		 else if (bmi < 24) {
		 	JOptionPane.showMessageDialog(null,"You're normal weight");
		 }
		 else if (bmi < 29) {
		 	JOptionPane.showMessageDialog(null,"You're overweight");
		 }
		 else if (bmi < 35) {
		 	JOptionPane.showMessageDialog(null,"You're seriously overweight");
		 }
		 else {
		 	JOptionPane.showMessageDialog(null,"You're unbelievable " + bmi);
		 }




	}
}