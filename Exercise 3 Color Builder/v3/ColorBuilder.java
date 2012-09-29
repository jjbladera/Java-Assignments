/*

File:   ColorBuilder.java

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
    private int contrastRed =0, contrastGreen=0, contrastBlue=0;


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
        float[] hsv = new float[3];
        Color.RGBtoHSB(red,green,blue,hsv);

        // add .5 to get 180 deg revolution on color wheel
        float oppColor = hsv[0] + 0.5f;
        
        // Now check if we need to fix number
        //The number cannot be larger than 1(360 deg)
        if (oppColor > 1)
        {
            //if so, subtract 1 leaving the decimal 
            oppColor -= 1;
        }

        //now convert color back into RGB with NEW hue
        Color rgb = Color.getHSBColor(oppColor, hsv[1], hsv[2]);

        //assign each value for use with toString
        contrastRed = rgb.getRed();
        contrastGreen = rgb.getGreen();
        contrastBlue = rgb.getBlue();
    }
}

