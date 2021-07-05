/*
* Class CMSC203
* Instructor: Ahmed Tarek
* Description: This class creates the methods for the encryption and decryption for the ceasar and the bellaso decryption..
* Due: 7/15/2021
* Platform: Eclipse
* I pledgethat i have completed the programmming assignment independently. I have not copied the code from any student or any source. i have not given any code to 
 any student
 Print your name here: Shamariah Ogu
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' '; //32
	private static final char UPPER_BOUND = '_'; //95
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; // range = 95 - 32

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean allowed = true;
		for(int i = 0; i < plainText.length(); i++) { //iterates through the text to determind if string is within
			if( 
			!( (int) plainText.charAt(i) >= LOWER_BOUND && 
			(int) plainText.charAt(i)<= UPPER_BOUND ))
			{
			allowed = false; //RETURNS FALSE IF NOT IN RANGE
			break;	
			}
		//throw new RuntimeException("method not implemented");
		}
		return allowed;
	}
	
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String result = "";
		
		for(int i = 0; i< plainText.length(); i++) {
		char c = plainText.charAt(i);
		int encryptedCharint = ((int)c + key);
		while(encryptedCharint > UPPER_BOUND) {
			encryptedCharint -= RANGE;
		}
		result += (char)encryptedCharint;	
		}	
		return result;		
		//throw new RuntimeException("method not implemented");
	}
	
	private static int Wrap_around(int key) {
		// TODO Auto-generated method stub
		while(key > UPPER_BOUND) {
			key -= UPPER_BOUND - LOWER_BOUND;
		}
		return key;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String result = ""; //encryption method for the bellaso method.
		int bellasoStrLength = bellasoStr.length(); 
		
		for (int index = 0; index < plainText.length(); index++) { //for loop that iterates through the plaintext
		
		char c = plainText.charAt(index);
		int encryptedCharint = ((int)c + (int)bellasoStr.charAt(index%bellasoStrLength));
		while (encryptedCharint > (int)UPPER_BOUND) 
		{
			encryptedCharint -= RANGE;
		}
		result += (char)encryptedCharint;
		//throw new RuntimeException("method not implemented");
	}
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		String dResult = "";
		for(int i = 0; i < encryptedText.length(); i++) {
		char c = encryptedText.charAt(i);
		int decryptedCharint = ((int)c - key);
		while(decryptedCharint < LOWER_BOUND) {
			decryptedCharint += RANGE;
		}
		dResult += (char)decryptedCharint;
		}
		
		return dResult;
				
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		String dResult = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < encryptedText.length(); index++) {
		char c = encryptedText.charAt(index);
		int decryptedCharint = ((int)c - (int)bellasoStr.charAt(index%bellasoStrLength));
		
		while (decryptedCharint< (int)LOWER_BOUND) {
			decryptedCharint += RANGE;
		}
			dResult += (char)decryptedCharint;
		}
		return dResult;	
		}			
		//throw new RuntimeException("method not implemented");
			
	}
