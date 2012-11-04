public class MainP4 {


	public static void main(String[] args) {
		//calling new instance of itself
		MainP4 app = new MainP4(); //new invokes constructor
	}

	//constructor//
	public MainP4(){
		ColorBuilderFrame frame = new ColorBuilderFrame();
		frame.setVisible(true); //show the box

	}
}