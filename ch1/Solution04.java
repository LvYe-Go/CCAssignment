package ch1;

import java.util.HashMap;

public class Solution04 {
	
	/**
	 * Q: Given a string, write a function to check if it is a permutation of 
	 * a palindrome
	 */
	
	// I implement in two methods 
	
	// Method - 1 
	// Use the map to count the occurence of them 
	// Time:  O(n)
	// Spaace: O(n)
	public static boolean isPerPalOne(String str) {
		if(str == null) return false;
		str = str.toLowerCase(); // lowcase all 
		int len = str.length();
		if(len == 0 || len == 1) return true; // Spcial case 
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if(c == ' ') continue;
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1); // If have in map, count ++ 
			}else{
				map.put(c, 1); // If not , put into the map
			}
		}
		
		int oddCount = 0;
		for (Integer value: map.values()) {  
		    if(value % 2 == 1) oddCount++; // The count for odd  must less or equal to one
		}  
		return oddCount <= 1;
	}
	
	// Method - 2
	// Remove the item on map, if meet the other same item
	// Time: O(n)
	// Space: O(n)
	public static boolean isPerPalTwo(String s) {
	     if(s == null) return false; // corner case 
	     s = s.toLowerCase();
		 HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	        for (int i = 0; i < s.length(); i++){
	        if(s.charAt(i) == ' ') continue;
	        if (map.containsKey(s.charAt(i))) {
	            map.remove(s.charAt(i)); // remove it 
	        }else{
	            map.put(s.charAt(i), 1);
	            }
	       }
	       return map.size() <= 1;  // The left item in map should less than two.
	}
	
	
	public static void main(String[] args) {
		String[] strs = {"Tact Coa", "aaabbb", "abb"};
        for(int i = 0; i < strs.length; i++) {
      	  System.out.println(strs[i] + "   : " + isPerPalTwo(strs[i]));
        }
	}
}
