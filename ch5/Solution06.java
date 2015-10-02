package ch5;

public class Solution06 {
	/**
	 * Use bit feature, same value xor is 0, different is 1
	 * @param args
	 * Time : O(b)
	 * Space: O(1)
	 */
	public static void main(String[] args) {
		int a = 29, b = 15;
		System.out.println("Bits to flip :" + bitSwapRequired(a, b));
	}
	
	public static int bitSwapRequired(int a, int b) {
	       int count = 0;
	       int c = a ^ b; // if they have same bit, it is one , otherwise it is 0
	       if(c < 0) {  // for negative value 
	           count++;
	           c ^= Integer.MIN_VALUE;
	       }
	       while(c > 0){  //count the one of the 
	           count += (c & 1);  //count increase if see the c's bit is 1 
	           c >>= 1;    // c shift to the right bit 
	       }
	       return count;
	  }
}
