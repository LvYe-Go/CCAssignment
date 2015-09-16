package ch2;

public class ListNode { 
	
	// ListNode class for use 
	int val;
	ListNode next;
	ListNode(int x) {val = x ; }
	
	public static void printListNode(ListNode head) {
		if(head == null) return;
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + "-> ");
			cur = cur.next;
		}
		System.out.println();
	}
}
