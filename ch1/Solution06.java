package ch1;

public class Solution06 {
    
	/**
	 * Q: String Compression:  
	 * Perform basic string compression using the counts of repeated characters. 
	 * For exampe: aabcccccaaa  => a2b1c5a3
	 * If the "compressed" string would not become smaller than original string, your method 
	 * should return the original string. 
	 * All string has only uppercase and lowercase letters(a - z)
	 */
	
	// Record the last chracter's info and occurence 
	// using StringBuilder 
	// Time : O(n)
	// Space: O(n) (StringBuilder)
	public static String compress(String s) {
		if(s == null || s.length() == 0) return s;  // corner cases
		int count = 1;
		char last = s.charAt(0);  // set the last character as the first character
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < s.length(); i ++) {
			char c = s.charAt(i);
			if(c == last) count++;  // if the character does not change continue
			else{
				sb.append(last).append(count);  // if change, append to the result
				last = c;
				count = 1;
			}
		}
		sb.append(last).append(count); // append the last time's case 
		
		if(sb.length() >= s.length()) return s; // If length id larger than orginal one 
		return sb.toString();  
				
	}
	public static void main(String[] args) {
		String[] strs = { "", null, "aabcccccaaa"};
        for(int i = 0; i < strs.length; i++) {
      	  System.out.println(strs[i] + "   : " + compress(strs[i]));
        }
	}
}
