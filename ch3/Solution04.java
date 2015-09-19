package ch3;

public class Solution04 {

	/* Implement a MyQueue class with implements a queue using two stacks. 
	 * */
	 /**
	  *  Time : O(1)
	  *  Space : O(N)
	  */
	public static void main(String[] args) {
		MyQueue myqueue = new MyQueue();  // please referred to my MyQueue Class
		myqueue.push(1);
		myqueue.push(2);
		myqueue.push(4);
		myqueue.pop();  // should be 2, 4 left 
		System.out.println(myqueue.peek()); 
		System.out.println(myqueue.isEmpty()); 
	}
}
