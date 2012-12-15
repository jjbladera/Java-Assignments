/*QwertyEnigma.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java I P9 Enigma
 */
package chavezp9;

public class QwertyEnigma extends Enigma{
    char[][] lowerKeys = {
        {'q','w','e', 'r','t','y','u','i','o','p'},
        {'a','s','d','f','g','h','j','k','l'},
        {'z','x','c','v','b','n','m'}
    };
    char[][] upperKeys = {
        {'Q','W','E', 'R','T','Y','U','I','O','P'},
        {'A','S','D','F','G','H','J','K','L'},
        {'Z','X','C','V','B','N','M'}
    };
    
    @Override
    protected void encode()
    {
        super.encode();
        
	String tmp = "";

	for (int i = 0; i < encodedMessage.length(); i++) 
	{
		char c = encodedMessage.charAt(i);

		if(c > 64 && c < 91)    //lowercase will transform to upper
		{   //save row,col
                    int[] what; //this hold 2d location of keyboard key
                    what = shift(find(c, upperKeys));   // 
                    tmp += upperKeys[what[0]][what[1]]; //save the element
		}
		else if(c > 96 && c < 123)
		{
                    int[] what;	
                    what = shift(find(c, lowerKeys));
                    tmp += lowerKeys[what[0]][what[1]];
		}
		else {          //not within rang
                tmp += c;
            }
                

	}
	encodedMessage = tmp;
    }
    @Override
    protected void decode()
    {
        String tmp = "";

        for (int i = 0; i < encodedMessage.length(); i++) {
            char c = encodedMessage.charAt(i);
            
            if (c > 64 && c < 91 /*uppercasae*/) {
                int[] what;
                what = shiftBack(find(c, upperKeys));
                tmp += upperKeys[what[0]][what[1]];
            }
            else if(c > 96 && c < 123/*lowercase*/){
                int[] what;	
                what = shiftBack(find(c, lowerKeys));
                tmp += lowerKeys[what[0]][what[1]];     
            }
            else{
               tmp += c;

            }
        }
        super.encodedMessage = tmp;
        super.decode();
    }
    
    private int[] find(char c, char[][] cArray)
    {
        //FRIST NUMBER IS ROW
        //SECONDED NUMBER IS COLUMN
        int[] result = {0,0};
        for (int i = 0; i < cArray.length; i++) {
            for (int j = 0; j < cArray[i].length; j++) {
                if (cArray[i][j] == c) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    
    private int[] shift(int[] location)
    {
        int row = location[0];// is ROW
        int col = location[1];// is COL

        if (row == 0) {
            if (col < 9) {
                row = 1;
            }
            //nothing this is p
            if (col == 9 ) {
                
            }
        }
        else if (row == 1 ) {
             if (col < 7)
             {
                 row = 2;
             }
             if (col > 6) {
                 row = 0;
            }
        }
        else if (row == 2)
        {
            row = 0;
        }
        location[0] = row;
        location[1] = col;
        return location;
    }
    private int[] shiftBack(int[] location)
    {
        int row = location[0];// is ROW
        int col = location[1];// is COL

        if (row == 0) {
            if (col < 9) {
                if (col < 7) {
                    row = 2;
                }
                else if (col >= 7){
                   row = 1; 
                }
            }
            //nothing this is p
            if (col == 9 ) {
                
            }
        }
        else if (row == 1 ) {
            row = 0;
        }
        else if (row == 2)
        {
            row = 1;
        }
        location[0] = row;
        location[1] = col;
        return location;
    }
}