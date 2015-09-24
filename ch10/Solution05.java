package ch10;

public class Solution05 {

	/**
	 * 
	 * Sorted string array with space, find a certain empty string。
	 * Method: Binary Search , check the terminates is empty or not 
	 *         pay attention to pointer move. 
	 *         
	 *  Time : O(LogN) binary Search
	 *  Space: O(N)
	 */
	
	public static int search(String[] strs, String str){
		if(strs == null || strs.length == 0 || str == "") {
			return -1;
		}
		int left = 0;
		int len = strs.length;
		while(left < len && strs[left].isEmpty()) {
			left++; // find the first non - empty 
		}
		int right = len - 1;
		while(right >= 0 && strs[right].isEmpty()) {
			right--; // find the last non - empty 
		}
		return BS(strs, left, right,str);
	}
	
	
	public static int BS(String[] strs, int left, int right, String str) {
		while(left <= right) {  // binary search 
			if(strs[left].equals(str)) return left;
			if(strs[right].equals(str)) return right;
			
			int mid = left + (right - left)/2; // avoid overflow
			
			while(strs[mid].isEmpty()) {
				mid++;  // find the element non-empty
			}

			if(strs[mid].equals(str)) return mid;
			if(strs[mid].compareTo(str) < 0) {
				mid = mid + 1;
				while(strs[mid].isEmpty()) {
					mid++;     // find the post element non-empty
				}
				left = mid;
			}else if(strs[mid].compareTo(str) > 0) {
				mid = mid - 1;
				while(strs[mid].isEmpty()){
					mid--;  // find the pre element non-empty
				}
				right = mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String str = "car";
		System.out.println(search(strs, str));

	}

}
