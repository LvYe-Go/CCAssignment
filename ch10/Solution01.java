package ch10;

public class Solution01 {
    
	/**
	 * 
	 * MergeSort:  Two sorted array A, B. A has a large enough buffer at the end to hold B. 
	 * Merge B into A in sorted order. 
	 */
	// Method from end to the start , reverse order put smaller value into A
	// move the index 
	// Pay attention to the left elements in the array 
	
	public static int[] merge(int[] A, int N, int[] B, int M){
		int index = N + M -1;
		int i = N - 1,  j = M - 1;  // start from the end
		while(i >= 0 && j >= 0) { 
			if(A[i] > B[i]){
				A[index--] = A[i--];  // put the smaller 
			}else{
				A[index--] = B[j--];
			}
		}
		while(i >= 0) A[index--] = A[i--]; // Handle with the left elements
		while(j >= 0) A[index--] = B[j--];
		return A;
		
	}
	public static void main(String[] args) {
		int N = 3;
		int M = 5;
		int[] A = new int[N + M]; 
        for(int i = 0; i < N; i++) {
        	A[i] = i;
        }
		int[] B = new int[M];
		for(int j = 0; j < M; j++) {
			B[j] = j + 3;
		}
		A = merge(A, N, B, M);
        for(int i = 0; i < N + M ; i ++) {
        	System.out.println(A[i]);
        }
	}

}
