package ch4;

import java.util.List;

public class Solution05 {
	/*
	 * Check the tree is BST  or not 
	 */
	
	// Use the max and min value to limit the range and check 
	// Time : O(nlogN)
	// Space : O(N)
	 public static boolean isValidBST(TreeNode root) {
	        if(root == null) return true;
	        Integer min = null;  // Set the max and min value to restrcit 
	        Integer max = null;
	        return check(root, min, max);
	    }
    
    public static boolean check(TreeNode root, Integer min, Integer max) {
        if(root == null) return true; // corner case 
        if((min != null && root.val <= min)|| ( max != null && root.val >= max))
        		return false;  // if the val is not in the range 
        return check(root.left, min, root.val) && check(root.right, root.val, max);
        // check both side 
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 2, 3, 0, 5, 6, 12, 8, 9, 10};
		TreeNode root = Solution03.createTree(nums);  // Create tree
        List<List<TreeNode>> res =  Solution03.createDepthLinkedList(root); // Reture list result 
		System.out.println("Is BST? " + isValidBST(root));
	}
}
