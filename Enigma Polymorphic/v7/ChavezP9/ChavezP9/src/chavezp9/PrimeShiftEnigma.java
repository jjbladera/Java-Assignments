/*PrimeShiftEnigma.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java I P9 Enigma
 */
package chavezp9;

import java.util.ArrayList;


public class PrimeShiftEnigma extends Enigma{
    
    private ArrayList <Integer> primeNumbers;
    
    PrimeShiftEnigma()
    {
            int[] tmp = {37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113 };
            primeNumbers = new ArrayList<Integer>();
            for (int i = 0; i < tmp.length; i++) {
            primeNumbers.add(tmp[i]);
        }
    }
    
    @Override
    protected void encode()
    {
        String tempMessage = "";
        super.encode();

        int  p;
        for (int i = 0; i < encodedMessage.length(); i++) 
        {
            char m = encodedMessage.charAt(i);

            if(isPrime(m))  //if char is prime
            {
                p = primeNumbers.indexOf((int)m);  //find where its located in array

                //if the key is prime
                if(isPrime(key))    //if the key is prime
                {
                    //shift to next prime
                    if(primeNumbers.get(p) == 113)  //if the prime is at the end
                    {                               //if the array
                        tempMessage +=  (char) 37;
                    }
                    else
                    {
                        ++p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
                //if the key is even
                else if(key % 2 == 0)
                {
                    //shift to next next prime 
                    if(primeNumbers.get(p) > 107)
                    {
                        if(primeNumbers.get(p) == 109) {
                            tempMessage += (char) 37;
                        }
                        else {
                            tempMessage += (char) 41;
                        }
                    }
                    else
                    {
                        ++p;
                        ++p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
                else
                {
                    //shift to next next next prime
                    if(primeNumbers.get(p) > 103)
                    {
                        if(primeNumbers.get(p) == 107) {
                            tempMessage +=  (char)	37;
                        }
                        if(primeNumbers.get(p) == 109) {
                            tempMessage +=  (char)	41;
                        }
                        if(primeNumbers.get(p) == 113) {
                            tempMessage +=  (char)	43;
                        }
                    }
                    else
                    {
                        ++p;
                        ++p;
                        ++p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
            }//END CHAR Prime
            else
            {
                tempMessage += (char) m;
            }
        }

        encodedMessage = tempMessage;
    }

        
    boolean isPrime(int num)
    {
       for(int i = 2; i <= Math.sqrt((double)num); i++)
       {
          if ((num % i) == 0)
              {
                      return false;
              }  //divides evenly- NOT PRIME!
       }

       return true;   //no numbers divided evenly- PRIME!
    }

    @Override
    protected void decode()
    {
        String tempMessage = "";
        //super.encodeMsg();

        int  p;
        for (int i = 0; i < encodedMessage.length(); i++) 
        {
            char m = encodedMessage.charAt(i);

            if(isPrime((int)m))
            {
                p = primeNumbers.indexOf((int)m);

                //if the key is prime
                if(isPrime(key))					
                {
                    //shift to next prime
                    if(primeNumbers.get(p) == 37)
                    {
                        tempMessage +=  (char) 113;
                    }
                    else
                    {
                        --p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
                //if the key is even
                else if(key % 2 == 0)
                {
                    //shift to next next prime 
                    if(primeNumbers.get(p) < 43)
                    {
                        if(primeNumbers.get(p) == 41) {
                            tempMessage += (char) 113;
                        }
                        else {
                          tempMessage += (char) 109;
                        }
                    }
                    else
                    {
                        --p;
                        --p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
                else
                {
                    //shift to next next next prime
                    if(primeNumbers.get(p) < 47)
                    {
                        if(primeNumbers.get(p) == 37) {
                            tempMessage +=  (char)	107;
                        }
                        if(primeNumbers.get(p) == 41) {
                            tempMessage +=  (char)	109;
                        }
                        if(primeNumbers.get(p) == 43) {
                            tempMessage +=  (char)	113;
                        }
                    }
                    else
                    {
                        --p;
                        --p;
                        --p;
                        tempMessage += (char) primeNumbers.get(p).intValue();
                    }
                }
            }//END CHAR Prime
            else
            {
                tempMessage += (char) m;
            }
        }

        encodedMessage = tempMessage;
        super.decode();     //calling super class last 
    }
}
