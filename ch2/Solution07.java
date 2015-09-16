package ch2;

public class Solution07 {
   
	/*Determine  the two linkedlist isintersect or not 
	 * Return the intersecting node
	 * */
	
	public static ListNode findInter(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) return null;
		int len1 = ListLength(l1);
		int len2 = ListLength(l2);
		int diff = 0;
		ListNode p = null;
		
		if(len1 > len2){
			diff =len1 - len2;
			for(int i = 1; i <= diff; i++) {
				l1 = l1.next;
			}
		}else if(len1 < len2){
		    diff = len2 - len1;
		    for(int i = 1; i <= diff; i++) {
				l2 = l2.next;
			}
		}
		
		while(l1 != l2) {
			l1 = l1.next;
			l2 =l2.next;
		}
		return l1;
	}
	
	private static int ListLength(ListNode head) {  
     int len = 0;  
     while (head != null) {  
       len++; 
       head = head.next;  
     }  
     return len;  
   }  
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(6);
		ListNode p3 = new ListNode(5);
		
		l1.next = p1; p1.next = p2; 
		
		ListNode inter = new ListNode(10);
		p2.next = inter; inter.next = p3;
		
		
		ListNode l2 = new ListNode(5);
		ListNode p4 = new ListNode(9);
		ListNode p5 = new ListNode(2);
		
		l2.next = p4; p4.next = p5; 
		p5.next = inter;
		
		System.out.println("Intersected Node is : " + findInter(l1, l2).val);
	}

}
