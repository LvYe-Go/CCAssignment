package ch5;

public class Solution07 {
	
	 /**
	  * Bit AND usage: &0xaaaa => get even   &0x5555 => get odd 
	  *                Then shift to right place 
	  * @param x
	  * @return
	  * Time: O(1)
	  * Space: O(1)
	  */
     public static int swapEvenOdd(int x){
    	 return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
     }
     
     public static void main(String[] args) {
 		int a = 10;
 		System.out.println("swap even odd bits  :" + swapEvenOdd(a));
 	}
}
