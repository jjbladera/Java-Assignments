/*

File:   FractionReducer.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    Sept 27 2012
Course: Java I
Assign: Program 3 - Fraction Calculator Class

*/

import java.util.StringTokenizer;

public class FractionReducer {

    private int numerator;
    private int denominator;
    private int resultNum;
    private int resultDen;
    private String resultFactored; //result

    //constructor//
    public FractionReducer(){
         int numerator = 2;
         int denominator = 2;
    }

    //setters//
    public void setFraction(String frac){
        //parse the fraction
        StringTokenizer tokenizer = new StringTokenizer(frac,"/");
        //set den and num 
        numerator = Integer.parseInt(tokenizer.nextToken());
        denominator = Integer.parseInt(tokenizer.nextToken());
        //reduct eh frac
        reduceFrac();

    }

    public void setFraction(int num, int denom){
        //find gcd to reduce fraction
        numerator = num;
        denominator = denom;
        reduceFrac();
    }
    
    //getters//
    public String getResultsFrac(){ return resultFactored; }
    public int getResultsNum(){ return resultNum; }
    public int getResultsDenom(){ return resultDen; }

    //private//
    private void reduceFrac(){
        int gcd = 1;
        int gcdTst = 2;
        // start out at the highest possible value
        if (numerator > denominator)
            gcdTst = numerator;
        else
            gcdTst = denominator;


        while(gcdTst > 0)
        {
        //since we are starting off at the highest we break at the first number that gives 0 rmdr
            if (numerator%gcdTst == 0 && denominator%gcdTst == 0 )
            {
                gcd = gcdTst;
                break;
            }
            gcdTst--;

        }
        //divide each number by the gcd for reduced fraction
        resultNum = numerator / gcd;
        resultDen = denominator / gcd;

        //if the numerator and denominator are the same after reduction 
        //it was in lowest form 
        if (resultNum != numerator && resultDen != denominator)
            resultFactored =  "which reduces to " + resultNum + "/" + resultDen;
        else
            resultFactored = "already in lowest form";
    }
}