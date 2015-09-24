package ch10;

public class RankNode {
	
		/**
		 * Refer to the book 
		 * Use BST to store data and show data
		 */
	
		public int leftSize = 0;
		public RankNode left, right;
		public int data = 0;
		public RankNode(int d) {
			data = d;
		}
		
		public void insert(int d) {  // insert , left smaller than right 
			if(d <= data) {
				if(left != null) left.insert(d);
				else left = new RankNode(d);
				leftSize++;  // update the size 
			}else{
				if(right != null) right.insert(d); // if still larger , insert into right
				else right = new RankNode(d);
			}
		}
		
		public int getRank(int d) {
			if(d == data) {
				return leftSize;
			}else if(d < data) {
				if(left == null) return -1;
				else return left.getRank(d);  // find on left
			}else{
				int rightRank = right == null? -1 : right.getRank(d); // find on right
				if(rightRank == -1) return -1; // if cannot find 
				else return leftSize + rightRank + 1; // the one is the count for the root
			}
		}
}
