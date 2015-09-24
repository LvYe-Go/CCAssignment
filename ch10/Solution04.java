package ch10;

import java.util.ArrayList;
import java.util.List;

public class Solution04 {

	/**
	 * 
	 * elementAt() API , to find value index , 
	 * I change the format of the API  to list, and function 
	 * 
	 */
	// Use list to mock Listy here
	/**
	 *  Search the range and binary search to find the value. 
	 *  But pay attention to the -1 case, rule out it 
	 *  Time: O(N + logN)
	 *  Space: O(N) need list
	 */
	public static int search(List<Integer> list, int value) {
		int index = 1;
		while(elementAt(list, index) != -1 && elementAt(list, index) < value) {
			index *= 2; // Find the search range
		}
		return BS(list, value, index/2, index); // Binary search in given range 
	}
	
	public static int BS(List<Integer> list, int value, int left, int right) {
		int mid = 0; 
		while(left < right){
			mid = left + (right - left) /2;
			int middle = elementAt(list, mid);
			if(middle > value || middle == -1) {  // pay attention to corner cases 
				right = mid - 1;
			}else if(middle < value) {
				left = mid + 1;  // move pointer 
			}else {
				return mid;
			}
		}
		return -1;  // if not found 
	}
	
	public static int elementAt(List<Integer> list, int index) {
		return list.get(index);
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i < 10; i ++){
			list.add(i);
		}
		System.out.println(search(list, 5));
	}

}
