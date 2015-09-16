package ch2;

public class Solution08 {
    /*
     * Find the node at the beginning of the loop in circular linked list.
     */
	 
	// Method: Frist determine whether there is a loop happens
	// Then, obtain the loop size 
	// Fast node run a loopsize ahead of slow 
	// When they meet again , there is the cycle node start 
	// Time :  O (n)
	// Space:  O (1)
	public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {  // Found Loop
                fast = fast.next;
                int loopSize = 1;
                while(fast != slow) {  // Get the loop size 
                    fast = fast.next;
                    loopSize++;
                }
                fast = head;
                for(int i = 1; i <= loopSize; i++) {
                    fast = fast.next;  // Fast node go loopsize first 
                } 
                slow = head;
                while(fast != slow) {  // slow run from head at the same speed
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // When they meet again, fast must be run over a loop over slow pointer 
            }
        }
        return null;
    }

	public static void main(String[] args) {
		ListNode head = genListNode();
		System.out.println(detectCycle(head).val);
	}
	
	private static ListNode genListNode(){
		ListNode head = new ListNode(1);
		ListNode p1 = new ListNode(3);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(4);
		ListNode p4 = new ListNode(5);
		ListNode p5 = new ListNode(7);
		ListNode p6 = new ListNode(2);
		
		head.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p2;
		return head;
	}

}
