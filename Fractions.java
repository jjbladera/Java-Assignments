/*
File:	fractions.java

Name:	Javier Chavez
Email:	jchavez589@cnm.edu
Due:	Sept 13 2012
Course:	Java 1
Assign:	Program 1 - Fraction Calc Program

*/
	

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.StringTokenizer;


public class Fractions {
	public static void main(String[] args) {
		int retry = 0;

		JOptionPane.showMessageDialog(null,"Javier Chavez\nJava Programming I\nFraction Calculator allows you to (+)(-)(*) and (/) fractions\n"
			+ "It will show you: unreduced, reduced, and decimal form of the faction");
		
		do{
			String strFrac1, strFrac2;
			
			strFrac1 = JOptionPane.showInputDialog(null,"Please enter your first fraction"
				, "Fraction Calculations", JOptionPane.QUESTION_MESSAGE);
			strFrac2 = JOptionPane.showInputDialog(null,"Please enter your second fraction"
				, "Fraction Calculations", JOptionPane.QUESTION_MESSAGE);

			//create tokenizer to split user input and delimiter is '/'
			StringTokenizer tokenizer1 = new StringTokenizer(strFrac1,"/");
			StringTokenizer tokenizer2 = new StringTokenizer(strFrac2,"/");

			// parse each input as int then assgn to var
			//first fraction
			int num1 = Integer.parseInt(tokenizer1.nextToken());
			int den1 = Integer.parseInt(tokenizer1.nextToken());
			//second fraction
			int num2 = Integer.parseInt(tokenizer2.nextToken());
			int den2 = Integer.parseInt(tokenizer2.nextToken());

			// create a list of operations
			String[] operationList = {"+", "-", "*", "/"};
			//create a combo-box
			JComboBox operactionSelection = new JComboBox(operationList);

			//create frame that hold drop-down selection area
			JFrame frame = new JFrame();

			//create the output box that holds everything
			//after selection has been made, its saved to operation var
			String operation = (String)JOptionPane.showInputDialog(frame, "Select operation" , "Chose operation"
				, JOptionPane.QUESTION_MESSAGE,null, operationList, "+");

			// parse operation var.
			int resultDen = 0;
			int resultNum = 0;
			int gcd = 1;
			int gcdTst = 2;
			String result = "";
			String resultFactor = "";
			double resultDec = 0.0000;

			char opp = operation.charAt(0); // string to char
			switch (opp) {
				case '+':
					resultNum = (num1*den2) + (num2*den1);
					resultDen = den1*den2;
					result = (resultNum + "/" + resultDen);
					resultDec = (double)resultNum/(double)resultDen;
				break;
				case '-':
					resultNum = (num1*den2) - (num2*den1);
					resultDen = den1*den2;
					result = (resultNum + "/" + resultDen);
					resultDec = (double)resultNum/(double)resultDen;
				break;
				case '/':
					resultNum = num1*den2;
					resultDen = den1*num1;
					result = (resultNum + "/" + resultDen);
					resultDec = (double)resultNum/(double)resultDen;
				break;
				case '*':
					resultNum = num1*num2;
					resultDen = den1*den2;
					result = (resultNum + "/" + resultDen);
					resultDec = (double)resultNum/(double)resultDen;
				break;
				default:
				break;
			}
			//find gcd to reduce fraction
			while(gcdTst <= resultNum && gcdTst <= resultDen)
			{
				if (resultNum%gcdTst == 0 && resultDen%gcdTst == 0 )
				{
					gcd = gcdTst;
				}
				gcdTst++;
			}
			
			resultFactor = (resultNum / gcd) + "/" + (resultDen / gcd);
			String msg = num1 + "/" + den1 + opp +
						 num2 + "/" + den2 + " = " + 
						 result + " which reduces to " +
						 resultFactor + " (" + resultDec + ")";
		
			retry = JOptionPane.showConfirmDialog(null, msg);
			
		}while(retry==0);
	}
}
