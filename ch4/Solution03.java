package ch4;

import java.util.*;

public class Solution03 {
    /**
     * 
     * Given a binary tree, design an algorithm which create a linked list of all the nodes
     * at each depth. If you have  a tree with depth D, you'll have D linked lists
     */
   	
  // Create Tree and level travel the tree
  // Time : O(n)
	// Space: O (N)
  public static void main(String[] args) {
          int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
          TreeNode root = createTree(nums);  // Create tree
          List<List<TreeNode>> res = createDepthLinkedList(root); // Reture list result 
          printResult(res);
  }
  
   // BFS  
  public static List<List<TreeNode>> createDepthLinkedList(TreeNode root) {
	      List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
	      if(root == null) return res;  // corner cases
	      LinkedList queue = new LinkedList<TreeNode>();
	      queue.add(root);
	      int Depth = 1;  // record the depth , init one 
	      int count = 0;  // the counter for the next level 
	      int DepthNum = 1;  // the used counter on this level 
	      
	      List list = new ArrayList<TreeNode>();
	      while(!queue.isEmpty()) {
	    	  TreeNode cur = (TreeNode)
	    			  queue.poll();
	    	  DepthNum--;  
	    	  
	    	  if(cur.left != null) { // leftchild 
	    		  queue.push(cur.left);
	    		  list.add(cur.left);  // put into the list for the level 
	    		  count++;
	    	  }
	    	  if(cur.right != null) {  // right level
	    		  count++;
	    		  queue.push(cur.right);
	    		  list.add(cur.right);
	    	  }
	    	  if(DepthNum == 0) {  // If the level has been visited 
	    		  DepthNum = count;
	    		  count = 0;
	    		  res.add(new ArrayList<TreeNode>(list)); // copy new one to he result
	    		  list = new ArrayList<TreeNode>();
	    	  }
	      }
	      return res;
  }
  
  public static void printResult(List<List<TreeNode>> res){
	  if(res == null || res.size() == 0) return ; // corner cases 
      int depth = 0;
      for(List<TreeNode> entry : res) {
              Iterator<TreeNode> node = entry.listIterator();
          System.out.print("Depth " + depth + ":");
          while(node.hasNext()){
                  System.out.print(" " + node.next().val);
          }
          System.out.println();
          depth++;
      }
   }
  
  public static TreeNode createTree(int[] array) {
	  if(array == null || array.length == 0) return null; // corner cases 
		TreeNode root = new TreeNode(array[0]);
		LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
		queue.add(root); // put the first element 
		boolean done = false;
		int i = 1;
		while (!done) {
			TreeNode r = (TreeNode) queue.element();
			if (r.left == null) {
				r.left = new TreeNode(array[i]);
				i++;
				queue.add(r.left);  // to the left 
			} else if (r.right == null) {
				r.right = new TreeNode(array[i]);
				i++;
				queue.add(r.right);  // to the right 
			} else {
				queue.remove();
			}
			if (i == array.length)
				done = true;
		}
		return root;  // finish plant the tree
	}
}
