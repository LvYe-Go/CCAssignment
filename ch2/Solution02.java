package ch2;

public class Solution02 {
    /**
     * Q: To find the kth to last element of singly linked list. 
     */
	// Two pointer 
	// fast pointer run K length, then slow run form the head 
	// When fast stop,  current node pointer is the answer 
	// Time : O (N)
	// Space: O(1)
	public static int KthLast(ListNode head, int k) {
		if(head == null || k < 0) return -1;
		ListNode cur = head;
		ListNode fast = head;
		for(int i = 1; i <= k ;i++){
			if(fast == null) return -1; // If found null, no item match requirement , reutrn -1
			fast = fast.next;
		}
	    while(fast != null) {  //  Two pointers run at the same time 
	    	fast = fast.next;
	    	cur = cur.next;		
	    }
	    return cur.val;  // When fast stop,  current node is the place 
	}
	public static void main(String[] args) {
		ListNode head = genListNode();
		System.out.println(KthLast(head, 4));
	}
	
	private static ListNode genListNode(){
		ListNode head = new ListNode(1);
		ListNode p1 = new ListNode(2);
		ListNode p2 = new ListNode(3);
		ListNode p3 = new ListNode(4);
		ListNode p4 = new ListNode(5);
		ListNode p5 = new ListNode(6);
		ListNode p6 = new ListNode(7);
		ListNode p7 = new ListNode(8);
		
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
