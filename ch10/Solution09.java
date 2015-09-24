package ch10;

public class Solution09 {

	/**
	 * Search in a sorted 2D matrix 
	 * Method: Two times binary search.
	 * Iterate from the top right , move the pointer to next row when value is larger than target 
	 * And move to left , if value is smaller than target.
	 * 
	 * Time: O(N +M)
	 * Space: O (N * M) store element
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
          int n = matrix.length;
          int m = matrix[0].length; 
          if(n == 0 && m == 0) return false;  // corner cases 
          
          int col = m - 1;
          int row = 0;
          
          while(col >= 0 && row < n) {  
              if(target == matrix[row][col]){  // if found return 
                  return true;
              }
              
              if(target > matrix[row][col]){
                  row++;   // move to next level 
              }
              else if(target < matrix[row][col]) {
                  col--;  // move the the left
              } 
          }
          return false;
   
   }
     
	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 20;
		System.out.println(searchMatrix(matrix, target));
	}

}
