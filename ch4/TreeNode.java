package ch4;

import java.util.Random;

/* One node of a binary tree. The val element stored is a single 
 * character.
 */
public class TreeNode {
	public int val;   
	public TreeNode root;
	public TreeNode left, right, parent;    
	public int size = 0;
	public int size(){return size;}

	public TreeNode(int v) {
		val = v;
		size = 1;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) left.parent = this;
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) right.parent = this;
	}
	
	public void insertInOrder(int v) {
		// Find the correct place to insert node 
		if (v <= val) {
			if (left == null) {
				setLeftChild(new TreeNode(v));
			} else {
				left.insertInOrder(v);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(v));
			} else {
				right.insertInOrder(v);
			}
		}
		size++;
	}
	
	
	public TreeNode find(int v) {  // search the pointed node 
		if (v == val) return this;
		
		if (v <= val) {
			return left != null ? left.find(v) : null;
		} else if (v > val) {
			return right != null ? right.find(v) : null;
		}
		return null;
	}
} 
