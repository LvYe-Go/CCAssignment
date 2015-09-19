package ch4;

import java.util.*;

public class Solution12 {
	// Recursive to gather the sum of the paths count 
	 // It can also record the path from the top to the bottom 
	// Time:  O(NlogN)
	// Space : O(N)
	public static int pathSum(TreeNode root, int target) {
      if(root == null) return 0; // corner case 
      int countRoot = helper(root, target, 0);
      return countRoot + pathSum(root.left, target) + pathSum(root.right, target); // left and right part 
    }
    // The total paths from the node.
    public static int helper(TreeNode root, int target, int curSum){
      if(root == null) return 0; // corner case 
      int count = 0;
      curSum += root.val; // add to current sum 
      if((curSum + root.val == target)) count++; 
      return count + helper(root.left, target, curSum) + helper(root.right, target, curSum);
    }
    
    public static void main(String [] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.left.right = new TreeNode(5);
		System.out.println(pathSum(root, 0));
	}
}
