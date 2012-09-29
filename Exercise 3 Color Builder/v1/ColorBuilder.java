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
    private Color contrastColor;
    private int contrastRed =0, contrastGreen=0, contrastBlue=0;


    public ColorBuilder(){
        //default color is black
        red     = 0;
        green   = 0;
        blue    = 0;
    }
    public ColorBuilder(int r, int g, int b){
        // assigns initial color to object
        red     = r;
        green   = g;
        blue    = b;
    }
    public void setRed(int r){
        red     = r;
    }
    public void setGreen(int g){
        green   = g;
    }
    public void setBlue(int b){
        blue    = b;
    }
    public void setRGB(int r, int g, int b){
        // assigns initial color to object
        red     = r;
        green   = g;
        blue    = b;
    }

    //get color object
    public Color getMainColor(){
        Color mainColor = new Color(red,green,blue);
        return mainColor;
    }

    public Color getContrastColor(){
        calculateContrast();
        return contrastColor;
    }

    public String toString(){
        String mys = " BackG R " + contrastRed + " G " + contrastGreen  + " B " + contrastBlue
         + "\nR " + red + " G " + green  + " B " + blue;
        return mys;
    }

    private void calculateContrast(){
        boolean brightness = false;
        boolean differnce = false;
        
        // Based on W3C standards
        // Brightness Difference: (>= 125)
        // Colour Difference: (>= 500)

        //has to be greater than 125
        //checking brightness difference 
         contrastRed = (int)(Math.random() * 255);
         contrastGreen = (int)(Math.random() * 255);
         contrastBlue = (int)(Math.random() * 255);

        while(brightness == false && differnce == false){

            if ((red*299 + green*587 + blue*114)/1000 > 125 ) {
                brightness = true;
            }
            else{
                    brightness = false;
                    contrastRed = (int)(Math.random() * 255);
                    contrastGreen = (int)(Math.random() * 255);
                    contrastBlue = (int)(Math.random() * 255);

                }
            
            if (Math.abs(red - contrastRed) + Math.abs(green - contrastGreen) + Math.abs(blue - contrastBlue) > 500) {
                differnce = true;
            }
            else{
                    differnce = false;
                    contrastRed = (int)(Math.random() * 255);
                    contrastGreen = (int)(Math.random() * 255);
                    contrastBlue = (int)(Math.random() * 255);
            }
        }

        contrastColor = new Color(contrastRed,contrastGreen,contrastBlue);
    }
}

