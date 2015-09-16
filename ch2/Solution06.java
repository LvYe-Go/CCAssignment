package ch2;

import java.util.Stack;

public class Solution06 {

	 /**
	  * Q: Check if a linked list is a palindrome
	  */
	 // Time : O(N)
	// Space : O(N) : stack used 
	public static boolean isPal(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>(); // Use stack to store the first half element 
		ListNode slow = head, fast = head;
		while(fast != null && fast.next!= null){ //  Slow get to the half point of the list 
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null) slow = slow.next; // Use fast position to determine whether 
		                                  // the node is even or odd
		while(slow != null) {
			if(!stack.isEmpty() && slow.val != stack.pop()) { 
				return false; // compare the second half with the value in stack(fist half)
			}
			slow = slow.next; // continue 
		}
		return true;
	}
	public static void main(String[] args) {
		ListNode head = genListNode();
		System.out.println(isPal(head));
	}
	
	private static ListNode genListNode(){
		ListNode head = new ListNode(3);
		ListNode p1 = new ListNode(5);
		ListNode p2 = new ListNode(8);
		ListNode p3 = new ListNode(9);
		ListNode p4 = new ListNode(8);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(3);
		
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		return head;
	}
}
