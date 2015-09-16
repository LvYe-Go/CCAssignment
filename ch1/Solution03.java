package ch1;

public class Solution03 {
   
	/**
	 * Q: To replace all spaces in a string with 20%. The string has
	 *  sufficient space at the end to hold the additional characters.
	 */
	
	// Array Move attention 
	// Time: O(n);
	// Space: O(n)
	public static void URL(char[] str, int length) {
		if(str == null || length == 0) return ; // corner cases
		int count = 0, newLength, i;
		for(i = 0; i < length; i++) {  // Calcaulate the count of space 
			if(str[i] == ' ')
				count++;
		}
		newLength = length + count * 2; // Calculate the totalLength at the end
		str[newLength] = '\0';  // Important to put the '\0' in char array 
		
		for(i = length - 1; i >= 0 ;i--) {  // Move from the end to the start
			if(str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			}else{
				str[newLength - 1] = str[i]; // Also, move from the end to the start
				newLength--;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith          ";
		char[] charArray = str.toCharArray();
		URL(charArray, 13);
		for(int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		System.out.print("\n");
	}

}
