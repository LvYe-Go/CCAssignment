package ch4;

public class Solution08 {
	/*
	 * Find the first common ancestor , not necessary BST 
	 * */
	
	// Method: Recursive left and right 
	//  Time : O (n)
	// Space: O (n)
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;  // corner case 
        
        TreeNode left = lowestCommonAncestor(root.left , p, q); // left
        TreeNode right = lowestCommonAncestor(root.right, p, q); //right 
        
        if(left != null && right != null ) return root;
        if(left != null) return left;
        return right;
	}
	
	 public static void main(String[] args)
     {
		   int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		    TreeNode root = Solution02.create(nums, 0, nums.length -1); // use the files function to greate tree
			TreeNode n5 = root.find(5);
			TreeNode n9 = root.find(9);
			TreeNode an=lowestCommonAncestor(root, n5, n9);
			System.out.println(an.val);
     }
}
