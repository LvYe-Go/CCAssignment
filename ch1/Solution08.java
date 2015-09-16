package ch1;

public class Solution08 {
    /*
     * Q： Zero Matrix: Write an algorithm such that if an element in an M * N matrix is 0, 
     * its entire row and column are set to 0. 
     * */
	
	// In place method 
	// Time: O(M * N)
	// Space: O(1) , In place 
	// Let the first column and row to store the info, then set them 
	private static void setMatrixZero(int[][] matrix, int m , int n) {
		if(matrix == null) return;
		 boolean emptyRow = false; // signal whether should set them to zero 
	     boolean emptyCol = false;
	        
	        for(int i = 0; i < n ; i ++) {
	            if(matrix[0][i] == 0){
	                emptyRow = true;  // If one is zero, flag set 
	                break;
	            }
	        }
	        
	        for(int i = 0; i < m; i++) {
	            if(matrix[i][0] == 0){
	                emptyCol = true; // If one is zero, flag set 
	                break;
	            }
	        }
	        
	        for(int i = 1; i < m; i++){
	            for(int j = 1; j< n; j++) {
	                if(matrix[i][j] == 0){
	                    matrix[0][j] = 0;  // mark col set zero lag and store it in the first row 
	                    matrix[i][0] = 0;  // mark row set zero lag and store it in the first col 
	                }
	            }
	        }
	        
	        for(int i = 1; i< m; i++) {
	            for(int j = 1; j < n; j++) {
	                if(matrix[0][j] == 0 || matrix[i][0] == 0){  // If row or col crossing the element , the element should be zero 
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        if(emptyRow) {   //  Set the first row as flag
	            for(int i = 0; i < n; i++) {
	                matrix[0][i] = 0;
	            }
	        }
	        
	        if(emptyCol) {  // set the first column as flag
	            for(int j = 0; j < m; j++) {
	                matrix[j][0] = 0;
	            }
	        }
	}
	public static void main(String[] args) {
		int[][] matrix1 = {{1}}; 
		int[][] matrix2 = {{1,0,3,0}, {0,6,0,8}, {9,10,11,12}};
		
		setMatrixZero(matrix1, 1, 1);
		setMatrixZero(matrix2, 3, 4);
		
        System.out.println("Case : 1 matrix1");
        printMatrix(matrix1, 1, 1);
        System.out.println("\n\n Case : 2 matrix2");
        printMatrix(matrix2, 3, 4);

	}
	
	private static void printMatrix(int matrix[][], int m, int n) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
