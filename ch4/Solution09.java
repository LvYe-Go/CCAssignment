package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution09 {
	/**
	 * 
	 * @param node
	 * @return
	 * 
	 * Use the method from book , wave left then right 
	 * Time : O(N ^ 2 )
	 * Space: O(N ^ 2)
	 */
	public static List<LinkedList<Integer>> allSequences(TreeNode node) {
		List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {  // corner case 
			result.add(new LinkedList<Integer>());
			return result;
		} 
		
		LinkedList<Integer> visitedSeq= new LinkedList<Integer>();
		visitedSeq.add(node.val);
		
		List<LinkedList<Integer>> leftSeq = allSequences(node.left); // store the left 
		List<LinkedList<Integer>> rightSeq = allSequences(node.right); // store the right 
		
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				List<LinkedList<Integer>> coverd = new ArrayList<LinkedList<Integer>>();
				coverLists(left, right, coverd, visitedSeq);
				result.addAll(coverd);
			}
		}
		return result;
	}
	
	public static void coverLists(LinkedList<Integer> first, LinkedList<Integer> second,
								  List<LinkedList<Integer>> results,
								  LinkedList<Integer> visitedSeq
								  ) {
		// To visited the all sequence form current node 
		if (first.size() == 0 || second.size() == 0) { // corner caase 
			LinkedList<Integer> result = (LinkedList<Integer>) visitedSeq.clone();
			result.addAll(first);
			result.addAll(second); 
			results.add(result);
			return;
		}
		
		int headFirst = first.pop();  // The first part and update the visited set
		visitedSeq.addLast(headFirst);
		coverLists(first, second, results, visitedSeq);
		visitedSeq.removeLast();  // restore 
		first.addFirst(headFirst);
		
		int headSecond = second.pop(); // The second part and update the visited set
		visitedSeq.addLast(headSecond);
		coverLists(first, second, results, visitedSeq);
		visitedSeq.removeLast();	  // restore 
		second.addFirst(headSecond);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		int[] num = {0,2,3,4,5};
		for (int i = 0 ; i < num.length; i++) {
			node.insertInOrder(num[i]);
		}
		List<LinkedList<Integer>> allSeq = allSequences(node);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
	}
}
