package ch4;

public class Solution02 {
	/**
	 * 
	 * Q:   Crete BST using sort array 
	 */
    // Binary Search Method. To Search from the middle of  array. 
	// That will have equal or difference as one node to each side. 
	// Time:  O(nlogn);
	// Space:  O(n)
	
	public static TreeNode create(int[] num, int left, int right) {
		if(num == null || num.length == 0) return null;  // corner cases 
		if(left > right || right > num.length || left < 0 ) return null; // corner cases 
		int mid = left + (right - left)/2;  // get the mid idnex 
		TreeNode root = new TreeNode(num[mid]);
		root.left = create(num, left, mid -1);  // Left range 
		root.right = create(num, mid + 1, right);  // right Rnage 
	    return root;
		
	}
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7,8};
		TreeNode root = new TreeNode(-1);
		int left = 0, right = num.length - 1;
		root = create(num, left, right); 
		printTree(root);
		
	}
	
	public static void printTree(TreeNode root) {
		if(root == null) return;
		System.out.println(root.val);  // Preorder Travel to etst 
		printTree(root.left);
		printTree(root.right);
	}

}
