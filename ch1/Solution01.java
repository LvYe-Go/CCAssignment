package ch1;
import java.util.*;


// Requirement: With literate comments and elegant coding(OO Design, Syntax Efficiency, Time/Space Complexity

public class Solution01 {
    
	/*
	 *  Q:Implement an algorithm to determine if a string has all unique characters.
	 *  What if you cannot use additional data structures? 
	 * */

    // Using additional data structure 
	// Time : O(n) 
	// Space: O(n)
	public static boolean isUniqueOne(String str) {
		if(str == null || str.length() == 0) return false; // corner cases
    	Set<Character> set = new HashSet<Character>(); // Use set to detect collsion 
    	int len = str.length();
    	for(int i = 0; i < len; i++) {
    		if(!set.add(str.charAt(i))){ // If cannot be put into the set, collsion happens 
    			return false;
    		}
    	}
    	return true;
	}
	
    // WithOut using additional data structure
	// Time : O(n) 
	// Space: O(1)
	public static boolean isUniqueTwo(String str) {
		if(str == null || str.length() == 0) return false; // corner case
    	boolean[] count = new boolean[256];  // For all of them are ASCII , we can use the 0-256 to record 
    	int len = str.length();
    	for(int i = 0; i < len; i++) {
    	    char c = str.charAt(i);
    		if(count[c]) return false;
    		count[c] = true;
    	}
    	return true;
	}
	
	//Improvement using bit shift 
	// Time : O(n) 
	// Space: O(1)
	public static boolean isUniqueThree(String str) {
		if(str == null || str.length() == 0) return false; // corner case
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) return false; // Use bit to record whetehr some number has collsion 
			checker |= (1 << val); 
		}
		return true;
	}
	
	
	public static void main(String[] args) {
          String[] strs = { "", null, "abcdefghja", "abcdef", "aa"};
          for(int i = 0; i < strs.length; i++) {
        	  System.out.println(strs[i] + "   : " + isUniqueTwo(strs[i]));
          }
	}
}
