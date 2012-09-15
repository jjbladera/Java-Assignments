/*

File:	FractionUI.java

Name:	Javier Chavez
Email:	jchavez589@cnm.edu
Due:	September 20 2012
Course:	Java I
Assign:	Program 2 - Fraction Calculator Class

*/
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class FractionUI {

	private FractionCalc calc = new FractionCalc();
	private JComboBox operactionSelection;
	private ImageIcon icon;
	private JFrame frame;
	private	String strFrac1="";
	private String strFrac2="";
	private String operation;
	private String results="";
	private	int retry = 0;

	public FractionUI(){
		JOptionPane.showMessageDialog(null,"Javier Chavez\nJava Programming I\n\nFraction Calculator allows you to (+)(-)(*) and (/) fractions\n"
			+ "It will show you: unreduced, reduced, and decimal form of the faction");
	}
	public void run(){
		do{
			//ask for user input
			strFrac1 = (String)JOptionPane.showInputDialog(null,"Please enter your first fraction\n\ne.g. 2/15"
				, "Fraction Calculations", JOptionPane.QUESTION_MESSAGE,null, null, strFrac1);
			strFrac2 = (String)JOptionPane.showInputDialog(null,"Please enter your second fraction\n\ne.g. 1/6"
				, "Fraction Calculations", JOptionPane.QUESTION_MESSAGE,null, null, strFrac2);


			// create a list of operations
			String[] operationList = {"+", "-", "*", "/"};
			//create a combo-box
			operactionSelection = new JComboBox(operationList);

			icon = new ImageIcon("javi.png");//will add pics soon

			//create frame that hold drop-down selection area
			frame = new JFrame("Chose operation");

			//create the output box that holds everything
			//after selection has been made, its saved to operation var

			operation = (String)JOptionPane.showInputDialog(frame, "Select operation" , "Chose operation"
				, JOptionPane.QUESTION_MESSAGE,icon, operationList, "+");
			//send data to calculator
			calc.setInputData(strFrac1, strFrac2, operation);
			//get data back
			results = calc.getResults();
			// show result to user
			JOptionPane.showMessageDialog(null, results,"Result",JOptionPane.PLAIN_MESSAGE);

			//and ask for another try
			retry = JOptionPane.showConfirmDialog(null, "Would you like to calculate another fraction.", "Try again?", JOptionPane.YES_NO_CANCEL_OPTION);

		}while(retry==0);

		//good bye message
		JOptionPane.showMessageDialog(null,"Thank you for using\nFraction Calculator\n"
			+ "See you soon!", "Bye", JOptionPane.PLAIN_MESSAGE);

	}
}
		