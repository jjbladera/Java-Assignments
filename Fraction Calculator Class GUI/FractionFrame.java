/*

File:    FractionFrame.java

Name:    Javier Chavez
Email:    jchavez589@cnm.edu
Due:    Sept 27 2012
Course:    Java Programming I
Assign: Program 3 - Fraction Calculator Class
*/
    

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FractionFrame extends JFrame {

    FractionCalc calculator = new FractionCalc();

    JTextField frac1 = new JTextField(3);
    JTextField frac2 = new JTextField(3);
    JTextField opp = new JTextField(1);
    JTextField results = new JTextField(40);

                // create a list of operations
    String[] operationList = {"+", "-", "*", "/"};
    //create a combo-box
    JComboBox operactionSelection = new JComboBox(operationList);
    


    JButton btnOk =  new JButton("Calculate");
    
    

    public FractionFrame(){
        setLayout(new FlowLayout(FlowLayout.LEFT, 10,20));

        setTitle("Javier Chavez Fraction Calculator GUI - P3");
        setSize(640,200); //width height
        setLocationRelativeTo(null); //center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit otherwise cmd-c



        //add elements to the container
        add(new JLabel("First Fraction"));
        add(frac1);
        add(new JLabel("Second Fraction"));
        add(frac2);
        add(new JLabel("Choose operation"));
        add(operactionSelection);
        add(btnOk);
        add(new JLabel("Results"));
        //add results 
        add(results);
        
        //add a listener to the ok btn
        btnOk.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //method
                    btnClick();
                }
            }
        );
    }//end constructor

    //when the button is clicked 
    void btnClick(){
        String resultOut, opperation, fraction1, fraction2;
        //
        fraction1 = frac1.getText();
        fraction2 = frac2.getText();
        opperation = (String)operactionSelection.getSelectedItem();
        //check for errors and handle them
        try{
            //set user input
            calculator.setInputData(fraction1, fraction2, opperation);
            resultOut = calculator.toString();
            //get results
            results.setText(resultOut); 
            //catch division / 0
        }catch(ArithmeticException ex){
            results.setText("Sorry, you cannot divide by zero."); 
            //show message
             JOptionPane.showMessageDialog(null,"Sorry dividing by 0 is not allowed", "Error", JOptionPane.OK_OPTION);
        }
    }


}