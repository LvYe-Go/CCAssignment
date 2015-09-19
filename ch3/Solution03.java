package ch3;

public class Solution03 {
   
	/*
	 * Referred  the Method form Book 3.3 
	 * 
	 * The Basic Version includes : The construct and pop, and push of SetOfStacks
	 * FOLLOW UP is also in exact the SetOfSatck Class implementation
	 * */
	
	//Q1: Time : operations at O(1) Space : O(N)
	//Q2:OLLOW UP: operations at O(N) , space O(1) 
	//   because the move from the index + 1 to the right 
	public static void main(String[] args) {
		// Basic Version 
		SetOfStacks setstack = new SetOfStacks(3); // please refer to stackSets class
		System.out.println("Basic Version Push and Pop");
		setstack.push(3); 
		setstack.push(5);
		setstack.push(6);
		setstack.push(4); //stack(2)
		setstack.push(1);
		setstack.push(9);
		setstack.push(10); // stack(3)
		System.out.println(setstack.pop()); 
		
		System.out.println("Follow UP  popAt");
		System.out.println(setstack.popAt(1)); 
	}

}
