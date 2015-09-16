package ch1;
import java.util.*;


// Requirement: With literate comments and elegant coding(OO Design, Syntax Efficiency, Time/Space Complexity

public class Solution02 {
    
	/*
	 *  Q:Check Permutation: Given two strings, write a method to decide if one is a
	 *     permutation of the other
	 * */

    // Using additional data structure 
	// Time : O(nlog(n)) (sort) + O(n) = O(nlogn)
	// Space: O (n)
	public static boolean isPer(String str1, String str2) {
		if((str1 == null && str2 == null)) return true;  // corner cases
		if(str1 == null || str2 == null) return false;
		
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2) return false; // return if they do have smae length, corner cases
		
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);  // Use Java API to sort char array 
		Arrays.sort(charArray2);
		
		for(int i = 0; i < len1 ; i++) {
			if(charArray1[i] != charArray2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
          String[][] strs = {{"cd","c" }, {"abcdef", "fedcab"} , {"abcd", "abcc"}};
          for(int i = 0; i < strs.length; i++) {
        	  System.out.println(isPer(strs[i][0], strs[i][1]));
          }
	}
}
