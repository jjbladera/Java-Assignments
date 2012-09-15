/*

File:	MainP2.java

Name:	Javier Chavez
Email:	jchavez589@cnm.edu
Due:	September 20 2012
Course:	Java I
Assign:	Program 2 - Fraction Calculator Class

*/
public class MainP2 {
	private FractionUI ui; //class member 

	public static void main(String[] args) {
		//calling new instance of itself
		MainP2 app = new MainP2(); //new invokes constructor
	}

	//constructor//
	public MainP2(){
		ui = new FractionUI(); //ui constructor
		ui.run();
		System.exit(0);
	}
}