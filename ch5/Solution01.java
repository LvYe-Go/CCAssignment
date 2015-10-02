package ch5;

public class Solution01 {
    /**
     * Method: clear the  i bit to j bit in n and or with m
     * @param args
     * Time: o(1)
     * Space: O(1)
     */
	
	public static void main(String[] args) {
		System.out.println("After shift: " + (Integer.toBinaryString(insertBits((1 << 10), 19, 2, 6))));
	}
	
	public static int insertBits(int n, int m, int i, int j){
		int res = ~0;  // all ones
		int leftOnes = res << (j + 1);  // i's left are all ones 
		int rightOnes = ((i<<1) - 1);  // j's right are all ones
		int mask = leftOnes| rightOnes;  // like 111 0000 111 
		
		int n_clear = n & mask; 
		int m_shift = m << i;  // move m to suitable position
		return n_clear | m_shift;
	}

}
