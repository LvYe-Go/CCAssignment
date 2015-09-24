package ch10;

public class Solution08 {
	/**
	 *  Have numbers from 1 to N, N is at most 32,000
	 *  Have 4K memory, how to print the duplicate elements in the array
	 */
	
	/**
	 * 
	 * Refer to the BitSet class
	 * Use bit to map to one integer in the array 
	 * 
	 * Time:  O(N) iterate 
	 * Space: O(N/8)  bitmap
	 */
   
	public static void checkDup(int[] nums) {
		BitSet bs = new BitSet(32000);
		for(int i= 0; i < nums.length; i++){
			int num = nums[i];
			int num0 = num - 1;  // num start from 0
			if(bs.get(num0)){  // if exists just get 
				System.out.println(num); 
			}else{  // if not exist , put it in 
				bs.set(num0);
			}
		}
	}
	public static void main(String[] args) {
		int nums[] = {34, 32000, 1, 4, 5, 2000, 2000};
		checkDup(nums);
	}

}
