package ch5;

public class Solution04 {

	/**
	 * @param args
	 * Time:  O(b)
	 * Space: O(1) in place 
	 */
	public static void main(String[] args) {
		int num = 4;
		System.out.println("getNext :" + getNext(num));
		System.out.println("getPrev :" + getPrev(num));
	}
	
	public static int getNext(int n) {
		int c= n;
		int c0 = 0, c1 = 0;
		// count the number of 0 
		while((c & 1) == 0 && (c != 0)){
			c0++;
			c >>= 1;
		}
		
		// count the number of 1 
		while((c & 1) == 1){
			c1++;
			c >>= 1;
		}
		
		// if sequenced of 0 followed by sequence of 1s, already the biggest number for 32 bit
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		int p = c0 + c1; // position of right-most non-trailing zero 
		
		n |= (1 << p);   // Flip right-most non-trailing zero
		n &= ~((1 << p) - 1); //Keep the left continuous ones and  clear all bits to the right of pos
		n |= (1 << (c1  -1)) - 1; 
		return n;
	}
	
	public static int getPrev(int n){
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		// count the number of 1 
		while((temp & 1) == 1){
			c1++;
			temp >>= 1;
		}
		// count the number of 0 
		if(temp == 0) return -1;
		
		while(((temp & 1) == 0) && (temp != 0)){
			c0++;
			temp >>= 1;
		}
		
		int p = c0 + c1; // find the non-trailing zero position 
		n &= ((~0) << (p + 1));
		
		int mask = (1 << (c1 + 1)) - 1; // Sequence of (c1+1) ones
		n |= mask << (c0 -1); 
		return n;
	}

}
