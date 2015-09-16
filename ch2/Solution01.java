package ch2;

import java.util.HashSet;
import java.util.Set;

public class Solution01 {
    /**
     * 
     * Remove duplicates from an unsorted linked list
     * Method - 1 Set 
     * Method - 2 Temporary buffer is not allowed
     */
	
	// Method - 1 : Use set to store 
	// Time: O(N)
	// Space: O(N)
	public static ListNode deleteDupOne(ListNode head) {
		Set<Integer> set = new HashSet<Integer>();
		ListNode cur = head;
		ListNode pre = null;
		
		while(cur != null) {
			if(set.contains(cur.val)){ // using set to store 
				pre.next = cur.next;
			}else{
				set.add(cur.val);  // If set does not contain, put it in 
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	// Method -2  
	// Time: O(N ^ 2) : two Pointers 
	// Space: O(1)
	public static ListNode deleteDupTwo(ListNode head) {
		if(head == null) return null;
		ListNode cur = head;
		
		while(cur != null) {
			ListNode p = cur; 
			while(p.next != null) {  // search from the next of the current 
				if(p.next.val == cur.val){
					ListNode Next = p.next;
					p.next = p.next.next;  // update the next pointer 
					p = Next;
				}else{
					p = p.next; // continue
				}
			}
			cur = cur.next; // continue
		}
		
		return head;
	}
	public static void main(String[] args) {
		ListNode head = genListNode();
		head =  deleteDupTwo(head);
		ListNode.printListNode(head);
	}
	
	private static ListNode genListNode(){
		ListNode head = new ListNode(1);
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(2);
		ListNode p4 = new ListNode(1);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(5);
		ListNode p7 = new ListNode(6);
		
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		return head;
	}
}
