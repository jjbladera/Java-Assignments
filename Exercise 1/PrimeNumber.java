// Name: Javier Chavez
// Email: jchavez589@cnm.edu
// Exercise 1 Getting started
// Listing 4.14 p 163
// Due: sept 4 2012

import javax.swing.JOptionPane;

public class PrimeNumber {
	public static void main(String[] args) {
		final int NUMBER_OF_PRIMES = 50; // number of primes to display

		final int NUMBER_OF_PRIMES_PER_LINE = 10; // display 10 per line

		int count = 0;
		int number = 2;
		String message = "";

		JOptionPane.showMessageDialog(null,"Javier C\nDisplay display first 50 prime numbers.\nListing 4.14 p 163");

		while (count < NUMBER_OF_PRIMES) {
			
			boolean isPrime = true;

			for (int divisor = 2; divisor <= number / 2; divisor++) {
				if (number % divisor == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				count++;
				if (count % NUMBER_OF_PRIMES_PER_LINE == 0)
					message += number+ "\n";
				else
					message += number + " ";
			}
			number++;
		}
		JOptionPane.showMessageDialog(null,message);
	}
}