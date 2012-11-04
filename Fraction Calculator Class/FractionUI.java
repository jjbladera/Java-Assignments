/*

File:   FractionUI.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    September 20 2012
Course: Java I
Assign: Program 2 - Fraction Calculator Class

*/
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;

public class FractionUI {

    private FractionCalc calc = new FractionCalc();
    private JComboBox operactionSelection;
    private ImageIcon iconNum;
    private ImageIcon iconMain = new ImageIcon("images/welcome.png");
    private ImageIcon iconSelect;
    private ImageIcon iconBye;

    private JFrame frame;
    private String strFrac1="";
    private String strFrac2="";
    private String operation;
    private String results="";
    private String resultInDecimal = "";
    private int retry = 0;

    public FractionUI(){
        JOptionPane.showMessageDialog(null,"Javier Chavez\nJava Programming I\n\nFraction Calculator allows you to (+)(-)(*) and (/) fractions\n"
            + "It will show you: unreduced, reduced, and decimal form of the faction", "Welcome", JOptionPane.OK_OPTION, iconMain);
    }
    public void run(){
        do{
            Image imgF = Toolkit.getDefaultToolkit().getImage("images/firstnum.png");
            iconNum = new ImageIcon(imgF);//will add pics soon
            //ask for user input
            strFrac1 = (String)JOptionPane.showInputDialog(null,"Please enter your first fraction\n\ne.g. 2/15"
                , "Fraction Calculations", JOptionPane.OK_OPTION,iconNum, null, strFrac1);
            strFrac2 = (String)JOptionPane.showInputDialog(null,"Please enter your second fraction\n\ne.g. 1/6"
                , "Fraction Calculations", JOptionPane.OK_OPTION,iconNum, null, strFrac2);


            // create a list of operations
            String[] operationList = {"+", "-", "*", "/"};
            //create a combo-box
            operactionSelection = new JComboBox(operationList);

            //create frame that hold drop-down selection area
            frame = new JFrame("Chose operation");
            //locate icon
            iconSelect = new ImageIcon("images/select.png");//will add pics soon
            //create the output box that holds everything
            //after selection has been made, its saved to operation var

            operation = (String)JOptionPane.showInputDialog(frame, "Select operation" , "Chose operation"
                , JOptionPane.OK_OPTION,iconSelect, operationList, "+");
            
            //if the cancel button is press operation will be null
            if (operation == null) break; //exit while loop and show goodbye

            //send data to calculator
            calc.setInputData(strFrac1, strFrac2, operation);
            //get data back
            results = calc.getResults();
            resultInDecimal = calc.getDecimalResults();
            // add decimal result to final string if not empty
            if (resultInDecimal != "") {
                results += " (" + resultInDecimal + ")";    
            }
            //otherwise probably dividing by zero.
            
            // show result to user
            JOptionPane.showMessageDialog(null, results,"Result",JOptionPane.PLAIN_MESSAGE);

            //and ask for another try
            retry = JOptionPane.showConfirmDialog(null, "Would you like to calculate another fraction.", "Try again?", JOptionPane.YES_NO_OPTION,JOptionPane.YES_NO_OPTION, iconMain);

        }while(retry==0);

        // locate icon
        iconBye = new ImageIcon("images/bye.png");//will add pics soon
        //good bye message
        JOptionPane.showMessageDialog(null,"Thank you for using\nFraction Calculator\n"
            + "See you soon!", "Bye", JOptionPane.PLAIN_MESSAGE, iconBye);

    }
}
        