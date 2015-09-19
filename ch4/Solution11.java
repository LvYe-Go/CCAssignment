package ch4;

import java.util.List;
import java.util.Random;

public class Solution11 {
	/*
	 * A binary tree with :
	 * Insert , find , delete , has getRandomNode() return random node of the tree
	 */
	// Time :  O(N)
	// Space:  O(N)
	public static void main(String [] args) {
		int[] nums = {1, 2, 3, 0, 5, 6, 12, 8, 9, 10};
		TreeNode root = Solution03.createTree(nums);  // Create tree
        List<List<TreeNode>> res =  Solution03.createDepthLinkedList(root); // Reture list result 
		Random random = new Random();
	    int K = random.nextInt(root.size()); // Get the random number 
	    System.out.println(getKthNode(root, K));
	}
	

	public static TreeNode getKthNode(TreeNode root, int K) {
		TreeNode left = root.left;
		TreeNode right = root.right;
		int leftSize = 0;  // corner case 
		if(left == null) {
			leftSize = 0;
		}else{
			leftSize = left.size();
		}
		
		if(K < leftSize) {
			return getKthNode(left, K); // in the left part
		} else if(K == leftSize) {
			return root;
		} else {
			return getKthNode(left, K - (leftSize + 1)); // in the right part 
		}
	}
}
