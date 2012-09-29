/*
File:   fractions.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    Sept 13 2012
Course: Java 1
Assign: Program 1 - Fraction Calc Program

*/
    

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Fractions {
    public static void main(String[] args) {
        // itialize variables
        int retry = 0;
        String strFrac1="", strFrac2="";
        // welcome message
        JOptionPane.showMessageDialog(null,"Javier Chavez\nJava Programming I\n\nFraction Calculator allows you to (+)(-)(*) and (/) fractions\n"
            + "It will show you: unreduced, reduced, and decimal form of the faction");
        
        do{
            //ask for user input
            strFrac1 = (String)JOptionPane.showInputDialog(null,"Please enter your first fraction"
                , "Fraction Calculations", JOptionPane.QUESTION_MESSAGE,null, null, strFrac1);
            strFrac2 = (String)JOptionPane.showInputDialog(null,"Please enter your second fraction"
                , "Fraction Calculations", JOptionPane.QUESTION_MESSAGE,null, null, strFrac2);

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

            ImageIcon icon = new ImageIcon("javi.png");

            //create frame that hold drop-down selection area
            JFrame frame = new JFrame("Chose operation");

            //create the output box that holds everything
            //after selection has been made, its saved to operation var
            String operation = (String)JOptionPane.showInputDialog(frame, "Select operation" , "Chose operation"
                , JOptionPane.QUESTION_MESSAGE,icon, operationList, "+");

            // parse operation var.
            int resultDen = 0;
            int resultNum = 0;
            int gcd = 1;
            int gcdTst = 2;
            String result = "";
            String resultFactor = "";
            double resultDec = 0.0000;

            char opp = operation.charAt(0); // string to char

            // handle division by 0
            if (den1 == 0 || den2 == 0) {
                JOptionPane.showMessageDialog(null,"Sorry dividing by zero!"
                ,"Bye", JOptionPane.QUESTION_MESSAGE);
                continue;
            }
            //depending on char choose how to handle calculation 
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
                    resultDen = den1*num2;
                    result = (resultNum + "/" + resultDen);
                    resultDec = (double)resultNum/(double)resultDen;
                break;
                case '*':
                    resultNum = num1*num2;
                    resultDen = den1*den1;
                    result = (resultNum + "/" + resultDen);
                    resultDec = (double)resultNum/(double)resultDen;
                break;
                default:
                break;
            }
            // show 4 trailing numbers
            DecimalFormat formatter = new DecimalFormat("0.0000");
            //sending to string
            String resultDecStr = formatter.format(resultDec); 


            //find gcd to reduce fraction
            while(gcdTst <= resultNum && gcdTst <= resultDen)
            {
                if (resultNum%gcdTst == 0 && resultDen%gcdTst == 0 )
                {
                    gcd = gcdTst;
                }
                gcdTst++;

            }
            //divid each number by the gcd for reduced fraction
            resultFactor = (resultNum / gcd) + "/" + (resultDen / gcd);
            // create output message
            String msg = num1 + "/" + den1 + opp +
                         num2 + "/" + den2 + " = " + 
                         result + " which reduces to " +
                         resultFactor + " (" + resultDecStr + ")";
            // show result and ask for another try
            JOptionPane.showMessageDialog(null, msg,"Result",JOptionPane.PLAIN_MESSAGE);
            retry = JOptionPane.showConfirmDialog(null, "Would you like to calculate another fraction.", "Try again?", JOptionPane.YES_NO_CANCEL_OPTION);
            
        }while(retry==0);
        //good bye message
        JOptionPane.showMessageDialog(null,"Thank you for using\nFraction Calculator\n"
            + "See you soon!", "Bye", JOptionPane.PLAIN_MESSAGE);

            //exiting 
        System.exit(0);
    }
}
