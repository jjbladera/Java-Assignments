/*File Enigma.java
 * 
 * Name:  Javier Chavez
 * Email: jchavez589@cnm.edu
 * P9 Enigma Class
 * 
 * CIS 2235 Java I
 */
package chavezp9;



public class Enigma implements EnigmaInterface {
    
    private static int MAX_KEY = 50;
    private static int MIN_KEY = 1;

    
    protected String message, encodedMessage, decodedMessage;
    protected int key = 1;
    
    @Override
    public void setMessage(String message) {
        
        this.message = message;
        key = (int)(Math.random() * 50);
        encode();
    }

    @Override
    public void setMessage(String message, int key) {
        
        this.message = message;
        if (key <= MAX_KEY && key >= MIN_KEY) {
            this.key = key;
        }
        else{
            this.key = 1;
        }
        encode();
    }

    @Override
    public void setEncodedMessage(String encodedMessage, int key) {
        this.encodedMessage = encodedMessage;
        
        
        if (key <= MAX_KEY && key >= MIN_KEY) {
            this.key = key;
        }
        else{
            this.key = 1;
        }
        decode();
    }

    @Override
    public String getMessage() {
        return decodedMessage;
    }

    @Override
    public String getEncodedMessage() {
        return encodedMessage;
    }

    @Override
    public int getKey() {
        return key;
    }

    protected void encode(){
        encodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char m = message.charAt(i);
            int mI = (int)m + key;
            if (mI > 126) 
            {
                    mI = (mI - 127)+32;
            }
            char c = (char) mI;

            encodedMessage += c;
        }
    }
    
    protected void decode(){
        decodedMessage = "";
        for (int i = 0; i < encodedMessage.length(); i++) {
            char c = encodedMessage.charAt(i);

            int mI = c - key;

            if (mI < 32) 
                    {
                mI = 127-( 32 - mI);
        }
        decodedMessage +=  (char)mI;
        }
    }
}
