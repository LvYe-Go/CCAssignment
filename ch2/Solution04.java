package ch2;

public class Solution04 {
	
	/*
	 *  Given a linked list and a value x, 
	 *  partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * */
	public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode p = l1;  
        ListNode q = l2; // l2 store the element bigger than x 
        
        p.next = head;
        while(p.next != null) {
            if(p.next.val >= x) {
                ListNode Next = p.next;  // delete from l1 
                p.next = p.next.next;
                
                q.next = Next; // add to the l2 
                q = q.next;
            }else{
                p = p.next;  // If element <= x, keep it in the list
            }
        }
        q.next = null;
        p.next = l2.next;  // combine the two part , put bigger list on the behind 
        return l1.next; 
    }
	
	public static void main(String[] args) {
		ListNode head = genListNode();
		partition(head, 5);
		ListNode.printListNode(head);
	}
	
	private static ListNode genListNode(){
		ListNode head = new ListNode(3);
		ListNode p1 = new ListNode(5);
		ListNode p2 = new ListNode(8);
		ListNode p3 = new ListNode(5);
		ListNode p4 = new ListNode(10);
		ListNode p5 = new ListNode(2);
		ListNode p6 = new ListNode(1);
		
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		return head;
	}
}
