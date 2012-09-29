/*

File:   FractionCalc.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    September 27 2012
Course: Java I
Assign: Program 3 - Fraction Calculator Class
*/

import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class FractionCalc {
    private String resultsString;
    private String decimalResults;
    private String result;
    private String reducedFrac;
    private int num1;
    private int den1;
    private int num2;
    private int den2;
    private char oppChar;

    // Constructor //
    public FractionCalc(){
        oppChar = '+';
        num1 = 1;
        den1 = 2;
        num2 = 1;
        den2 = 2;
        calcFraction();
    }


    // Getters //
    public String getResults(){ return resultsString; }
    public String getDecimalResults(){ return decimalResults; }
    public String toString(){
        //build and set the result string
        resultsString = num1 + "/" + den1 + " " + oppChar + " " +
                        num2 + "/" + den2 + " = " + 
                        result + " " + reducedFrac;

        // add decimal result to final string if not empty
        if (decimalResults != "") {
            resultsString += " (" + decimalResults + ")";    
        }
        return resultsString;
    }


    // Setter //
    public void setInputData(String frac1, String frac2, String oper){
        String strFrac1 = frac1;
        String strFrac2 = frac2;
        String operator = oper;

        //create tokenizer to split user input and delimiter is '/'
        StringTokenizer tokenizer1 = new StringTokenizer(strFrac1,"/");
        StringTokenizer tokenizer2 = new StringTokenizer(strFrac2,"/");

        // parse each input as int then assgn to var
        //first fraction
        num1 = Integer.parseInt(tokenizer1.nextToken());
        den1 = Integer.parseInt(tokenizer1.nextToken());
        //second fraction
        num2 = Integer.parseInt(tokenizer2.nextToken());
        den2 = Integer.parseInt(tokenizer2.nextToken());

        oppChar = operator.charAt(0); // string to char

        //ArithmaticException ex = new ArithmaticException();
        //throw ex;
        if(den1 == 0 || den2 == 0){
            throw new ArithmeticException("Diving by 0 is not allowed!");
        }
        else
            calcFraction();
    }

    
    // private // 
    private void calcFraction(){
        int resultDen;
        int resultNum;
        //depending on char choose how to handle calculation 
        switch (oppChar) {
            case '+':
                resultNum = (num1*den2) + (num2*den1);
                resultDen = den1*den2;
                break;
            case '-':
                resultNum = (num1*den2) - (num2*den1);
                resultDen = den1*den2;
                break;
            case '/':
                resultNum = num1*den2;
                resultDen = den1*num2;
                break;
            case '*':
                resultNum = num1*num2;
                resultDen = den1*den2;
                break;
            default:
                resultNum = 1;
                resultDen = 1;
                break;
        }//end-switch

        //build string with result
        result = (resultNum + "/" + resultDen);
        //divide each number for decimal result
        double resultDec = (double)resultNum/(double)resultDen;
        // show 4 trailing numbers
        DecimalFormat formatter = new DecimalFormat("0.0000");
        //set decimalResults
        decimalResults = formatter.format(resultDec); 
        //reduce fraction
        FractionReducer reducer = new FractionReducer();
        reducer.setFraction(resultNum, resultDen);
        //set reducedFrac
        reducedFrac = reducer.getResultsFrac();

    }//end-calcFraction

}