/*

File:	FractionCalc.java

Name:	Javier Chavez
Email:	jchavez589@cnm.edu
Due:	September 20 2012
Course:	Java I
Assign:	Program 2 - Fraction Calculator Class

*/

import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class FractionCalc {
	private FractionReducer reducer;
	private StringTokenizer tokenizer1;
	private StringTokenizer tokenizer2;
	private DecimalFormat formatter;
	private String resultsString = "";
	private String decimalResults = "";
	private String strFrac1;
	private String strFrac2;
	private String operator;
	private String result = "";
	private String reducedFrac = "";
	private String resultFactor = "";
	private double resultDec = 0.0000;
	private int num1;
	private int den1;
	private int num2;
	private int den2;
	private int resultDen = 0;
	private int resultNum = 0;
	private char opp;

	// Constructor //
	public FractionCalc(){

	}
	// Getters //
	public String getResults(){ return resultsString; }
	public String getDecimalResults(){ return decimalResults; }


	// Setter //
	public void setInputData(String frac1, String frac2, String oper){
		strFrac1 = frac1;
		strFrac2 = frac2;
		operator = oper;
		calFraction();
	}
	// private // 
	private void calFraction(){
		//create tokenizer to split user input and delimiter is '/'
		tokenizer1 = new StringTokenizer(strFrac1,"/");
		tokenizer2 = new StringTokenizer(strFrac2,"/");

		// parse each input as int then assgn to var
		//first fraction
		num1 = Integer.parseInt(tokenizer1.nextToken());
		den1 = Integer.parseInt(tokenizer1.nextToken());
		//second fraction
		num2 = Integer.parseInt(tokenizer2.nextToken());
		den2 = Integer.parseInt(tokenizer2.nextToken());

		opp = operator.charAt(0); // string to char
		
		//divide by zero
		if (den1 == 0 || den2 == 0) {
			resultsString = "Sorry dividing by zero is not allowed!";
		}
		//if not dividing by zero
		else{
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
			}//endswitch

			// show 4 trailing numbers
			formatter = new DecimalFormat("0.0000");
			//sending to string
			decimalResults = formatter.format(resultDec); 
			reducer = new FractionReducer();
			reducer.setFraction(resultNum, resultDen);
			reducedFrac = reducer.getResultsFrac();

			//build the result string
			resultsString = num1 + "/" + den1 + opp +
							num2 + "/" + den2 + " = " + 
							result + reducedFrac +
							" (" + decimalResults + ")";
		}//endelse
	}//endmethod
}