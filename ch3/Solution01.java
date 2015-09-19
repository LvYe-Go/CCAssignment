package ch3;

public class Solution01 {
	/**
     * 
     * Q: Use a single array to implement three stacks. 
     */
	
	// Method - 1 : Use set to store 
/* *
 * Referred the method form Book 3.3 
 * Mathod:  When Pop from one stack , we need to move the element from current Stack
 * to the end
 * */
	// Time: O(1)
	// Space: O(N)
	
	private int numberOfStacks = 3; // deive into three
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public Solution01(int stackSize) { // construct 
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks]; // open the space 
		sizes = new int[numberOfStacks];
	}
	
	public void push(int stackNum, int value) {
		if(isFull(stackNum)){  // Check first whether full or not 
			System.out.println("The stack is full");
			return ;
		}
		sizes[stackNum]++;   
		values[indexOfTop(stackNum)] = value;  // push in 
	}
	
	public int pop(int stackNum) {
		if(isEmpty(stackNum)){
			System.out.println("The stack is empty");  
			return -1;
		}
		int topIndex = indexOfTop(stackNum); // find the starting index 
		int value = values[topIndex];
		values[topIndex] = 0; // clear 
		sizes[stackNum]--; // update the count 
		return value;
	}
	
	public int peek(int stackNum){
		if(isEmpty(stackNum)) {
			System.out.println("The stack is empty");
			return -1;
		}
		return values[indexOfTop(stackNum)]; // return the stack top 
	}
	
	public int indexOfTop(int stackNum) { // find the corressponding index by stackNum
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackCapacity;
	}
	
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0; 
	}
}
