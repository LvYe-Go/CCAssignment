package ch2;

public class Solution05 {
    /**
     * First: 
     * Reverse Order: 
     *  (7 -> 1 -> 6) + (5 -> 9 -> 2) => 2 -> 1 -> 9  
     *  617 + 295 = 912 
     *
     *  Forward Order:
     *  (6 -> 1 -> 7) + (2 -> 9 -> 5) => 9 -> 1 -> 2
     *  617 + 295 = 912
     */
	 // Reverse Order , in place and add carry to the next element
	// Time : O(N)
    // Space: O(1)
	 public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2; 
        if(l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0) {
            if( l1 != null) {   // If have value , add them
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum%10);  // Create the node with mod
            p.next = newNode;
            sum = sum/10; // get the carry for next time 
            p = p.next; // continue 
        }
        return head.next;
    }
	 
  // Follow UP : Forward Order, Recursive Method 
  // Time : O(N)
  // Space: O(N) :  Using recursive, have stack memory 
  private static int ListLength(ListNode head) {  
     int len = 0;  
     while (head != null) {  
       len++; 
       head = head.next;  
     }  
     return len;  
   }  
   
   // The length of l1 >= the length of l2 and n is the difference
   private static int addRecursive(ListNode l1, int n, ListNode l2, ListNode pre) {  
    if (l1 == null && l2 == null) {  
       return 0;  
     }  
     pre.next = new ListNode(0);  
     int sum = l1.val;
     if (n <= 0) {   // If they are reach to the same length.
       sum += l2.val;    // Add the value on the short list.
       sum += addRecursive(l1.next, 0, l2.next, pre.next);  
     } else {     // If at the length l1 > l2, add the value only on the l1;
       sum += addRecursive(l1.next, n-1, l2, pre.next);  
     }  
     
     pre.next.val = sum % 10;  
     return sum / 10;   // return carry
   }  
   
   // Digits in the two lists are in forward order.  
   private static ListNode addTwoNumbersRecur(ListNode l1, ListNode l2) {  
     int n1 = ListLength(l1), n2 = ListLength(l2);  
     ListNode fakehead = new ListNode(-1);  
     if (n1 >= n2) {  
       fakehead.val = addRecursive(l1, n1-n2, l2, fakehead);   // recursive result 
     } else {  
    	 fakehead.val = addRecursive(l2, n2-n1, l1, fakehead);   // recursive result , longer list first 
     }  
     return (fakehead.val > 0) ? fakehead : fakehead.next;   // Judge whether carry to the first element 
   }  
	 
	public static void main(String[] args) {
		System.out.println("Reverse Order \n");
		ListNode l1 = new ListNode(7);
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(6);
		
		l1.next = p1; p1.next = p2; p2.next = null;
		
		ListNode l2 = new ListNode(5);
		ListNode p3 = new ListNode(9);
		ListNode p4 = new ListNode(2);
		
		l2.next = p3; p3.next = p4; p4.next = null;
		ListNode sum = addTwoNumbersReverse(l1, l2);
		ListNode.printListNode(sum);
		
		System.out.println("\n\nForward Order \n");
		ListNode h1 = new ListNode(6);
		ListNode q1 = new ListNode(1);
		ListNode q2 = new ListNode(7);
		
		h1.next = q1; 
		q1.next = q2; 
		q2.next = null;
		
		ListNode h2 = new ListNode(2);
		ListNode q3 = new ListNode(9);
		ListNode q4 = new ListNode(5);
		
		h2.next = q3; 
		q3.next = q4; 
		q4.next = null;
		
		ListNode sum2 = addTwoNumbersRecur(h1, h2);
		ListNode.printListNode(sum2);
	}
}
