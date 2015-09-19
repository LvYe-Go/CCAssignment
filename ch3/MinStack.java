package ch3;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	/**
     * Q: Min Stack 
     *    Push, Pop, Min operate in O(1)
     *  
     */
	/**
	 * 
	 * My Method: Two stacks, one keep the minimum vlue of the stack
	 * Time : O(1)
	 * Space: O(N)
	 */
	
	public void push(int x){
		stack.push(x);  // always push into general stack 
		if(minStack.isEmpty()) { 
			minStack.push(x);
		}else if(x <= minStack.peek()) { // update the top on minStack
			minStack.push(x);
		}
	}
	public void pop() {
		int element = stack.pop();
		if(minStack.peek() == element) {
			minStack.pop();
		}
	}
	
	public int peek(){
		return stack.peek();
	}
	
	public int getMin(){
		return minStack.peek();
	}
}
