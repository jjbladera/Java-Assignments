/*

File:   FractionReducer.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    September 20 2012
Course: Java I
Assign: Program 2 - Fraction Calculator Class

*/
public class FractionReducer {
    private int gcd = 1;
    private int gcdTst = 2;
    private int numerator= 0;
    private int denominator= 0;
    private int resultNum;
    private int resultDen;
    private String resultFactored;
    private String fraction;



    //constructor//
    public FractionReducer(){

    }
    //setters//
    public void setFraction(String frac){ fraction = frac; }
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