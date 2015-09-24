package ch10;

public class Solution11 {

	/**
	 * Sort the array by peak and valley .
	 * 
	 * Check by odd or even position. 
	 * If even position, should lower than neighbors, 
	 * otherwise, should higher than neighbors. 
	 * 
	 * Time : O(N) one pass
	 * Space: O(N) no extra 
	 * 
	 */
	
	public static void ValleyPeakSort(int[] nums) {
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(i % 2 == 1 && nums[i] > nums[i-1]){  // odd position 
				swap(i, i -1, nums); // if smaller, swap 
			}else if(i != 0 && i %2 == 0 && nums[i] < nums[i - 1]){  // even position
				swap(i, i-1, nums);  // if larger swap 
			}
		}
		return;
	}
	
	// swap two position value 
	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {5, 6, 1, 2, 3};
		ValleyPeakSort(nums);
        for(int i = 0; i < nums.length; i++) {
        	System.out.println(nums[i]);
        }
	}

}
