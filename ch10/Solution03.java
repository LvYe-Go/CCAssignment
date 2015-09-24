package ch10;

public class Solution03 {
	/**
	 * 
	 * Search in rotated array. 
	 * Method: Binary Search but with different check on middle 
	 * Time : O(logN)
	 * Space: In place, O (1)
	 */
	
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		int len = nums.length;
		int left = 0 , right = len  -1;
		while(left <=right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target) return mid;
			if(nums[mid] <= nums[right]) { // In this case, the range is ascending 
				if(target > nums[mid] && target <= nums[right]){  // Check whether in range 
					left = mid + 1;   // move the pointer 
				}else{
					right = mid - 1;
				}
			}else if(nums[mid] >= nums[left]) {// In this case, the range is decreasing 
				if(target < nums[mid] && target >= nums[left]) { // Check whether in range 
					right = mid - 1; // move the pointer 
				}else{
					left = mid + 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		 int[] nums = {15,16,19,20,25,1,3,4,5,7,10,14};
		 System.out.println(search(nums, 5));
	}

}
