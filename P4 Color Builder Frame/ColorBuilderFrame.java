/*
Javier Chavez
Due oct 9 2012
CIS 2235 Java 1

Program 4

This is a color picker however the RGB value that is 
displayed over the current color is actually a in the
color the contrasting color of the current color

*/

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class ColorBuilderFrame extends JFrame {
    
    private JSlider redSlider, greenSlider, blueSlider;
    private JLabel redLabel, greenLabel, blueLabel,contrasting;
    private JPanel colorPanel, sliders, labels;
    private int r=0, g=0, b=0;


    public ColorBuilderFrame(){

        //create 3 sliders
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        //create labels
        redLabel = new JLabel("Red");
        greenLabel = new JLabel("Green");
        blueLabel = new JLabel("Blue");
        contrasting = new JLabel("RGB: R: 0 G: 0 B: 0");
        //set font on output label
        contrasting.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        contrasting.setSize(100, 100);
        //initialize the font color
        contrasting.setForeground(Color.WHITE);
        
        //create a panel to show main color
        colorPanel = new JPanel();
        //add the label to display the rgb value of the color 
        //initialize background
        colorPanel.setBackground(Color.BLACK);
        //add the text to the panel
        colorPanel.add(contrasting);

        //main container
        Container pane = this.getContentPane();
        //layout manager
        pane.setLayout(new GridLayout(1,4,3,3));
        //create area for sliders and labels
        sliders = new JPanel();
        labels = new JPanel();
        //add everything to the container
        pane.add(sliders);
        pane.add(labels);
        pane.add(colorPanel);

        // create 2 left and right layouts for sliders
        //3rows and one column
        sliders.setLayout(new GridLayout(3,1,2,2));
        sliders.add(redSlider);
        sliders.add(greenSlider);
        sliders.add(blueSlider);
        //3rows and one column
        labels.setLayout(new GridLayout(3,1,3,3));
        labels.add(redLabel);
        labels.add(greenLabel);
        labels.add(blueLabel);

        //adding listeners to each slider
        redSlider.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    // get the value from slider 
                    r = redSlider.getValue();
                    // update the text
                    redLabel.setText("Red = " + r);
                    // change the color
                    changeColors();

                }
            }
        );
        greenSlider.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    
                    g = greenSlider.getValue();
                    greenLabel.setText("Green = " + g);
                    changeColors();

                }
            }
        );
        blueSlider.addChangeListener(
            new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    
                    b = blueSlider.getValue();
                    blueLabel.setText("Blue = " + b);
                    changeColors();

                }
            }
        );

        setTitle("Javier Chavez - P4: Color builder frame");
        setSize(640,250); //width height
        setLocationRelativeTo(null); //center on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    private void changeColors() {
        ColorBuilder builder = new ColorBuilder();

        //set rgb value
        builder.setRGB(r, g, b);
        //set contrast in frame
        contrasting.setForeground(builder.getContrastColor());
        //set set in frame 
        contrasting.setText(builder.toString());
        //set the background in frame  
        colorPanel.setBackground(new Color(r,g,b));
    }

}
