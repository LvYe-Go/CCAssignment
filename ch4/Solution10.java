package ch4;

public class Solution10 {
	/**
	 * 
	 * @param t1
	 * @param t2
	 * Judge whether the t2 issubtree of t1 
	 * Recursive mathod , compare left and right 
	 * Time O(logN) ~ O(N^2)
	 * Space : O (n)
	 */
	public static boolean isMatch(TreeNode t1, TreeNode t2) {
		if(t2 == null) return true;
		if(t2 != null && t1 == null) return false;
		return isSubTree(t1, t2);
	}
	
	public static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if(t2 == null || t1 == null) return false;
		if(t1.val == t2.val && match(t1, t2)) return true;
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2); // The subtree in left or in right 
	}
	
	public static boolean match(TreeNode t1, TreeNode t2) {
		if(t1 ==null && t2 == null) return true;  // corner case 
		if(t1 != null || t2 == null) return false; // corner case 
		if(t1.val != t2.val) return false; // if value is not the same 
		return match(t1.left, t2.left) && match(t1.right, t2.right); // compare left and right 
	}
	
	public static void main(String[] args) {
		int[] num1 = {1, 24, 3, 10, 5, 6, 7, 8, 9, 10, 11, 12, 19};
		int[] num2 = {24, 10, 5, 8, 9, 10, 11};
		
		TreeNode t1 = Solution03.createTree(num1);
		TreeNode t2 = Solution03.createTree(num2);

		if (isMatch(t1, t2))System.out.println("t2 is a subtree of t1");
		else System.out.println("t2 is not a subtree of t1");
	}
}
