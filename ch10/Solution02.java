package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution02 {

	/**
	 * 
	 * MergeSort:  Two sorted array A, B. A has a large enough buffer at the end to hold B. 
	 * Merge B into A in sorted order. 
	 */
	
	/**
	 *  Setup the map to record the anagrams pair 
	 *  Key is : sorted anagram 
	 *  Value: List to contian words with same anagram
	 *  Time: O(N)
	 *  Space: O(N)
	 */
	
	public static List<String> sort(String[] strs){
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		int len = strs.length;
		for(int i = 0; i < len ; i++) {
			String str = strs[i];
			char[] ca = str.toCharArray();
			Arrays.sort(ca);   // sort String to get anagram
			String word = String.valueOf(ca);
			if(!map.containsKey(word)) { // If map has the pair, put the one into coresponding list
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(str, list);
			}else{
				List<String> list = map.get(word); // If map does not contains word,  put new pair into it. 
				list.add(str);   
				map.put(word, list);
			}
		}
		
		List<String> res = new ArrayList<String>();
		
		for(List<String> list: map.values()) {
			for(String str: list){  // Add them into one list 
				res.add(str);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] strs = {"abc", "sss", "cba", "ss", "bob", "bob", "dede", "acb"};
		List<String> list= sort(strs);
		for(String str : list) {
			System.out.println(str);
		}
	}

}
