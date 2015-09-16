package ch1;

import java.util.Arrays;

public class Solution05 {

	/*
	 *  Q: Three types of edits that can be performed on strings: 
	 *  1. insert a character
	 *  2. remove a character
	 *  3. replace a character.
	 *  GIven two strings, write a function to check if they are one edit(or zero edits) away.
	 *  
	 *  Example: 
	 *  pale, ple -> true
	 *  palse, pale -> true
	 *  pale, bale -> true
	 *  pale, bake -> false
	 * */

	// Take delete and insert as one operation, always insert to the short one 
	// Time: O(n)
	// Space: O(1)
	public static boolean isOneEditDistance(String s, String t) {
        if(s == null && t == null) return true;// Rule out special case
        
        int lenS = s.length();
        int lenT = t.length();
        if(lenS == 0 && lenT == 0) return false;// Rule out special case
        if(Math.abs(lenS - lenT) > 1) return false;  // Rule out special case
        if(lenS == lenT) {
            if(s.equals(t)) return true; // Return special case
            else return isOne(s, t, lenS);  // One need change 
        }
        
        if(lenS < lenT) {  // swap the String and the length of them
            String temp = s; int tem = lenS;
            s = t; lenS = lenT;
            t = temp; lenT = tem;
        }
        if(lenS == 1 && lenT == 0) return true;
        
        return isOneAdd(s, t, lenS, lenT); // One need add to the short one 
    }
    
    private static boolean isOne(String s, String t, int len) {
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) != t.charAt(i)) count++; 
        }
        return count <= 1;  // Just one or zero couldbe different 
    }
    
    private static boolean isOneAdd(String s, String t, int lenS, int lenT){
        int count = 0;
        int i = 0, j = 0; 
        while(i < lenS && j < lenT) {
            if(s.charAt(i) != t.charAt(j)) {
                count++;  // If difference happens, count++
                i++;
                continue;
            }
            i++;   // continue iterate
            j++;
        }
        return count <= 1; // Just one or less can be different 
    }
	
	public static void main(String[] args) {
          String[][] strs = {{"pale", "ple" }, {"palse", "pale"} , {"pale", "bale"}, {"pale", "bake"}};
          for(int i = 0; i < strs.length; i++) {
        	  System.out.println(isOneEditDistance(strs[i][0], strs[i][1]));
          }
	}

}
