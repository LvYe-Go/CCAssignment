package ch1;

public class Solution09 {
	/*
	 * Check if s2 is a rotation of s1 using only one call to isSubstring.
	 * */
	
	// Time : O (N)
	// Space: O(N) (need copy string) 
	private static boolean isRotation(String s1 ,String s2) {
		if(s1 == null || s2 == null) return false; // corner cases 
		int len = s1.length();
		if(len != s2.length() || len == 0) return false; // corner case 
		String combine = s1 + s1;  // combine the head and tail of the string 
		return isSubstring(combine, s2, combine.length(), s2.length());
	}
	
	// SubString is function I impelment for use in question 
	private static boolean isSubstring(String com, String s2, int lenCom, int len) {
		for(int i = 0; i < lenCom - len; i++) {
			if(com.substring(i, i + len).equals(s2)) return true; // If find one match 
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}

}
