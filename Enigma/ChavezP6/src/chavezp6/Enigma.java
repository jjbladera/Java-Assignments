/*File Enigma.java
 * 
 * Name:  Javier Chavez
 * Email: jchavez589@cnm.edu
 * P6 Enigma Class
 * 
 * CIS 2235 Java I
 */
package chavezp6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Enigma implements EnigmaInterface {
    
    private static int MAX_KEY = 50;
    private static int MIN_KEY = 1;

    
    private String message, encodedMessage, decodedMessage;
    int key = 1;
    
    @Override
    public void setMessage(String message) {
        
        this.message = message;
        key = (int)(Math.random() * 50);
        encodeMsg();
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
        encodeMsg();
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
        decodedMsg();
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
    
    public void openDoc(File file)
    {
        try
        {
            Scanner input = new Scanner(file);
            encodedMessage = input.nextLine();
            key = input.nextInt();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally{
            decodedMsg();
        }
    }
    
    public void saveDoc(File file)
    {
        String out = encodedMessage + "\n" + key;
        try{          
            if (!file.exists()) {
                    file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(out);
            
            bw.close(); 
        }
        catch(IOException e){
         System.err.println("Error: " + e.getMessage());
        }        
    }
    
    
    private void encodeMsg(){
        encodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char m = message.charAt(i);
            int mI = m + key;
            if (mI >= 127) {
               mI = (mI - 127)+32;
            }
            char c = (char) mI;
            encodedMessage += c;
        }
    }
    
    private void decodedMsg(){
        decodedMessage = "";
        for (int i = 0; i < encodedMessage.length(); i++) {
            
            char c = encodedMessage.charAt(i);
            
            int mI = c - key;
            
            if (mI <= 32) {
                mI = 127-(32 - mI);
            }          
            decodedMessage +=  (char)mI;
        }
    }
}
