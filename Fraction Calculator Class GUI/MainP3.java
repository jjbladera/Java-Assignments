/*

File:	MainP2.java

Name:	Javier Chavez
Email:	jchavez589@cnm.edu
Due:	September 27 2012
Course:	Java I
Assign:	Program 3 - Fraction Calculator Class

*/
public class MainP3 {


	public static void main(String[] args) {
		//calling new instance of itself
		MainP3 app = new MainP3(); //new invokes constructor
	}

	//constructor//
	public MainP3(){
		FractionFrame frame = new FractionFrame();
		frame.setVisible(true); //show the box
	}
}