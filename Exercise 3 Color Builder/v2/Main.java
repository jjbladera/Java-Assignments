/*

File:   MainE3.java

Name:   Javier Chavez
Email:  jchavez589@cnm.edu
Due:    October 2 2012
Course: Java I
Assign: Exercise 3 - Color Builder Class

*/
public class Main {


    public static void main(String[] args) {
        //calling new instance of itself
        Main app = new Main(); //new invokes constructor
    }

    //constructor//
    public Main(){
        ColorBuilderFrame frame = new ColorBuilderFrame();
        frame.setVisible(true); //show the box
    }
}