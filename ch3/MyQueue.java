package ch3;

import java.util.Stack;

public class MyQueue {
	/* 
	 * Implement a MyQueue class with implements a queue using two stacks. 
	 * */
	 Stack<Integer> stack1 = new Stack<Integer>();
	 Stack<Integer> stack2 = new Stack<Integer>();
	 
	 /***
	  * 
	  * My Method: 
	  * 1. Use two  stacks 
	  * 2. push into general stack
	  * 3. pop into temp stack before return the value , reverse the order 
	  * 4. same path for peek 
	  * 
	  */
	 /**
	  *  Time : operations in O(1)
	  *  Space : O(N)
	  */
	 
	 public void push(int x) {
		 stack1.push(x);
	 }
	 
	 public void pop(){
		 if(!stack2.isEmpty()){ // if the first element 
			stack2.pop();
			return;
		 }
		 while(!stack1.isEmpty()){   // push into the stack1 first 
			 stack2.push(stack1.pop());
		 }
		 stack2.pop();
	 }
	 
	 public int peek() {
		 if(!stack2.isEmpty()){  // same path to pop
				return stack2.peek();
			 }
			 while(!stack1.isEmpty()){
				 stack2.push(stack1.pop());
			 }
			return  stack2.peek();
	 }
	 
	 public boolean isEmpty() {
		 return stack1.isEmpty() && stack2.isEmpty(); // if both empty 
	 }
}
