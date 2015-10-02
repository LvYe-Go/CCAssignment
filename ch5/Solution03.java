package ch5;

import java.util.*;

public class Solution03 {
	static int SEQ_LENGTH = 32;
	/**
	 * Method: One pass to get the continuous 0 or 1 's number and
	 *         Merge them according to different situation.
	 * @param args
	 * Time: O(b) b = bits number 
	 * Space: O(b)
	 */
	public static void main(String[] args) {
		System.out.println(longestSeq(1775));
	}
	
	// Select the longest 
	public static int longestSeq(int n){
		if(n == -1) return SEQ_LENGTH;
		List<Integer> seqList = getSeq(n);
		return findLongestSeq(seqList);
	}
	
	/**
	 * Get the number for continuous 1 or 0
	 * @param n
	 * @return
	 */
	
	public static List<Integer> getSeq(int n){
		List<Integer> list = new ArrayList<Integer>();
		int last = 0;
		int counter = 0;
		for(int i = 0; i < SEQ_LENGTH; i++){
			if((n & 1) != last){  // get the bit value 
				list.add(counter);
				last = n & 1; // o flip to 1, 1 flip to 0
				counter = 0;
			}
			counter++; // counter the number 
			n >>>= 1;
		}
		list.add(counter);
		return list;
	}
	
	/**
	 * Merge adjacent sequences
	 * @param seqList
	 * @return
	 */
	public static int findLongestSeq(List<Integer> seqList){
		int max = 1;
		for(int i = 0; i < seqList.size(); i+= 2){
			int zeroSeq = seqList.get(i);
			int right = i - 1 >= 0 ? seqList.get(i-1):0;
			int left = i + 1 < seqList.size()? seqList.get(i + 1):0;
			
			int cur  = 0;
			if(zeroSeq == 1){  // if has one zero interval, merge !
				cur = left + right + 1;
			}else if(zeroSeq > 1){  // if oever one zero interval, select right or left
				cur = 1 + Math.max(left, right);
			}else if(zeroSeq == 0){
				cur = Math.max(left, right); 
			}
			 
			max = Math.max(cur, max); //select the maximum
		}
		return max;
	}
}
