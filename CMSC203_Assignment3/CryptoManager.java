// Programmer name: Santiago Sued.
// I have created this code myself.

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' '; // ASCII Code: 32
	private static final char UPPER_BOUND = '_'; // ASCII Code: 95
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; // 95 - 32 = 64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	// Method to check if a given string is inside the stablished bounds.
	
	public static boolean stringInBounds (String plainText) { 
		boolean inBounds = true;
		
		for(int i = 0 ; i < plainText.length() ; i++) // Will test every character in the string to see if they are inside the bound.
		{
			if(!(plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) < UPPER_BOUND))
				inBounds = false;
		}
		
		return inBounds;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	// Method in charge of executing the caesar encryption. 
	
	public static String encryptCaesar(String plainText, int key) {
		char[] plainTextChars = plainText.toCharArray(); // Converts String to char. array, as they are easier to work with and modify.
		char[] caesarTextChars = new char[plainTextChars.length];
		
		for(int i = 0 ; i < plainTextChars.length ; i++)
		{
			caesarTextChars[i] = (char) (plainTextChars[i] + key); // Adds to every character in the array the value of the key.
			
			while (caesarTextChars[i] < LOWER_BOUND || caesarTextChars[i] > UPPER_BOUND) // While the value of the added char. is outside of the stablished bounds, keep adding the range.
				caesarTextChars[i] += RANGE; // We can keep adding range because char. will eventually overflow and loop back around to 0.
		}

		String caesarText = new String(caesarTextChars); // Convert char. array to string again to return.
		return caesarText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	// Method in charge of executing the bellaso encryption. 
	
	public static String encryptBellaso(String plainText, String bellasoStr) {
		char[] plainTextChars = plainText.toCharArray();
		char[] bellasoTextChars = new char[plainTextChars.length];
		char[] bellasoStrChars = bellasoStr.toCharArray(); // I convert the bellasoStr key to char arrays as well.
		
		for(int i = 0 ; i < plainTextChars.length ; i++)
		{
			if (i < bellasoStrChars.length) 
			{
				bellasoTextChars[i] = (char) (plainTextChars[i] + bellasoStrChars[i]); // Add to every character the value of the character at same index of bellasoStr key.
				while(bellasoTextChars[i] < LOWER_BOUND || bellasoTextChars[i] > UPPER_BOUND)
					bellasoTextChars[i] += RANGE;
			}
			else if (i >= bellasoStrChars.length) // If the bellasoStr key is smaller than the encrypted array, this else if statement executes.
			{
				int times = i / bellasoStrChars.length;
				bellasoTextChars[i] = (char) (plainTextChars[i] + bellasoStrChars[i - (bellasoStrChars.length * times)]);
				while (bellasoTextChars[i] < LOWER_BOUND || bellasoTextChars[i] > UPPER_BOUND)
					bellasoTextChars[i] += RANGE;
			}
		}
			
		String bellasoText = new String(bellasoTextChars);
		return bellasoText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	// The decryptions are very simple. Simply copy paste the above text, except that we subtract the keys instead of adding them.
	
	public static String decryptCaesar(String encryptedText, int key) {
		char[] encryptedTextChars = encryptedText.toCharArray();
		char[] plainTextChars = new char[encryptedTextChars.length];
		
		for(int i = 0; i < encryptedTextChars.length ; i++)
		{
			plainTextChars[i] = (char) (encryptedTextChars[i] - key);
			
			while (plainTextChars[i] < LOWER_BOUND || plainTextChars[i] > UPPER_BOUND)
				plainTextChars[i] += RANGE;
		}

		String plainText = new String(plainTextChars);
		return plainText;
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
		char[] encryptedTextChars = encryptedText.toCharArray();
		char[] plainTextChars = new char[encryptedTextChars.length];
		char[] bellasoStrChars = bellasoStr.toCharArray();
		
		for(int i = 0 ; i < encryptedTextChars.length ; i++)
		{
			if (i < bellasoStrChars.length)
			{
				plainTextChars[i] = (char) (encryptedTextChars[i] - bellasoStrChars[i]);
				while(plainTextChars[i] < LOWER_BOUND || plainTextChars[i] > UPPER_BOUND)
					plainTextChars[i] += RANGE;
			}
			else if (i >= bellasoStrChars.length)
			{
				int times = i / bellasoStrChars.length;
				plainTextChars[i] = (char) (encryptedTextChars[i] - bellasoStrChars[i - (bellasoStrChars.length * times)]);
				while (plainTextChars[i] < LOWER_BOUND || plainTextChars[i] > UPPER_BOUND)
					plainTextChars[i] += RANGE;
			}
		}
			
		String plainText = new String(plainTextChars);
		return plainText;	
	}
}
