/*

File:   MainE3.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    October 2 2012
Course: Java I
Assign: Exercise 3 - Color Builder Class

*/

import java.awt.Color;
import java.lang.Math;


class ColorBuilder {

    private int red, green, blue;
    private int contrastRed =255, contrastGreen=255, contrastBlue=255;


    public ColorBuilder(){
        //default color is black
        red     = 0;
        green   = 0;
        blue    = 0;
        calculateContrast();
    }
    public ColorBuilder(int r, int g, int b){
        // assigns initial color to object
        red     = r;
        green   = g;
        blue    = b;
        calculateContrast();
    }
    public void setRed(int r){
        red     = r;
        calculateContrast();
    }
    public void setGreen(int g){
        green   = g;
        calculateContrast();
    }
    public void setBlue(int b){
        blue    = b;
        calculateContrast();
    }
    public void setRGB(int r, int g, int b){
        // assigns initial color to object
        red     = r;
        green   = g;
        blue    = b;
        calculateContrast();
    }

    //get color object
    public Color getMainColor(){
        Color mainColor = new Color(red,green,blue);
        return mainColor;
    }

    public Color getContrastColor(){
        Color contrastColor = new Color(contrastRed,contrastGreen,contrastBlue);
        return contrastColor;
    }

    public String toString(){
        //building string with all rgb values
        String mys =    "Main Color:\t\t"+
                        "R " + red + 
                        " G " + green  + 
                        " B " + blue +
                        "\nContrasting Color:\t"+
                        "R " + contrastRed + 
                        " G " + contrastGreen  + 
                        " B " + contrastBlue;

        return mys;
    }

    private void calculateContrast(){
        //set contrasting color
        contrastRed     = colorC(red);
        contrastGreen   = colorC(green);
        contrastBlue    = colorC(blue);
    
    }

    private int colorC(double x){
         // convert color amount to percentage
         x = x/255.0;
        /*
            determine contrast based on % of color x.

            it will either return white color if x < 50% or
            return white if color x > 50% 

            by doing so there are
            there are 8 possible colors
            as either R - G - B will either be 
            all white or all black 
            remember 1=255
            yellow(r1g1b0) white(r1g1b1)
            magenta red 
            blue black 
            cyan green
        */
        //subtract color x% from 100%
        // giving another color (lighter or darker)
        //remember 1.0 == 100%
        double y = 1.0 - x;
        
        //check the distance away color x is away from color y
        //if > 50% return black
        if (Math.abs(x-y) >= .5) {
            //return 0 color (black)
            //convert back to color
            return 0*255;
        }
        else 
            // return all color (white)
            //convert back to color
            return 1*255;
    }

}

