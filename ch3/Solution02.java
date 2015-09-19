package ch3;

import ch2.ListNode;

public class Solution02 {
	
	/**
     * Q: Min Stack 
     *    Push, Pop, Min operate in O(1)
     */
	
	// Method - 1 : Use set to store 
	// Time: O(N)
	// Space: O(N)
	public static void main(String[] args) {
		MinStack minstack = new MinStack(); // See my minStack class
		minstack.push(1);
		minstack.push(4);
		minstack.push(8);
		System.out.println(minstack.getMin());
	}
}