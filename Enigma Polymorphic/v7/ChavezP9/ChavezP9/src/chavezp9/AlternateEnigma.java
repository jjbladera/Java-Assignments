/*AlternateEnigma.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java I P9 Enigma
 */
package chavezp9;

public class AlternateEnigma extends Enigma{
    
    @Override
    protected void encode()
    {
        super.encode();     //call main encode first
	String tmp = "";

        if(key % 2 == 0)    //if key is even
        {
            tmp = reOrder(encodedMessage,0);    //reorder with even first
        }
        else if(key % 2 != 0)
        {
            tmp = reOrder(encodedMessage,1);    //reorder with odd first
        }

	encodedMessage = tmp;                   //set the encoded message
    }
    
    
    @Override
    protected void decode()
    {
    	String tmp = "";
        if(key % 2 == 0)
        {
            tmp = reOrderDecode(encodedMessage,0);
        }
        else if(key % 2 != 0)
        {
            tmp = reOrderDecode(encodedMessage,1);
        }
        super.encodedMessage = tmp;
        
        super.decode();                         //calling decode last
    }    

    private String reOrder(String msg, int i) {
        
        String sE = "";
        String sO = "";

        for (int j = 0; j < msg.length(); j++) {
            if (j % 2 == 0) {
                sE += msg.charAt(j);
            }
            else
            {
                sO += msg.charAt(j);
            }
        }
        if (i == 0) {
            return sE+sO;                   //string even first
        }
        else{
            return sO+sE;                   //string odd first

        }
 
    }
    private String reOrderDecode(String msg, int i) 
    {
        String sE = "", sO = "", temp ="";
        //finding the length of each even and odd string
        int  eArrayLength = msg.length()/2, oArrayLength = msg.length()/2;
        //when odd, even is always one larger
        if (msg.length() % 2 != 0) {
            eArrayLength++;
        }
        //cutting main string into sperate strings based on key
        if (i == 0) {
            sE = msg.substring(0, eArrayLength);
            sO = msg.substring(eArrayLength, msg.length());
        }
        else{
            sO = msg.substring(0, oArrayLength);
            sE = msg.substring(oArrayLength, msg.length());
        }
        //this loop works by intertwining two strings
        // H L O W R D  First string
        //  E L   O L   Second string
        // HELLO WORLD  becomes
        int a=0, f = 0;
        for (int j = 0; j < msg.length(); j++) {
            if (j % 2 == 0) {
                temp += sE.charAt(a++);
            }
            else
            {
                temp += sO.charAt(f++);
            }
        }
        return  temp; 
    }
}
