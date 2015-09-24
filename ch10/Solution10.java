package ch10;

public class Solution10 {

	/*
	 * Implement data structure to show track() and getRank function 
	 * in stream of Integers.
	 */
	
	/**
	 * 
	 * (Refer to the book
	 * Please refer to RankNode class
	 * Time : O(NlogN)
	 * Space: O(N)
	 */
	
	public static void track(int num, RankNode root) {
		if(root == null){
			root = new RankNode(num);  // corner cases
		}else {
			root.insert(num); // insert to BST 
		}
	}
	
	public static int getRankOfNumber(int num, RankNode root) {
		return root.getRank(num);   // get rank 
	}
	public static void main(String[] args) {
		RankNode root = new RankNode(5);
		int[] num = {1, 4, 4, 5, 9 ,7, 13, 3};
		for(int i= 0; i < num.length; i++){
			track(num[i], root);
		}
		int target = 1;
		
		System.out.println(getRankOfNumber(target, root));

	}

}
