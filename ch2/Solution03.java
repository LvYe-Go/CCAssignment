package ch2;

public class Solution03 {
	 /**
     * Q: To delete a node in the middle of a singly linked list.
     *    Given only access to that node.
     */
	
	// Method, just copy the next one val to current node 
	// Update the link. Delete the second same value 
	// Time : O(1)
	// Space: O(1)
	public static void deleteNode(ListNode Node) {
		if(Node == null || Node.next == null) return;
		ListNode Next = Node.next;  // Store the orginal pointer
		Node.val = Next.val; // copy the value 
		Node.next = Next.next; //Update the pointer , delete the copy (same with the node )
	}
	public static void main(String[] args) {
		ListNode head = genListNode();
		ListNode cur = head;
		int val = 1; // value to be deleted
		while(cur.val != val) {
			cur = cur.next;
		}
		deleteNode(cur);
		ListNode.printListNode(head);
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
