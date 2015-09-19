package ch3;

import java.util.Stack;

public class Solution05 {

	/*
	 * Q : Sort Stack 
	 *    Time : O(N ^ 2);
	 *    Space: O(N)
	 * */
	
	//My Method : 
	// insert sort in stack , insert the element to another stack in the place it should be at 
	
	public static Stack<Integer> sort(Stack<Integer> stack) {
		
		// Actually, like insert sort 
		
		if(stack.isEmpty()) return null; // corner case
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			while(!stack2.isEmpty() && stack2.peek() < temp) {
				stack.push(stack2.pop());  // find the suitable place to push in the element 
			}
			stack2.push(temp);
		}
		return stack2;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(5);
		
		Stack<Integer> st = sort(stack);
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}

	}

}
