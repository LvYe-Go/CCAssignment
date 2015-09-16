package ch1;

public class Solution07 {
    /*
     * Rotate Matrix: Given an image represented by an N*N matrix. 
     * rotate the image by 90 degrees. Do it in place 
     */
	
	/*
	 *  Start swap and rotate from the the most outer layer
	 * */
	// Time: O(N ^ 2)
	//Space: O(1), In place swap 
	private static void rotate(int[][] matrix, int n){
		if(matrix == null) return;  // corner cases 
		int totallevel= n / 2;
		for(int level = 0; level < totallevel; level++) {
			for(int i = level; i < n - 1 - level; i++) {
				int temp = matrix[level][i];  // store top 
				matrix[level][i] = matrix[n - i - 1][level];  // left to top
				matrix[n - i - 1][level] = matrix[n - 1 - level][n - i - 1]; // bottom to left
				matrix[n - 1 - level][n - i - 1] = matrix[i][n - 1 - level]; // right to bottom
				matrix[i][n - 1 - level] = temp; // stored top to right 
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix1 = {{1}}; 
		int[][] matrix2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		rotate(matrix1, 1);
		rotate(matrix2, 4);
		
        System.out.println("Case : 1 matrix1");
        printMatrix(matrix1, 1);
        
        System.out.println("\n\n Case : 2 matrix2");
        printMatrix(matrix2, 4);
	}
	
	private static void printMatrix(int matrix[][], int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
