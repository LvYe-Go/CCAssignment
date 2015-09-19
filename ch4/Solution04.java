package ch4;

import java.util.List;

public class Solution04 {
	
	/*
	 * Check whether the tree is balanced or not 
	 * */
	// Recursive Check the depth of the tree 
	// Time: O(NlogN)
	// Space: O(N)
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true; // corner case 
        if(root.left == null && root.right == null) return true; // corner case
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) & isBalanced(root.right);  // left and right both balanced , return true 
    }
    
    public static int maxDepth(TreeNode root) { // get the depth of the tree
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1; 
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = Solution03.createTree(nums);  // Create tree
        List<List<TreeNode>> res =  Solution03.createDepthLinkedList(root); // Reture list result 
		System.out.println("Is balanced? " + isBalanced(root));
	}
}