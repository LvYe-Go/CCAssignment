package ch4;

import java.util.List;

public class Solution06 {
	/*
	 * Get the "Next" node for given node , (inorder ) in BST 
	 */
	// Seperate the condition to define 
	// Time :  O(N)
	// Space : O(logN)
    public static TreeNode inorderNext(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null)) return null; // corner case 
    	if(root.right != null) return mostLeft(root.right); // corner case 
    	TreeNode temp = root; 
    	TreeNode p = root.parent; 
    	
    	while(p != null && p.right == temp) { // Find when it is not the right of its parent 
    		temp = p;
    		p = p.parent;
    	}
    	return p; // If root is lefr child, return it parent , is p
    }
     
    public static TreeNode mostLeft(TreeNode root){  // got the most elft node of the tree
    	if(root == null) return null;  // corner case 
    	while(root.left != null){
    		root = root.left;
    	}
    	return root;
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 2, 3, 0, 5, 6, 12, 8, 9, 10};
		TreeNode root = Solution03.createTree(nums);  // Create tree
        List<List<TreeNode>> res =  Solution03.createDepthLinkedList(root); // Reture list result 
		System.out.println("Next? " + inorderNext(root));
	}
}
